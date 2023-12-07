package com.jeremielc.aoc.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jeremielc.aoc.utils.InputDataUtils;

class Day02CubeConundrumTests {
    private static final List<String> dataInputs = new ArrayList<>();
    private static final List<GameResult> knownMinSetsOfCubes = new ArrayList<>();

    @BeforeAll
    static void loadTestInputs() {
        dataInputs.addAll(InputDataUtils
                .readDataFrom(Day02CubeConundrumTests.class.getResourceAsStream("/Day-02-Puzzle-1-Test-Input.txt")));

        assertEquals(5, dataInputs.size());

        knownMinSetsOfCubes.add(new GameResult(1, 4, 2, 6));
        knownMinSetsOfCubes.add(new GameResult(2, 1, 3, 4));
        knownMinSetsOfCubes.add(new GameResult(3, 20, 13, 6));
        knownMinSetsOfCubes.add(new GameResult(4, 14, 3, 15));
        knownMinSetsOfCubes.add(new GameResult(5, 6, 3, 2));

        assertEquals(5, knownMinSetsOfCubes.size());
    }

    @Test
    void testParseGameInput() {
        // Check correct number of draw to be read.
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).size());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).size());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).size());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).size());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).size());

        // Check each draw is associated to the correct game number.
        for (int i = 0; i < 5; i++) {
            for (GameResult gr : Day02CubeConundrum.parseGameInput(dataInputs.get(i))) {
                assertEquals(i + 1, gr.id());
            }
        }

        // Check parsing of each draws.
        assertEquals(4, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(0).redCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(0).greenCubes());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(0).blueCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(1).redCubes());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(1).greenCubes());
        assertEquals(6, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(1).blueCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(2).redCubes());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(2).greenCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(0)).get(2).blueCubes());

        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(0).redCubes());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(0).greenCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(0).blueCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(1).redCubes());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(1).greenCubes());
        assertEquals(4, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(1).blueCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(2).redCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(2).greenCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(1)).get(2).blueCubes());

        assertEquals(20, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(0).redCubes());
        assertEquals(8, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(0).greenCubes());
        assertEquals(6, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(0).blueCubes());
        assertEquals(4, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(1).redCubes());
        assertEquals(13, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(1).greenCubes());
        assertEquals(5, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(1).blueCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(2).redCubes());
        assertEquals(5, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(2).greenCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(2)).get(2).blueCubes());

        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(0).redCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(0).greenCubes());
        assertEquals(6, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(0).blueCubes());
        assertEquals(6, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(1).redCubes());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(1).greenCubes());
        assertEquals(0, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(1).blueCubes());
        assertEquals(14, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(2).redCubes());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(2).greenCubes());
        assertEquals(15, Day02CubeConundrum.parseGameInput(dataInputs.get(3)).get(2).blueCubes());

        assertEquals(6, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(0).redCubes());
        assertEquals(3, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(0).greenCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(0).blueCubes());
        assertEquals(1, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(1).redCubes());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(1).greenCubes());
        assertEquals(2, Day02CubeConundrum.parseGameInput(dataInputs.get(4)).get(1).blueCubes());
    }

    @Test
    void testParseGameInputs() {
        assertEquals(5, Day02CubeConundrum.parseGameInputs(dataInputs).keySet().size());

        assertEquals(3, Day02CubeConundrum.parseGameInputs(List.of(dataInputs.get(0))).get(1).size());
        assertEquals(3, Day02CubeConundrum.parseGameInputs(List.of(dataInputs.get(1))).get(2).size());
        assertEquals(3, Day02CubeConundrum.parseGameInputs(List.of(dataInputs.get(2))).get(3).size());
        assertEquals(3, Day02CubeConundrum.parseGameInputs(List.of(dataInputs.get(3))).get(4).size());
        assertEquals(2, Day02CubeConundrum.parseGameInputs(List.of(dataInputs.get(4))).get(5).size());
    }

    @Test
    void testGetPossibleGameResultsForConfig() {
        Map<Integer, List<GameResult>> results = Day02CubeConundrum.parseGameInputs(dataInputs);

        assertEquals(0, Day02CubeConundrum.getPossibleGameResultsForConfig(results, 0, 0, 0).size());
        assertEquals(5, Day02CubeConundrum.getPossibleGameResultsForConfig(results, 20, 20, 20).size());
        assertEquals(3, Day02CubeConundrum.getPossibleGameResultsForConfig(results, 6, 6, 6).size());
        assertEquals(3, Day02CubeConundrum.getPossibleGameResultsForConfig(results, 6, 3, 6).size());
    }

    @Test
    void testGetMinimumSetsOfCubes() {
        List<GameResult> minSetsOfCubes = Day02CubeConundrum
                .getMinimumSetsOfCubes(Day02CubeConundrum.parseGameInputs(dataInputs));

        for (int i = 0; i < 5; i++) {
            assertEquals(knownMinSetsOfCubes.get(i), minSetsOfCubes.get(i));
        }
    }
}
