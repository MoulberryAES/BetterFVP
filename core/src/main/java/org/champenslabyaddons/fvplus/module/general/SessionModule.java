package org.champenslabyaddons.fvplus.module.general;

import net.labymod.api.LabyAPI;
import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvplus.configuration.SessionSubConfiguration;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.module.ListenerModule;
import java.util.ArrayList;

public class SessionModule extends ListenerModule {
  private final ClientInfo clientInfo;
  private final LabyAPI labyAPI;
  private final SessionSubConfiguration configuration;

  public SessionModule(EventBus eventBus, ClientInfo clientInfo, LabyAPI labyAPI, SessionSubConfiguration configuration) {
    super(eventBus);
    this.clientInfo = clientInfo;
    this.labyAPI = labyAPI;
    this.configuration = configuration;
    this.moduleListeners = moduleListenersOverview();
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    return new ArrayList<>();
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return this.configuration.enabled().get();
  }
}
