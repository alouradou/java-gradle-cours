package org.centrale.api.controller;

import lombok.AllArgsConstructor;
import org.centrale.api.service.PlayerDBService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {

    final PlayerDBService playerDBService;

    @GetMapping("")
    public String gameUsage(){
        return "Usage : POST /player?name=<name> pour ajouter un joueur\n" +
                "GET /player/<id> pour obtenir un joueur\n" +
                "GET /player/list pour obtenir la liste des joueurs";
    }

    @PostMapping("")
    public void addPlayer(@RequestParam String name){
        playerDBService.addNewPlayer(name);
    }

    @GetMapping("/{id}")
    public String getPlayer(@PathVariable Long id){
        return "id : " + id.toString() + ", Nom : " + playerDBService.getPlayerEntity(id).getName() + "\n";
    }

    @GetMapping("/list")
    public String getPlayerList(){
        return playerDBService.getPlayers();
    }



}
