package org.champenslabyaddons.fvp.internal;

import org.champenslabyaddons.fvp.objects.CellBlock;
import org.champenslabyaddons.fvp.util.http.HttpConnector;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Denne klasse håndtere listen over forskellige Cellegange / Områder.
 */
public class CellList implements Manager {
  private final List<CellBlock> cellBlocks;

  public CellList() {
    this.cellBlocks = new ArrayList<>();
  }

  @Override
  public void init() throws IOException {
    HttpURLConnection connection = HttpConnector.getOpenHttpConnection(new URL(""));

  }
}
