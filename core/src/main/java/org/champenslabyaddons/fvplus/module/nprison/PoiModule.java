package org.champenslabyaddons.fvplus.module.nprison;

import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvplus.module.ListenerModule;
import java.util.ArrayList;

public class PoiModule extends ListenerModule {

  public PoiModule(EventBus eventBus) {
    super(eventBus);
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    ArrayList<Object> listeners = new ArrayList<>();

    return listeners;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return false;
  }
}
