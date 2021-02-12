package com.poc.home.smart.weatherservingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/hello/{message}")
    public String sayHello(
            @PathVariable("message") String message){
        return "Hello, " + message;
    }

}
