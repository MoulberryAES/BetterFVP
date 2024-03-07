package org.champenslabyaddons.fvplus.commands.timers.sub;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.util.I18n;
import org.champenslabyaddons.fvplus.commands.FreakyVillePlusSubCommand;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.internal.PoiList;
import org.champenslabyaddons.fvplus.poi.POI;
import org.champenslabyaddons.fvplus.util.FreakyVilleServer;
import java.util.ArrayList;
import java.util.List;

public class TimerGlobalCommand extends FreakyVillePlusSubCommand {
  private final ClientInfo clientInfo;
  private final PoiList poiList;
  private final String isTakeable;
  private final String cantCheckForSure;
  private final String unavailable;

  public TimerGlobalCommand(String serverAndCategoryKey, String parentPrefix, ClientInfo clientInfo, PoiList poiList) {
    super("global", parentPrefix,  serverAndCategoryKey, "globale", "g");
    this.clientInfo = clientInfo;
    this.poiList = poiList;
    this.isTakeable = I18n.translate("fvplus.widgets.timer.timeLeft.isTakeable");
    this.cantCheckForSure = " (" + I18n.translate("fvplus.widgets.timer.timeLeft.cantKnowForSure") + ")";
    this.unavailable = I18n.translate("fvplus.widgets.timer.timeLeft.unavailable");
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!clientInfo.isOnFreakyVille()) return false;
    List<POI> poisOnCooldown = new ArrayList<>();
    for (POI poi : poiList.getPois()) {
      if (poi.getTimeLeft(clientInfo) == null) {
        continue;
      }
      if (poi.getTimeLeft(clientInfo).equals(isTakeable.replace(cantCheckForSure, ""))) {
        continue;
      }
      if (poi.getTimeLeft(clientInfo).equals(unavailable)) {
        continue;
      }
      poisOnCooldown.add(poi);
    }
    if (arguments.length < 1) {
      defaultExecution(poisOnCooldown);
      return true;
    }
    FreakyVilleServer specifiedServer;
    try {
      specifiedServer = getServerFromString(arguments[0]);
    } catch (IllegalArgumentException e) {
      displayTranslatable("invalidServer", NamedTextColor.RED);
      return true;
    }
    serverSpecificExecution(poisOnCooldown, specifiedServer);
    return true;
  }

  private void defaultExecution(List<POI> poisOnCooldown) {
    String header = " -= [ " + I18n.translate(getTranslationKey() + ".header") + " ] =-";
    displayMessage(Component.text(header, NamedTextColor.GOLD));
    if (poisOnCooldown.isEmpty()) {
      displayTranslatable("noOnCooldown", NamedTextColor.GREEN);
      return;
    }
    for (POI poi : poisOnCooldown) {
      displayPOI(poi);
    }
  }

  private void serverSpecificExecution(List<POI> poisOnCooldown, FreakyVilleServer specifiedServer) {
    List<POI> poisOnSpecifiedServerOnCooldown = new ArrayList<>();
    for (POI poi : poisOnCooldown) {
      if (poi.getAssosciatedServer() == specifiedServer) {
        poisOnSpecifiedServerOnCooldown.add(poi);
      }
    }
    String headerVal = I18n.translate(getTranslationKey() + ".header");
    String header = String.format(" -= [ %s - %s ] =-", headerVal, specifiedServer.getTranslatedName());
    displayMessage(Component.text(header, NamedTextColor.GOLD));
    if (poisOnSpecifiedServerOnCooldown.isEmpty()) {
      displayTranslatable("noOnCooldown", NamedTextColor.GREEN);
      return;
    }
    for (POI poi : poisOnSpecifiedServerOnCooldown) {
      displayPOI(poi);
    }
  }

  private void displayPOI(POI poi) {
    Component line = Component.text(" - ", NamedTextColor.GRAY);
    Component poiName = Component.text(poi.getDisplayName(), NamedTextColor.YELLOW);
    Component seperator = Component.text(": ", NamedTextColor.GRAY);
    Component timeLeft = Component.text(poi.getTimeLeft(clientInfo), NamedTextColor.WHITE);
    displayMessage(line.append(poiName).append(seperator).append(timeLeft));
  }

  private FreakyVilleServer getServerFromString(String server) {
    return switch (server.toLowerCase()) {
        case "nprison", "prison", "np" -> FreakyVilleServer.PRISON;
        case "kitpvp", "kit" -> FreakyVilleServer.KIT_PVP;
        case "skyblock", "sb" -> FreakyVilleServer.SKY_BLOCK;
        case "friheden", "fri" -> FreakyVilleServer.THE_CITY;
        default -> throw new IllegalArgumentException("Invalid server");
    };
  }
}
