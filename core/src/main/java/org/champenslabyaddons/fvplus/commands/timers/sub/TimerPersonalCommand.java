package org.champenslabyaddons.fvplus.commands.timers.sub;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.internal.PoiList;
import org.champenslabyaddons.fvplus.poi.POI;
import org.champenslabyaddons.fvplus.util.FreakyVilleServer;
import java.util.ArrayList;
import java.util.List;

public class TimerPersonalCommand extends TimerSubCommand {
  public TimerPersonalCommand(String serverAndCategoryKey, String parentPrefix, ClientInfo clientInfo, PoiList poiList) {
      super("personal", serverAndCategoryKey, parentPrefix, clientInfo, poiList,  "personlig", "p");
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!clientInfo.isOnFreakyVille()) return false;
    List<POI> poisOnCooldown = new ArrayList<>();
    for (POI poi : poiList.getPois()) {
      if (poi.getPersonalTimeLeft() == null) {
        continue;
      }
      if (poi.getPersonalTimeLeft().equals(isTakeable)) {
        continue;
      }
      poisOnCooldown.add(poi);
    }
    return howToExecute(arguments, poisOnCooldown);
  }

  @Override
  protected final void displayPOI(POI poi) {
    Component line = Component.text(" - ", NamedTextColor.GRAY);
    Component poiName = Component.text(poi.getDisplayName(), NamedTextColor.YELLOW);
    Component separator = Component.text(": ", NamedTextColor.GRAY);
    Component timeLeft = Component.text(poi.getPersonalTimeLeft(), NamedTextColor.WHITE);
    displayMessage(line.append(poiName).append(separator).append(timeLeft));
  }
}
