package com.feliperocha.gameoflife.controllers

import com.feliperocha.gameoflife.domains.Cell
import com.feliperocha.gameoflife.services.GameOfLifeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/game-of-life")
class GameOfLifeController {

    @Autowired GameOfLifeService gameOfLifeService

    @RequestMapping(method=RequestMethod.PUT)
    def runStep(@RequestBody Cell[][] cells) {
        gameOfLifeService.createNextGeneration(cells)
    }

}
