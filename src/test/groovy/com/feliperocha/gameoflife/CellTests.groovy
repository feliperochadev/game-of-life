package com.feliperocha.gameoflife

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import com.feliperocha.gameoflife.domains.Cell

@RunWith(SpringRunner)
@SpringBootTest
class CellTests {

    @Test
    void killACell()
    {
        def cell = new Cell(y: 1, x: 1, alive: true)
        cell.die()
        assert !cell.alive
    }

    @Test
    void liveACell()
    {
        def cell = new Cell(y: 1, x: 1, alive: false)
        cell.live()
        assert cell.alive
    }

    @Test
    void cellWithThreeNeighborsMustLive()
    {
        def neighbors = new ArrayList<Cell>()
        neighbors.add(new Cell(y: 0, x: 0, alive: false))
        neighbors.add(new Cell(y: 0, x: 1, alive: false))
        neighbors.add(new Cell(y: 0, x: 2, alive: false))
        neighbors.add(new Cell(y: 1, x: 0, alive: false))
        neighbors.add(new Cell(y: 1, x: 2, alive: false))
        neighbors.add(new Cell(y: 2, x: 0, alive: true))
        neighbors.add(new Cell(y: 2, x: 1, alive: true))
        neighbors.add(new Cell(y: 2, x: 2, alive: true))

        def cell = new Cell(y: 1, x: 1, alive: false)
        cell.checkIfLiveOrDie(cell, neighbors)
        assert cell.alive
    }

    @Test
    void cellWithLessThanTwoNeighborsMustDie()
    {
        def neighbors = new ArrayList<Cell>()
        neighbors.add(new Cell(y: 0, x: 0, alive: false))
        neighbors.add(new Cell(y: 0, x: 1, alive: false))
        neighbors.add(new Cell(y: 0, x: 2, alive: false))
        neighbors.add(new Cell(y: 1, x: 0, alive: false))
        neighbors.add(new Cell(y: 1, x: 2, alive: false))
        neighbors.add(new Cell(y: 2, x: 0, alive: false))
        neighbors.add(new Cell(y: 2, x: 1, alive: true))
        neighbors.add(new Cell(y: 2, x: 2, alive: false))

        def cell = new Cell(y: 1, x: 1, alive: true)
        cell.checkIfLiveOrDie(cell, neighbors)
        assert !cell.alive
    }

    @Test
    void cellWithMoreThanThreeNeighborsMustDie()
    {
        def neighbors = new ArrayList<Cell>()
        neighbors.add(new Cell(y: 0, x: 0, alive: false))
        neighbors.add(new Cell(y: 0, x: 1, alive: false))
        neighbors.add(new Cell(y: 0, x: 2, alive: false))
        neighbors.add(new Cell(y: 1, x: 0, alive: false))
        neighbors.add(new Cell(y: 1, x: 2, alive: true))
        neighbors.add(new Cell(y: 2, x: 0, alive: true))
        neighbors.add(new Cell(y: 2, x: 1, alive: true))
        neighbors.add(new Cell(y: 2, x: 2, alive: true))

        def cell = new Cell(y: 1, x: 1, alive: true)
        cell.checkIfLiveOrDie(cell, neighbors)
        assert !cell.alive
    }
}

