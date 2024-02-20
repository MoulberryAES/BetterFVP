package org.champenslabyaddons.fvp.listeners.internal;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerDisconnectEvent;
import net.labymod.api.event.client.network.server.ServerJoinEvent;
import net.labymod.api.event.client.network.server.SubServerSwitchEvent;
import org.champenslabyaddons.fvp.connection.ClientInfo;

public class ServerNavigationListener {
  private final ClientInfo clientInfo;

  public ServerNavigationListener(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
  }

  @Subscribe
  public void onServerJoin(ServerJoinEvent event) {

  }

  @Subscribe
  public void onServerDisconnect(ServerDisconnectEvent event) {

  }

  @Subscribe
  public void onSubServerSwitch(SubServerSwitchEvent event) {

  }
}
