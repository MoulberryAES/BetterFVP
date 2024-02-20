package org.champenslabyaddons.fvp.module.general;

import net.labymod.api.LabyAPI;
import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvp.configuration.DiscordSubConfiguration;
import org.champenslabyaddons.fvp.connection.ClientInfo;
import org.champenslabyaddons.fvp.listeners.misc.DiscordRPCListener;
import org.champenslabyaddons.fvp.module.ListenerModule;
import java.util.ArrayList;

public class RPCModule extends ListenerModule {
  private final ClientInfo clientInfo;
  private final LabyAPI labyAPI;
  private final DiscordSubConfiguration configuration;

  public RPCModule(EventBus eventBus, ClientInfo clientInfo, LabyAPI labyAPI, DiscordSubConfiguration configuration) {
    super(eventBus);
    this.clientInfo = clientInfo;
    this.labyAPI = labyAPI;
    this.configuration = configuration;
    this.moduleListeners = moduleListenersOverview();
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    ArrayList<Object> listeners = new ArrayList<>();
    listeners.add(new DiscordRPCListener(clientInfo, labyAPI));
    return listeners;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return this.configuration.enabled().get();
  }
}
