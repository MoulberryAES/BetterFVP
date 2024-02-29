package org.champenslabyaddons.fvplus.internal;

import org.champenslabyaddons.fvplus.objects.CellBlock;
import org.champenslabyaddons.fvplus.objects.POI;
import org.champenslabyaddons.fvplus.util.Location;
import org.champenslabyaddons.fvplus.util.csv.Csv;
import org.champenslabyaddons.fvplus.util.http.HttpConnector;
import org.champenslabyaddons.fvplus.util.resource.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PoiList implements Manager {
  private final List<POI> pois;

  public PoiList() {
    this.pois = new ArrayList<>();
  }

  @Override
  public void init() throws IOException {
    HttpURLConnection connection = HttpConnector.getOpenHttpConnection(new URL(
        Resources.POI_LIST_URL));
    Csv csv = new Csv(new BufferedReader(new InputStreamReader(connection.getInputStream())));

    for (String[] strings : csv.readALl()) {
      //this.pois.add(new POI(
      //
      //));
    }

    connection.disconnect();
  }

  public List<POI> getPois() {
    return List.copyOf(this.pois);
  }
}
