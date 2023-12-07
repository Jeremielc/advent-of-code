package com.jeremielc.aoc.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeremielc.aoc.utils.InputDataUtils;

public class Day02CubeConundrum {
    private static String RED_KEY = "red";
    private static String GREEN_KEY = "green";
    private static String BLUE_KEY = "blue";
    private static String GAME_KEY = "Game";

    public static void main(String[] args) {
        List<String> dataInputs = InputDataUtils
                .readDataFrom(Day02CubeConundrum.class.getResourceAsStream("/Day-02-Puzzle-1-Input.txt"));
        Map<Integer, List<GameResult>> gameResults = parseGameInputs(dataInputs);

        // ######## PUZZLE #1 ########
        int sum = getPossibleGameResultsForConfig(gameResults, 12, 13, 14).stream()
                .reduce(0, (acc, item) -> acc + item);

        System.out.println("DAY 02 - Puzzle 1 answer is: " + sum);

        // ######## PUZZLE #2 ########
        int sumOfPowers = getMinimumSetsOfCubes(gameResults).stream()
                .map(item -> item.redCubes() * item.greenCubes() * item.blueCubes())
                .reduce(0, (subtotal, element) -> subtotal + element);

        System.out.println("DAY 02 - Puzzle 2 answer is: " + sumOfPowers);
    }

    public static Map<Integer, List<GameResult>> parseGameInputs(List<String> gameInputs) {
        Map<Integer, List<GameResult>> gameResults = new HashMap<>();
        List<GameResult> results = null;

        for (String gameInput : gameInputs) {
            results = parseGameInput(gameInput);

            for (GameResult result : results) {
                if (!gameResults.containsKey(result.id())) {
                    gameResults.put(result.id(), new ArrayList<>());
                }

                gameResults.get(result.id()).add(result);
            }
        }

        return gameResults;
    }

    public static List<GameResult> parseGameInput(String rawGameInput) {
        List<GameResult> gameResults = new ArrayList<>();

        String noSpaceInput = rawGameInput.trim().replaceAll(" ", "");
        String[] parts = noSpaceInput.split(":");

        int gameId = Integer.parseInt(parts[0].replace(GAME_KEY, ""));

        for (String game : parts[1].toLowerCase().split(";")) {
            int red = 0, green = 0, blue = 0;

            for (String draw : game.split(",")) {
                if (draw.contains(RED_KEY)) {
                    red = Integer.parseInt(draw.replace(RED_KEY, ""));
                } else if (draw.contains(GREEN_KEY)) {
                    green = Integer.parseInt(draw.replace(GREEN_KEY, ""));
                } else if (draw.contains(BLUE_KEY)) {
                    blue = Integer.parseInt(draw.replace(BLUE_KEY, ""));
                }
            }

            gameResults.add(new GameResult(gameId, red, green, blue));
        }

        return gameResults;
    }

    public static List<Integer> getPossibleGameResultsForConfig(Map<Integer, List<GameResult>> gameResults, int redCubesCount,
            int greenCubesCount, int blueCubesCount) {
        List<Integer> possibleGameIds = new ArrayList<>();

        for (int gameId : gameResults.keySet()) {
            if (gameResults.get(gameId).stream()
                    .allMatch(item -> item.redCubes() <= redCubesCount && item.greenCubes() <= greenCubesCount
                            && item.blueCubes() <= blueCubesCount)) {
                possibleGameIds.add(gameId);
            }
        }

        return possibleGameIds;
    }

    public static List<GameResult> getMinimumSetsOfCubes(Map<Integer, List<GameResult>> gameResults) {
        List<GameResult> minSetsOfCubes = new ArrayList<>();
        int red = 0, green = 0, blue = 0;

        for (int gameId : gameResults.keySet()) {
            for (GameResult gr : gameResults.get(gameId)) {
                red = gr.redCubes() > red ? gr.redCubes() : red;
                green = gr.greenCubes() > green ? gr.greenCubes() : green;
                blue = gr.blueCubes() > blue ? gr.blueCubes() : blue;
            }

            minSetsOfCubes.add(new GameResult(gameId, red, green, blue));

            red = 0;
            green = 0;
            blue = 0;
        }

        return minSetsOfCubes;
    }
}
