package com.jeremielc.aoc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputDataUtils {
  public static List<String> readDataFrom(InputStream inputStream) {
    List<String> dataList = new ArrayList<>();
    String line;

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      while ((line = br.readLine()) != null) {
        dataList.add(line);
      }
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
      ex.printStackTrace(System.err);
    }

    return dataList;
  }
}
