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

public abstract class TimerSubCommand extends FreakyVillePlusSubCommand {
  protected final ClientInfo clientInfo;
  protected final PoiList poiList;
  protected final String isTakeable;

  public TimerSubCommand(String prefix, String serverAndCategoryKey, String parentPrefix, ClientInfo clientInfo, PoiList poiList, String... aliases) {
    super(prefix, parentPrefix, serverAndCategoryKey, aliases);
    this.clientInfo = clientInfo;
    this.poiList = poiList;
    this.isTakeable = I18n.translate("fvplus.widgets.timer.timeLeft.isTakeable");
  }

  public abstract boolean execute(String prefix, String[] arguments);

  protected void defaultExecution(List<POI> poisOnCooldown) {
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

  protected void serverSpecificExecution(List<POI> poisOnCooldown, FreakyVilleServer specifiedServer) {
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

  protected abstract void displayPOI(POI poi);

  protected FreakyVilleServer getServerFromString(String server) {
    return switch (server.toLowerCase()) {
      case "nprison", "prison", "np" -> FreakyVilleServer.PRISON;
      case "kitpvp", "kit" -> FreakyVilleServer.KIT_PVP;
      case "skyblock", "sb" -> FreakyVilleServer.SKY_BLOCK;
      case "friheden", "fri" -> FreakyVilleServer.THE_CITY;
      default -> throw new IllegalArgumentException("Invalid server");
    };
  }
}
