package org.champenslabyaddons.fvplus.widgets;

import net.labymod.api.client.gui.icon.Icon;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.poi.POI;

public class PoiTimerWidget extends TimerWidget {
  private final POI poi;

  public PoiTimerWidget(POI poi, ClientInfo clientInfo, Icon associatedIcon) {
    super(poi.getIdentifier(), clientInfo, associatedIcon);
    this.poi = poi;
  }

  @Override
  protected String getTimeLeft() {
    return this.poi.getTimeLeft(this.clientInfo);
  }

  @Override
  protected String getPOI() {
    return this.poi.getDisplayName();
  }
}
