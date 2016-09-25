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

    @Test
    void borderEdgeCellShouldHaveThreeNeighbors() {
        def cells = new Cell[2][2]
        cells[0][0] = new Cell(y: 0, x: 0, alive: false)
        cells[0][1] = new Cell(y: 0, x: 1, alive: false)
        cells[1][0] = new Cell(y: 1, x: 0, alive: false)
        cells[1][1] = new Cell(y: 1, x: 1, alive: false)
        def neighbors = cells[0][0].getNeighbors(cells[0][0], cells)
        assert neighbors.size().equals(3)
    }

    @Test
    void borderLeftOrRightCellShouldHaveFiveNeighbors() {
        def cells = new Cell[3][2]
        cells[0][0] = new Cell(y: 0, x: 0, alive: false)
        cells[0][1] = new Cell(y: 0, x: 1, alive: false)
        cells[1][0] = new Cell(y: 1, x: 0, alive: false)
        cells[1][1] = new Cell(y: 1, x: 1, alive: false)
        cells[2][0] = new Cell(y: 2, x: 0, alive: false)
        cells[2][1] = new Cell(y: 2, x: 1, alive: false)
        def neighbors = cells[1][0].getNeighbors(cells[1][0], cells)
        assert neighbors.size().equals(5)
    }

    @Test
    void commonCellShouldHaveEightNeighbors() {
        def cells = new Cell[3][3]
        cells[0][0] = new Cell(y: 0, x: 0, alive: false)
        cells[0][1] = new Cell(y: 0, x: 1, alive: false)
        cells[0][2] = new Cell(y: 0, x: 2, alive: false)
        cells[1][0] = new Cell(y: 1, x: 0, alive: false)
        cells[1][1] = new Cell(y: 1, x: 1, alive: false)
        cells[1][2] = new Cell(y: 1, x: 2, alive: false)
        cells[2][0] = new Cell(y: 2, x: 0, alive: false)
        cells[2][1] = new Cell(y: 2, x: 1, alive: false)
        cells[2][2] = new Cell(y: 2, x: 2, alive: false)
        def neighbors = cells[1][1].getNeighbors(cells[1][1], cells)
        assert neighbors.size().equals(8)
    }
}

