package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

    final PlayerDBService playerDBService;

    @PostMapping("")
    public void addPlayer(@RequestParam String name){
        playerDBService.addNewPlayer(name);
    }

    @GetMapping("/list")
    public String getPlayerList(){
        return playerDBService.getPlayers();
    }



}
