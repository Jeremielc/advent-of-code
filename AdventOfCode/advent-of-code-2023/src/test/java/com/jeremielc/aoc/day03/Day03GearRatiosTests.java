package com.jeremielc.aoc.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class Day03GearRatiosTests {
    @Test
    void testGetNumberGivenDigitPosition() {
        char[][] matrix = new char[][] {
                new char[] { '1', '2', '3', '.', '.', '.', '4', '5', '6' },
                new char[] { '.', '.', '.', '7', '8', '9', '.', '.', '.' },
                new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' },
                new char[] { '.', '1', '2', '3', '4', '.', '.', '5', '.' },
                new char[] { '.', '.', '.', '.', '.', '7', '8', '9', '.' },
        };

        assertThrows(InvalidParameterException.class, () -> Day03GearRatios.getNumberGivenDigitPosition(matrix, 0, 4));
        
        for (int x = 0; x < 3; x++) {
            assertEquals(123, Day03GearRatios.getNumberGivenDigitPosition(matrix, 0, x));
        }

        for (int x = 6; x < 9; x++) {
            assertEquals(456, Day03GearRatios.getNumberGivenDigitPosition(matrix, 0, x));
        }

        for (int x = 3; x < 6; x++) {
            assertEquals(789, Day03GearRatios.getNumberGivenDigitPosition(matrix, 1, x));
        }

        for (int x = 0; x < 9; x++) {
            assertEquals(123456789, Day03GearRatios.getNumberGivenDigitPosition(matrix, 2, x));
        }

        for (int x = 1; x < 5; x++) {
            assertEquals(1234, Day03GearRatios.getNumberGivenDigitPosition(matrix, 3, x));
        }

        assertEquals(5, Day03GearRatios.getNumberGivenDigitPosition(matrix, 3, 7));

        for (int x = 5; x < 8; x++) {
            assertEquals(789, Day03GearRatios.getNumberGivenDigitPosition(matrix, 4, x));
        }
    }
}
