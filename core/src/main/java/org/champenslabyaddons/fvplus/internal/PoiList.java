package org.champenslabyaddons.fvplus.internal;

import net.labymod.api.util.Pair;
import net.labymod.api.util.logging.Logging;
import org.champenslabyaddons.fvplus.poi.POI;
import org.champenslabyaddons.fvplus.poi.PrisonPOI;
import org.champenslabyaddons.fvplus.util.Prison;
import org.champenslabyaddons.fvplus.util.csv.Csv;
import org.champenslabyaddons.fvplus.util.http.HttpConnector;
import org.champenslabyaddons.fvplus.util.resource.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PoiList implements Manager {
  private final List<POI> pois;
  private final Set<POI> limboingPois;

  public PoiList() {
    this.pois = new ArrayList<>();
    this.limboingPois = new HashSet<>();
  }

  @Override
  public void init() throws IOException {
    HttpURLConnection connection = HttpConnector.getOpenHttpConnection(new URL(
        Resources.POI_LIST_URL));
    Csv csv = new Csv(new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)));

    for (String[] strings : csv.readALl()) {
      this.pois.add(new PrisonPOI(
          strings[0],
          strings[1],
          Pair.of(strings[2], strings[3]),
          Pair.of(strings[4], strings[5]),
          strings[6],
          Integer.parseInt(strings[7]),
          Integer.parseInt(strings[8]),
          Integer.parseInt(strings[9]),
          Integer.parseInt(strings[10]),
          Arrays.stream(strings[11].split(";")).map(Prison::valueOf).toArray(Prison[]::new)
      ));
      Logging.getLogger().info("POI: " + strings[0]);
    }

    connection.disconnect();
  }

  public Optional<POI> getByName(String name) {
    for (POI poi : this.pois) {
      if (poi.getDisplayName().equalsIgnoreCase(name)) {
        return Optional.of(poi);
      }
    }
    return Optional.empty();
  }

  public Optional<POI> getByActivationPair(String activationPair) {
    for (POI poi : this.pois) {
      if ((poi.getActivationPair().getFirst() + poi.getActivationPair().getSecond()).equals(activationPair)) {
        return Optional.of(poi);
      }
    }
    return Optional.empty();
  }

  public Optional<POI> getByConfirmationPair(String cancellationPair) {
    for (POI poi : this.pois) {
      if ((poi.getConfirmationPair().getFirst() + poi.getConfirmationPair().getSecond()).equals(cancellationPair)) {
        return Optional.of(poi);
      }
    }
    return Optional.empty();
  }

  public List<POI> getPois() {
    return List.copyOf(this.pois);
  }

  public Set<POI> getLimboingPois() {
    return this.limboingPois;
  }
}
