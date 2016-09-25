package com.feliperocha.gameoflife

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import com.feliperocha.gameoflife.domains.Cell
import com.feliperocha.gameoflife.services.GameOfLifeService

@RunWith(SpringRunner)
@SpringBootTest
class GameOfLifeServiceTests {

    @Autowired GameOfLifeService gameOfLifeServices

    @Test
    void run10Generations() {
        def cells = new Cell[5][5]
        cells[0][0] = new Cell(y: 0, x: 0, alive: true)
        cells[0][1] = new Cell(y: 0, x: 1, alive: false)
        cells[0][2] = new Cell(y: 0, x: 2, alive: false)
        cells[0][3] = new Cell(y: 0, x: 3, alive: true)
        cells[0][4] = new Cell(y: 0, x: 4, alive: false)
        cells[1][0] = new Cell(y: 1, x: 0, alive: false)
        cells[1][1] = new Cell(y: 1, x: 1, alive: true)
        cells[1][2] = new Cell(y: 1, x: 2, alive: false)
        cells[1][3] = new Cell(y: 1, x: 3, alive: true)
        cells[1][4] = new Cell(y: 1, x: 4, alive: true)
        cells[2][0] = new Cell(y: 2, x: 0, alive: false)
        cells[2][1] = new Cell(y: 2, x: 1, alive: false)
        cells[2][2] = new Cell(y: 2, x: 2, alive: true)
        cells[2][3] = new Cell(y: 2, x: 3, alive: false)
        cells[2][4] = new Cell(y: 2, x: 4, alive: true)
        cells[3][0] = new Cell(y: 3, x: 0, alive: true)
        cells[3][1] = new Cell(y: 3, x: 1, alive: false)
        cells[3][2] = new Cell(y: 3, x: 2, alive: false)
        cells[3][3] = new Cell(y: 3, x: 3, alive: false)
        cells[3][4] = new Cell(y: 3, x: 4, alive: false)
        cells[4][0] = new Cell(y: 4, x: 0, alive: true)
        cells[4][1] = new Cell(y: 4, x: 1, alive: false)
        cells[4][2] = new Cell(y: 4, x: 2, alive: false)
        cells[4][3] = new Cell(y: 4, x: 3, alive: false)
        cells[4][4] = new Cell(y: 4, x: 4, alive: false)
        int i = 0
        (0..9).each {
            gameOfLifeServices.createNextGeneration(cells)
            i++
        }
        assert i == 10
    }

}
