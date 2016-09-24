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
