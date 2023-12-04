package com.jeremielc.aoc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01TrebuchetTests {
  @Test
  void testExtractCalibrationValue() {
    assertEquals("12", Day01Trebuchet.extractIntegerCalibrationValue("1abc2"));
    assertEquals("38", Day01Trebuchet.extractIntegerCalibrationValue("pqr3stu8vwx"));
    assertEquals("15", Day01Trebuchet.extractIntegerCalibrationValue("a1b2c3d4e5f"));
    assertEquals("77", Day01Trebuchet.extractIntegerCalibrationValue("treb7uchet"));

    assertEquals("29", Day01Trebuchet.extractIntegerCalibrationValue("219"));
    assertEquals("83", Day01Trebuchet.extractIntegerCalibrationValue("8wo3"));
    assertEquals("13", Day01Trebuchet.extractIntegerCalibrationValue("abc123xyz"));
    assertEquals("24", Day01Trebuchet.extractIntegerCalibrationValue("x2ne34"));
    assertEquals("42", Day01Trebuchet.extractIntegerCalibrationValue("49872"));
    assertEquals("14", Day01Trebuchet.extractIntegerCalibrationValue("z1ight234"));
    assertEquals("76", Day01Trebuchet.extractIntegerCalibrationValue("7pqrst6teen"));
  }

  @Test
  void testReplaceSpelledNumbersNoOverlapAllowed() {
    assertEquals("219", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("two1nine"));
    assertEquals("8wo3", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("eightwothree"));
    assertEquals("abc123xyz", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("abcone2threexyz"));
    assertEquals("x2ne34", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("xtwone3four"));
    assertEquals("49872", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("4nineeightseven2"));
    assertEquals("z1ight234", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("zoneight234"));
    assertEquals("7pqrst6teen", Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("7pqrstsixteen"));
  }

  @Test
  void testInsertSpelledNumbersOverlapAllowed() {
    assertEquals("2two19nine", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("two1nine"));
    assertEquals("8eigh2two3three", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("eightwothree"));
    assertEquals("abc1one23threexyz", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("abcone2threexyz"));
    assertEquals("x2tw1one34four", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("xtwone3four"));
    assertEquals("49nine8eight7seven2", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("4nineeightseven2"));
    assertEquals("z1on8eight234", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("zoneight234"));
    assertEquals("7pqrst6sixteen", Day01Trebuchet.insertSpelledNumbersOverlapAllowed("7pqrstsixteen"));
  }

  @Test
  void testExtractCalibrationValueWithLetteredNumbers() {
    assertEquals("29", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("two1nine")));
    assertEquals("83", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("eightwothree")));
    assertEquals("13", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("abcone2threexyz")));
    assertEquals("24", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("xtwone3four")));
    assertEquals("42", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("4nineeightseven2")));
    assertEquals("14", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("zoneight234")));
    assertEquals("76", Day01Trebuchet.extractIntegerCalibrationValue(Day01Trebuchet.replaceSpelledNumbersNoOverlapAllowed("7pqrstsixteen")));
  }

  @Test
  void testComputeCalibrationValue() {
    assertEquals(142, Day01Trebuchet.computeCalibrationValue(List.of("12", "38", "15", "77")));
    assertEquals(281, Day01Trebuchet.computeCalibrationValue(List.of("29", "83", "13", "24", "42", "14", "76")));
  }
}
