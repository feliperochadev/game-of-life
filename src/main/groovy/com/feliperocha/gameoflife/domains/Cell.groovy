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
}
