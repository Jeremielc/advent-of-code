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
  }

  @Test
  void testComputeCalibrationValue() {
    assertEquals(142, Day01Trebuchet.computeCalibrationValue(List.of("12", "38", "15", "77")));
  }
}
