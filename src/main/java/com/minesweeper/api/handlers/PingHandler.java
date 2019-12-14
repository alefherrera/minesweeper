package com.minesweeper.api.handlers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class PingHandler {

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromValue("pong"));
    }

}
