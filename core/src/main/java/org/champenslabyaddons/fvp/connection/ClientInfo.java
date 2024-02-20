package org.champenslabyaddons.fvp.connection;

import net.labymod.api.client.entity.player.ClientPlayer;
import org.champenslabyaddons.fvp.util.FreakyVilleServer;

public class ClientInfo {
  private ClientPlayer clientPlayer;
  private FreakyVilleServer currentServer;
  private FreakyVilleServer lastServer;
  private boolean hasUpdatedToCurrentServer;

  public ClientInfo(ClientPlayer clientPlayer) {
    this.clientPlayer = clientPlayer;
    this.currentServer = FreakyVilleServer.NONE;
    this.lastServer = FreakyVilleServer.NONE;
    this.hasUpdatedToCurrentServer = false;
  }

  public boolean isOnFreakyVille() {
    return this.currentServer != FreakyVilleServer.NONE;
  }

  public ClientPlayer getClientPlayer() {
    return clientPlayer;
  }

  public void setClientPlayer(ClientPlayer clientPlayer) {
    this.clientPlayer = clientPlayer;
  }

  public FreakyVilleServer getCurrentServer() {
    return currentServer;
  }

  public void setCurrentServer(FreakyVilleServer currentServer) {
    this.currentServer = currentServer;
  }

  public FreakyVilleServer getLastServer() {
    return lastServer;
  }

  public void setLastServer(FreakyVilleServer lastServer) {
    this.lastServer = lastServer;
  }

  public boolean isUpdatedToCurrentServer() {
    return hasUpdatedToCurrentServer;
  }

  public void setHasUpdatedToCurrentServer(boolean hasUpdatedToCurrentServer) {
    this.hasUpdatedToCurrentServer = hasUpdatedToCurrentServer;
  }
}
