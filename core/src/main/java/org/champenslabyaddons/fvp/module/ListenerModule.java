package org.champenslabyaddons.fvp.module;

import net.labymod.api.event.EventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class ListenerModule implements Module {
  private final EventBus eventBus;
  private final List<Object> moduleListeners;

  public ListenerModule(EventBus eventBus) {
    this.eventBus = eventBus;
    this.moduleListeners = moduleListenersOverview();
  }

  @Override
  public void register() {
    for (Object listener : this.moduleListeners) {
      this.eventBus.registerListener(listener);
    }
  }

  @Override
  public void unregister() {
    for (Object listener : this.moduleListeners) {
      this.eventBus.unregisterListener(listener);
    }
  }

  protected abstract ArrayList<Object> moduleListenersOverview();
}
