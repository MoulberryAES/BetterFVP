package org.champenslabyaddons.fvp.module;

import net.labymod.api.event.EventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class ListenerModule implements Module {
  private final EventBus eventBus;
  protected List<Object> moduleListeners;

  public ListenerModule(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public final void register() {
    for (Object listener : this.moduleListeners) {
      this.eventBus.registerListener(listener);
    }
  }

  @Override
  public final void unregister() {
    for (Object listener : this.moduleListeners) {
      this.eventBus.unregisterListener(listener);
    }
  }

  protected abstract ArrayList<Object> moduleListenersOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();
}
