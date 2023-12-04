package com.jeremielc.aoc.day02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.jeremielc.aoc.utils.InputDataUtils;

public class Day02Gamecube {
    private static String RED_KEY = "red";
    private static String GREEN_KEY = "green";
    private static String BLUE_KEY = "blue";
    private static String GAME_KEY = "Game";

    public static void main(String[] args) {
        List<String> dataInputs = InputDataUtils.readDataFrom(Day02Gamecube.class.getResourceAsStream("/Day-02-Puzzle-1-Input.txt"));
        List<GameResult> gameResults = parseGameInputs(dataInputs);
        
        AtomicInteger sum = new AtomicInteger();
        getPossibleGameResultsForConfig(gameResults, 12, 13, 14).forEach(sum::getAndAdd);

        System.out.println("DAY 02 - Puzzle 1 answer is: " + sum.get());
    }

    public static List<GameResult> parseGameInputs(List<String> gameInputs) {
        List<GameResult> gameResults = new ArrayList<>();

        for (String gameInput : gameInputs) {
            gameResults.addAll(parseGameInput(gameInput));
        }

        return gameResults;
    }

    public static List<GameResult> parseGameInput(String gameInput) {
        List<GameResult> gameResults = new ArrayList<>();

        String noSpaceInput = gameInput.trim().replaceAll(" ", "");
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

    public static List<Integer> getPossibleGameResultsForConfig(List<GameResult> gameResults, int redCubesCount, int greenCubesCount, int blueCubesCount) {
        List<Integer> possibleGameIds = new ArrayList<>();

        Set<Integer> gameIds = new HashSet<>();
        gameResults.forEach(item -> gameIds.add(item.id()));

        for (int gameId : gameIds) {
            if (gameResults.stream().filter(item -> item.id() == gameId).allMatch(item -> item.redCubes() <= redCubesCount && item.greenCubes() <= greenCubesCount && item.blueCubes() <= blueCubesCount)) {
                possibleGameIds.add(gameId);
            }
        }

        return possibleGameIds;
    }
}
