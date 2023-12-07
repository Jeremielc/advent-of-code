package com.jeremielc.aoc.day03;

import java.security.InvalidParameterException;
import java.util.List;

import com.jeremielc.aoc.utils.InputDataUtils;

public class Day03GearRatios {
    public static void main(String[] args) {
        List<String> lines = InputDataUtils
                .readDataFrom(Day03GearRatios.class.getResourceAsStream("/Day-03-Puzzle-1-Input.txt"));

        int rowCount = lines.size();
        int colCount = lines.get(0).length();
        char[][] matrix = new char[rowCount][colCount];

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            String line = lines.get(rowIndex);

            for (int colIndex = 0; colIndex < colCount; colIndex++) {
                matrix[rowIndex][colIndex] = line.charAt(colIndex);
            }
        }
    }

    public static int getNumberGivenDigitPosition(char[][] matrix, int y, int x) throws InvalidParameterException {
        if (!Character.isDigit(matrix[y][x])) {
            throw new InvalidParameterException(
                    "Provided coordinates [y=" + y + ", x=" + x + "] don't point to a digit."
                            + "\nFound value was: '" + matrix[y][x] + "'.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(matrix[y][x]);

        int rightOffset = 0, leftOffset = 0, rightPos = x, leftPos = x;

        while (rightOffset >= 0 || leftOffset >= 0) {
            // Right check
            if (rightOffset >= 0) {
                rightOffset++;
                rightPos = x - rightOffset >= 0 ? x - rightOffset : rightPos;

                if (Character.isDigit(matrix[y][rightPos])) {
                    if (rightPos != x - rightOffset) {
                        // If we've reach the far right side, we don't check right side anymore.
                        rightOffset = -1;
                    } else {
                        sb.insert(0, matrix[y][rightPos]);
                    }
                } else {
                    // No more digit, we don't check right side anymore.
                    rightOffset = -1;
                }
            }

            // Left check
            if (leftOffset >= 0) {
                leftOffset++;
                leftPos = x + leftOffset < matrix[0].length ? x + leftOffset : leftPos;

                if (Character.isDigit(matrix[y][leftPos])) {
                    if (leftPos != x + leftOffset) {
                        // If we've reach the far left side, we don't check left side anymore.
                        leftOffset = -1;
                    } else {
                        sb.append(matrix[y][leftPos]);
                    }
                } else {
                    // No more digit, we don't check left side anymore.
                    leftOffset = -1;
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
