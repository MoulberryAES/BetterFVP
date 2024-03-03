package org.champenslabyaddons.fvplus.poi;

import net.labymod.api.util.Pair;
import org.champenslabyaddons.fvplus.util.FreakyVilleServer;
import org.champenslabyaddons.fvplus.util.Prison;

public class PrisonPOI extends POI {
  private final Prison[] whereCanItBeUpdated;

  public PrisonPOI(String identifier, String displayName,
      Pair<String, String> activationPair,
      Pair<String, String> confirmationPair, String updateTimerMessage,
      int timedCooldown, int waitTimeUponFailure, int expectedTimeToFinish,
      int personalTimedCooldown, Prison... whereCanItBeUpdated) {
    super(identifier, displayName, activationPair, confirmationPair, updateTimerMessage,
        timedCooldown, waitTimeUponFailure, expectedTimeToFinish, personalTimedCooldown,
        FreakyVilleServer.PRISON);
    this.whereCanItBeUpdated = whereCanItBeUpdated;
  }

  public Prison[] getWhereCanItBeUpdated() {
    return whereCanItBeUpdated;
  }
}
