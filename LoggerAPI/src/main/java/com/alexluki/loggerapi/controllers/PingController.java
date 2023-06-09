package com.alexluki.loggerapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String sayHello(@RequestParam boolean value) {
        return String.format("Pinged value: %b!", value);
    }

}