package com.snake.and.ladders.game;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Game {
    private final String[] playerNames;
    private final Map<Integer, Integer> playerPosition;
    private final Map<Integer, Integer> snakesMap;
    private final Map<Integer, Integer> laddersMap;

    public Game(final String[] playerNames, final Map<Integer, Integer> snakesMap, final Map<Integer, Integer> laddersMap) {
        this.playerNames = playerNames;
        this.playerPosition = new HashMap<>() {{
            IntStream.range(0, playerNames.length).forEach(i -> put(i, 0));
        }};
        this.snakesMap = snakesMap;
        this.laddersMap = laddersMap;
    }

    public void start() {
        int i = 0;
        while(true) {
            int move = (int) ((Math.random() * 5) + 1);
            int initial = playerPosition.get(i);
            int next = initial + move;

            if (next <= 100) {
                System.out.println(playerNames[i] + " rolled a " + move + " and moved from " + initial + " to " + next);
                if (snakesMap.containsKey(next)) {
                    System.out.println(playerNames[i] + " was bit by a snake at " + next + " and moved to " + snakesMap.get(next));
                    next = snakesMap.get(next);
                }
                if (laddersMap.containsKey(next)) {
                    System.out.println(playerNames[i] + " climbed the ladder and moved from " + next + " to " + laddersMap.get(next));
                    next = laddersMap.get(next);
                }

                playerPosition.put(i, next);
                if (playerPosition.get(i) == 100) {
                    System.out.println(playerNames[i] + " won the game!");
                    break;
                }
                if (move == 6) {
                    System.out.println("Since " + playerNames[i] + " rolled a 6, " + playerNames[i] + " will play again!");
                    i--;
                }
            } else {
                System.out.println(playerNames[i] + " rolled a " + move + " but cannot move beyond 100 from " + playerPosition.get(i));
            }
            i++;
            if(i == playerPosition.size()) i = 0;
        }
    }
}
