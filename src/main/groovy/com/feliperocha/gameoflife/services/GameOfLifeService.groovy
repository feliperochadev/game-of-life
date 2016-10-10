package com.feliperocha.gameoflife.services

import com.feliperocha.gameoflife.domains.Cell
import org.springframework.stereotype.Service

@Service
class GameOfLifeService {

    Cell[][] createNextGeneration(Cell[][] cells)
    {
        def nextGeneration = new Cell[cells.length][cells[0].length]
        for ( int y = 0 ; y < cells.length ; y++) {
            def rowCell = cells[y]
            for ( int x = 0 ; x < cells[y].length ; x++ ) {
                def cell = new Cell(y: rowCell[x].y, x: rowCell[x].x, alive: rowCell[x].alive)
                def neighbors = cell.getNeighbors(cell, cells)
                cell.checkIfLiveOrDie(cell, neighbors)
                nextGeneration[y][x] = cell
            }
        }
        nextGeneration
    }
}
