import com.snake.and.ladders.game.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSnakes = sc.nextInt();
        Map<Integer, Integer> snakesMap = new HashMap<>();
        IntStream.range(0, numberOfSnakes).forEach(i -> snakesMap.put(sc.nextInt(), sc.nextInt()));

        int numberOfLadders = sc.nextInt();
        Map<Integer, Integer> laddersMap = new HashMap<>();
        IntStream.range(0, numberOfLadders).forEach(i -> laddersMap.put(sc.nextInt(), sc.nextInt()));

        int numberOfPlayers = sc.nextInt();
        String[] playerNames = new String[numberOfPlayers];
        sc.nextLine();
        IntStream.range(0, numberOfPlayers).forEach(i -> playerNames[i] = sc.nextLine());

        sc.close();

        new Game(playerNames, snakesMap, laddersMap).start();
    }
}
