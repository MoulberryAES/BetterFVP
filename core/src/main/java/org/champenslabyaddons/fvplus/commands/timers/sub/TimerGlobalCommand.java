package org.champenslabyaddons.fvplus.commands.timers.sub;

import net.labymod.api.util.I18n;
import org.champenslabyaddons.fvplus.commands.FreakyVillePlusSubCommand;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.internal.PoiList;
import org.champenslabyaddons.fvplus.poi.POI;
import java.util.ArrayList;
import java.util.List;

public class TimerGlobalCommand extends FreakyVillePlusSubCommand {
  private final ClientInfo clientInfo;
  private final PoiList poiList;
  private final String isTakeable;
  private final String cantCheckForSure;

  public TimerGlobalCommand(String serverAndCategoryKey, ClientInfo clientInfo, PoiList poiList) {
    super("globale", serverAndCategoryKey, "global", "g");
    this.clientInfo = clientInfo;
    this.poiList = poiList;
    this.isTakeable = I18n.translate("fvplus.widgets.timer.timeLeft.isTakeable");
    this.cantCheckForSure = " (" + I18n.translate("fvplus.widgets.timer.timeLeft.cantKnowForSure") + ")";
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!clientInfo.isOnFreakyVille()) return false;
    List<POI> poisOnCooldown = new ArrayList<>();
    for (POI poi : poiList.getPois()) {
      if (!poi.getTimeLeft(clientInfo).equals(isTakeable.replace(cantCheckForSure, ""))) {
        poisOnCooldown.add(poi);
      }
    }
    if (arguments.length < 1) {
      defaultExecution(poisOnCooldown);
      return true;
    }
    return true;
  }

  private void defaultExecution(List<POI> poisOnCooldown) {

  }

  private void serverSpecificExecution() {

  }
}
