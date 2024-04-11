package org.champenslabyaddons.fvplus.module.general;

import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvplus.configuration.SessionSubConfiguration;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.listeners.nprison.PrisonSessionListener;
import org.champenslabyaddons.fvplus.module.ListenerModule;
import org.champenslabyaddons.fvplus.session.AddonSession;
import java.util.ArrayList;

public class SessionModule extends ListenerModule {
  private final ClientInfo clientInfo;
  private final AddonSession addonSession;
  private final SessionSubConfiguration configuration;

  public SessionModule(EventBus eventBus, ClientInfo clientInfo, AddonSession addonSession, SessionSubConfiguration configuration) {
    super(eventBus);
    this.clientInfo = clientInfo;
    this.addonSession = addonSession;
    this.configuration = configuration;
    this.moduleListeners = moduleListenersOverview();
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    ArrayList<Object> listeners = new ArrayList<>();
    listeners.add(new PrisonSessionListener(addonSession, clientInfo, configuration));
    return listeners;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return this.configuration.enabled().get();
  }
}
