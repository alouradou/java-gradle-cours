package org.centrale.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
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

}
