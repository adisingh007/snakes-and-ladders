package com.snake.and.ladders.game;

import java.util.Map;

public class Game {
    private final String[] playerNames;
    private final Map<Integer, Integer> snakesMap;
    private final Map<Integer, Integer> laddersMap;

    public Game(final String[] playerNames, final Map<Integer, Integer> snakesMap, final Map<Integer, Integer> laddersMap) {
        this.playerNames = playerNames;
        this.snakesMap = snakesMap;
        this.laddersMap = laddersMap;
    }

    public void start() {

    }
}
