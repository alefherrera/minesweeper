package com.minesweeper.api.routers;

import com.minesweeper.api.handlers.PingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PingRouter {

    @Bean
    public RouterFunction<ServerResponse> pingRoute(PingHandler pingHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/ping"), pingHandler::get);
    }

}
