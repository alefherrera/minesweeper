package com.minesweeper.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PingController {

    @GetMapping("ping")
    public Mono<String> get() {
        return Mono.just("pong");
    }

}
