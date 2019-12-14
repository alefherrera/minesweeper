package com.minesweeper.api.routers;

import com.minesweeper.api.handlers.GameHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GameRouter {

    @Bean
    public RouterFunction<ServerResponse> gameRoute(GameHandler gameHandler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/"), gameHandler::start)
                .andRoute(RequestPredicates.POST("/{gameId}"), gameHandler::select)
                .andRoute(RequestPredicates.POST("/{gameId}/flag"), gameHandler::flag)
                .andRoute(RequestPredicates.GET("/{gameId}"), gameHandler::getState);
    }

}
