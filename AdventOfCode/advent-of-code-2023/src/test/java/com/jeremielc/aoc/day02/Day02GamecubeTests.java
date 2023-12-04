package com.jeremielc.aoc.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jeremielc.aoc.utils.InputDataUtils;

public class Day02GamecubeTests {
    private static final List<String> dataInputs = new ArrayList<>();

    @BeforeAll
    public static void loadTestInputs() {
        dataInputs.addAll(InputDataUtils
                .readDataFrom(Day02GamecubeTests.class.getResourceAsStream("/Day-02-Puzzle-1-Test-Input.txt")));
        assertEquals(5, dataInputs.size());
    }

    @Test
    public void testParseGameInput() {
        // Check correct number of draw to be read.
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(0)).size());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(1)).size());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(2)).size());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(3)).size());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(4)).size());

        // Check each draw is associated to the correct game number.
        for (int i = 0; i < 5; i++) {
            for (GameResult gr : Day02Gamecube.parseGameInput(dataInputs.get(i))) {
                assertEquals(i + 1, gr.id());
            }
        }

        // Check parsing of each draws.
        assertEquals(4, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(0).redCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(0).greenCubes());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(0).blueCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(1).redCubes());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(1).greenCubes());
        assertEquals(6, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(1).blueCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(2).redCubes());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(2).greenCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(0)).get(2).blueCubes());

        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(0).redCubes());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(0).greenCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(0).blueCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(1).redCubes());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(1).greenCubes());
        assertEquals(4, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(1).blueCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(2).redCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(2).greenCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(1)).get(2).blueCubes());

        assertEquals(20, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(0).redCubes());
        assertEquals(8, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(0).greenCubes());
        assertEquals(6, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(0).blueCubes());
        assertEquals(4, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(1).redCubes());
        assertEquals(13, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(1).greenCubes());
        assertEquals(5, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(1).blueCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(2).redCubes());
        assertEquals(5, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(2).greenCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(2)).get(2).blueCubes());

        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(0).redCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(0).greenCubes());
        assertEquals(6, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(0).blueCubes());
        assertEquals(6, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(1).redCubes());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(1).greenCubes());
        assertEquals(0, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(1).blueCubes());
        assertEquals(14, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(2).redCubes());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(2).greenCubes());
        assertEquals(15, Day02Gamecube.parseGameInput(dataInputs.get(3)).get(2).blueCubes());

        assertEquals(6, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(0).redCubes());
        assertEquals(3, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(0).greenCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(0).blueCubes());
        assertEquals(1, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(1).redCubes());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(1).greenCubes());
        assertEquals(2, Day02Gamecube.parseGameInput(dataInputs.get(4)).get(1).blueCubes());
    }

    @Test
    public void testParseGameInputs() {
        assertEquals(3, Day02Gamecube.parseGameInputs(List.of(dataInputs.get(0))).size());
        assertEquals(3, Day02Gamecube.parseGameInputs(List.of(dataInputs.get(1))).size());
        assertEquals(3, Day02Gamecube.parseGameInputs(List.of(dataInputs.get(2))).size());
        assertEquals(3, Day02Gamecube.parseGameInputs(List.of(dataInputs.get(3))).size());
        assertEquals(2, Day02Gamecube.parseGameInputs(List.of(dataInputs.get(4))).size());

        assertEquals(14, Day02Gamecube.parseGameInputs(dataInputs).size());
    }

    @Test
    public void testGetPossibleGameResultsForConfig() {
        List<GameResult> results = Day02Gamecube.parseGameInputs(dataInputs);

        assertEquals(0, Day02Gamecube.getPossibleGameResultsForConfig(results, 0, 0, 0).size());
        assertEquals(5, Day02Gamecube.getPossibleGameResultsForConfig(results, 20, 20, 20).size());
        assertEquals(3, Day02Gamecube.getPossibleGameResultsForConfig(results, 6, 6, 6).size());
        assertEquals(3, Day02Gamecube.getPossibleGameResultsForConfig(results, 6, 3, 6).size());
    }
}
