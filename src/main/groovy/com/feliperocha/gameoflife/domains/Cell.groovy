package com.feliperocha.gameoflife.domains


class Cell {
    Integer x
    Integer y
    Boolean alive

    void die() {
        this.alive = false
    }

    void live() {
        this.alive = true
    }

    ArrayList<Cell> getNeighbors(Cell cell, Cell[][] cells) {
        def neighbors = new ArrayList<Cell>()
        //Above columns
        if (cell.y > 0) {
            //Above left
            if (cell.x > 0) {
                neighbors.add(cells[cell.y - 1][cell.x - 1])
            }
            //Above
            neighbors.add(cells[cell.y - 1][cell.x])
            //Above right
            if (cell.x < cells[0].length - 1) {
                neighbors.add(cells[cell.y - 1][cell.x + 1])
            }
        }
        //Inline Left
        if (cell.x > 0) {
            neighbors.add(cells[cell.y][cell.x - 1])
        }
        //Inline Right
        if (cell.x < cells[0].length - 1) {
            neighbors.add(cells[cell.y][cell.x + 1])
        }
        //Below columns
        if (cell.y < cells.length - 1) {
            //Below left
            if (cell.x > 0) {
                neighbors.add(cells[cell.y + 1][cell.x - 1])
            }
            //Below
            neighbors.add(cells[cell.y + 1][cell.x])
            //Below right
            if (cell.x < cells[0].length - 1) {
                neighbors.add(cells[cell.y + 1][cell.x + 1])
            }
        }
        neighbors
    }

    void checkIfLiveOrDie(Cell cell, ArrayList<Cell> neighbors) {
        def countNeighborsAlive = neighbors.count { it.alive }
        if (countNeighborsAlive < 2 || countNeighborsAlive > 3) {
            cell.die()
        } else if (countNeighborsAlive == 3) {
            cell.live()
        }
    }
}
