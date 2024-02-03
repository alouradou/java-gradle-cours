package org.centrale.api.controller;

import org.centrale.domain.tourniquet.TourniquetMetro;
import org.centrale.api.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExampleController {

    CacheService cacheService;

    public ExampleController(CacheService cacheService){
        this.cacheService = cacheService;
    }

    @GetMapping("test")
    public String play(@RequestParam String param){
        return param;
    }

    @PostMapping("test")
    public String playPost(@RequestParam String param){
        return param;
    }

    @GetMapping("test2")
    public String play2(@RequestParam String user, @RequestParam String age){
        return "Hello " + user + "! Tu as " + age + " an" + (Integer.parseInt(age) > 1 ? "s" : "") + " !";
    }

    @GetMapping("class")
    public TourniquetMetro printClass(){
        return new TourniquetMetro();
    }

    @PostMapping("/caching/add")
    public void add(@RequestParam String s){
        cacheService.add(s);
    }

    @GetMapping("/caching")
    public String getList(){
        return cacheService.get().toString();
    }

}
