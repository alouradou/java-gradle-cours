package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

    final PlayerDBService playerDBService;

    @PostMapping("/add")
    public void addPlayer(@RequestParam String name){
        playerDBService.addNewPlayer(name);
    }



}
