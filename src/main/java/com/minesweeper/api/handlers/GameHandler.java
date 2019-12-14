package com.minesweeper.api.handlers;

import com.minesweeper.api.response.GameResponse;
import com.minesweeper.api.response.IdResponse;
import com.minesweeper.core.Game;
import com.minesweeper.core.Position;
import lombok.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GameHandler {

    public static final String GAME_ID = "gameId";
    private static Map<String, Game> gameMap = new HashMap<>();

    public Mono<ServerResponse> start(ServerRequest request) {
        final String id = UUID.randomUUID().toString();
        final Game game = new Game(3, 3);
        gameMap.put(id, game);
        return ServerResponse.ok().body(BodyInserters.fromValue(new IdResponse(id)));
    }

    public Mono<ServerResponse> getState(ServerRequest request) {
        final String gameId = request.pathVariable(GAME_ID);
        if (!gameMap.containsKey(gameId)) {
            return ServerResponse.notFound().build();
        }
        final Game game = gameMap.get(gameId);
        return ServerResponse.ok().body(BodyInserters.fromValue(game.getBoard()));
    }

    public Mono<ServerResponse> select(ServerRequest request) {
        final String gameId = request.pathVariable(GAME_ID);
        final Game game = gameMap.get(gameId);
        final Mono<Position> positionMono = request.bodyToMono(Position.class);
        return positionMono.flatMap(position -> {
            game.select(position);
            final GameResponse gameResponse = new GameResponse(game.getStatus(), game.getBoard());
            return ServerResponse.ok().body(BodyInserters.fromValue(gameResponse));
        });
    }

}
