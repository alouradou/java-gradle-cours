package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
@AllArgsConstructor
public class PlayController {


    final GameService gameService;

    @PostMapping
    public void play(@RequestParam Long player1Id, @RequestParam Long player2Id){
        gameService.play(player1Id, player2Id);
    }

}
