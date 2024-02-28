package org.champenslabyaddons.fvplus.util.csv;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Csv {
  private final BufferedReader bufferedReader;

  public Csv(BufferedReader bufferedReader) {
    this.bufferedReader = bufferedReader;
  }

  public List<String[]> readALl() {
    List<String[]> lines = new ArrayList<>();
    for (Object s : bufferedReader.lines().toArray()) {
      lines.add(((String) s).split(","));
    }
    return lines;
  }
}
