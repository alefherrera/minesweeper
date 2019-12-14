package com.minesweeper.core;

import org.junit.jupiter.api.Test;

import static com.minesweeper.core.Constants.MINE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void test2x2() {
        final Game game = new Game(2, 2);
        game.addMine(new Position(0, 0));
        final Cell cell = game.getCell(new Position(0, 0));
        assertEquals(MINE, cell.getValue());
    }

    @Test
    void testSelect2x2() {
        final Game game = new Game(2, 2);
        game.addMine(new Position(0, 0));
        game.select(new Position(0, 1));
        final Cell cell = game.getCell(new Position(0, 1));
        assertEquals("1", cell.getValue());
        assertTrue(cell.isRevealed());
    }

}