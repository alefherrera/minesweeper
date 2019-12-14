package com.minesweeper.api.handlers;

import com.minesweeper.api.payloads.StartGamePayload;
import com.minesweeper.api.responses.Board;
import com.minesweeper.api.responses.GameResponse;
import com.minesweeper.api.responses.IdResponse;
import com.minesweeper.core.Game;
import com.minesweeper.core.Position;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class GameHandler {

    public static final String GAME_ID = "gameId";
    private static Map<String, Game> gameMap = new ConcurrentHashMap<>();

    public Mono<ServerResponse> start(ServerRequest request) {
        final String id = UUID.randomUUID().toString();
        final Mono<StartGamePayload> startGamePayloadMono = request.bodyToMono(StartGamePayload.class);
        return startGamePayloadMono.flatMap(startGamePayload -> {
            final Game game = new Game(startGamePayload.getRows(), startGamePayload.getColumns());
            startGamePayload.getMines().forEach(game::addMine);
            gameMap.put(id, game);
            return ServerResponse.ok().body(BodyInserters.fromValue(new IdResponse(id)));
        });
    }

    public Mono<ServerResponse> getState(ServerRequest request) {
        final String gameId = getGameId(request);
        if (!gameMap.containsKey(gameId)) {
            return ServerResponse.notFound().build();
        }
        final Game game = gameMap.get(gameId);
        return ServerResponse.ok().body(BodyInserters.fromValue(getGameResponse(game)));
    }

    public Mono<ServerResponse> select(ServerRequest request) {
        final String gameId = getGameId(request);
        if (!gameMap.containsKey(gameId)) {
            return ServerResponse.notFound().build();
        }
        final Game game = gameMap.get(gameId);
        final Mono<Position> positionMono = request.bodyToMono(Position.class);
        return positionMono.flatMap(position -> {
            game.select(position);
            return ServerResponse.ok().body(BodyInserters.fromValue(getGameResponse(game)));
        });
    }

    public Mono<ServerResponse> flag(ServerRequest request) {
        final String gameId = getGameId(request);
        if (!gameMap.containsKey(gameId)) {
            return ServerResponse.notFound().build();
        }
        final Game game = gameMap.get(gameId);
        final Mono<Position> positionMono = request.bodyToMono(Position.class);
        return positionMono.flatMap(position -> {
            game.flag(position);
            return ServerResponse.ok().body(BodyInserters.fromValue(getGameResponse(game)));
        });
    }

    private String getGameId(final ServerRequest request) {
        return request.pathVariable(GAME_ID);
    }

    private GameResponse getGameResponse(final Game game) {
        return new GameResponse(game.getStatus(), new Board(game.getCells(), game.getRows(), game.getColumns()));
    }

}
