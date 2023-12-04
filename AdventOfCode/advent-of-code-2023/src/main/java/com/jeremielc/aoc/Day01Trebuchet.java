package com.jeremielc.aoc;

import com.jeremielc.aoc.utils.InputDataUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Day01Trebuchet {
  private static final Map<String, Integer> digitMap = new HashMap<>();

  static {
    digitMap.put("one", 1);
    digitMap.put("two", 2);
    digitMap.put("three", 3);
    digitMap.put("four", 4);
    digitMap.put("five", 5);
    digitMap.put("six", 6);
    digitMap.put("seven", 7);
    digitMap.put("eight", 8);
    digitMap.put("nine", 9);
  }

  public static void main(String[] args) {
    List<String> lines = InputDataUtils.readDataFrom(Day01Trebuchet.class.getResourceAsStream("/Day-01-Puzzle-1-Input.txt"));
    List<String> values = new ArrayList<>();

    // ######## PUZZLE #1 ########
    lines.forEach(item -> values.add(extractCalibrationValue(item.toLowerCase())));
    System.out.println("DAY 01 - Puzzle 1 answer is: " + computeCalibrationValue(values));

    // ######## PUZZLE #2 ########
    values.clear();

    lines.forEach(item -> values.add(extractCalibrationValue(insertSpelledNumbers(item.toLowerCase()))));
    System.out.println("DAY 01 - Puzzle 2 answer is: " + computeCalibrationValue(values));
  }

  public static String extractCalibrationValue(String data) {
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

  public static String replaceSpelledNumbers(String rawLine) {
    StringBuilder builder = new StringBuilder();
    boolean match = false;
    int offset = 0;

    while (offset < rawLine.length()) {
      for (Map.Entry<String, Integer> entry : digitMap.entrySet()) {
        if (rawLine.startsWith(entry.getKey(), offset)) {
          match = true;
          builder.append(entry.getValue());
          offset += entry.getKey().length();
          break;
        }
      }

      if (!match) {
        builder.append(rawLine.charAt(offset));
        offset++;
      }

      match = false;
    }

    return builder.toString();
  }

  public static String insertSpelledNumbers(String rawLine) {
    StringBuilder builder = new StringBuilder();

    for (int offset = 0; offset < rawLine.length(); offset++) {
      for (Map.Entry<String, Integer> entry : digitMap.entrySet()) {
        if (rawLine.startsWith(entry.getKey(), offset)) {
          builder.append(entry.getValue());
          break;
        }
      }

      builder.append(rawLine.charAt(offset));
    }

    return builder.toString();
  }

  public static int computeCalibrationValue(List<String> values) {
    AtomicInteger sum = new AtomicInteger();
    values.stream().map(Integer::parseInt).forEach(sum::addAndGet);
    return sum.get();
  }
}