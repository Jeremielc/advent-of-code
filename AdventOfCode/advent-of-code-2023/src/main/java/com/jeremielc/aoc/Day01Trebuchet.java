package com.jeremielc.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day01Trebuchet {
  public static void main(String[] args) {
    List<String> calibrationValues = new ArrayList<>();
    String line;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(Day01Trebuchet.class.getResourceAsStream("/Day-01-Puzzle-1-Input.txt")))) {
      while ((line = br.readLine()) != null) {
        calibrationValues.add(extractIntegerCalibrationValue(line));
      }
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
      ex.printStackTrace(System.err);
    }

    System.out.println("DAY 01 - Puzzle 1 answer is: " + computeCalibrationValue(calibrationValues));
  }

  public static String extractIntegerCalibrationValue(String data) {
    String firstDigit = "";
    String lastDigit = "";
    boolean firstDigitSet = false;

    for (char c : data.toCharArray()) {
      if (Character.isDigit(c)) {
        if (!firstDigitSet) {
          firstDigit = Character.toString(c);
          firstDigitSet = true;
        }

        lastDigit = Character.toString(c);
      }
    }

    return firstDigit + lastDigit;
  }

  public static int computeCalibrationValue(List<String> values) {
    int sum = 0;

    for (String v : values) {
      sum += Integer.parseInt(v);
    }

    return sum;
  }
}