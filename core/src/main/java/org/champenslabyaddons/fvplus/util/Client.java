package org.champenslabyaddons.fvplus.util;

import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.poi.POI;
import org.champenslabyaddons.fvplus.poi.PrisonPOI;

public final class Client {
  private Client() {}

  public static boolean poiCanBeUpdated(ClientInfo clientInfo, POI poi) {
    if (!clientInfo.isOnFreakyVille()) {
      return false;
    }
    if (clientInfo.getCurrentServer() != poi.getAssosciatedServer()) {
      return false;
    }
    if (poi instanceof PrisonPOI) {
      return poiCanBeUpdatedPrison(clientInfo, (PrisonPOI) poi);
    }
    return false;
  }

  private static boolean poiCanBeUpdatedPrison(ClientInfo clientInfo, PrisonPOI poi) {
    if (clientInfo.getPrison().isEmpty()) {
      return false;
    }
    for (Prison prison : poi.getWhereCanItBeUpdated()) {
      if (prison == clientInfo.getPrison().get()) {
        return true;
      }
    }
    return false;
  }
}
