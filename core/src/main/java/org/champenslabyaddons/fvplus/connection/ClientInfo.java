package org.champenslabyaddons.fvplus.connection;

import net.labymod.api.client.entity.player.ClientPlayer;
import org.champenslabyaddons.fvplus.util.FreakyVilleServer;
import org.champenslabyaddons.fvplus.util.Prison;
import java.util.Optional;

public class ClientInfo {
  private ClientPlayer clientPlayer;
  private FreakyVilleServer currentServer;
  private FreakyVilleServer lastServer;
  private Prison prison;
  private boolean hasUpdatedToCurrentServer;

  public ClientInfo(ClientPlayer clientPlayer) {
    this.clientPlayer = clientPlayer;
    this.currentServer = FreakyVilleServer.NONE;
    this.lastServer = FreakyVilleServer.NONE;
    this.prison = null;
    this.hasUpdatedToCurrentServer = false;
  }

  public boolean isOnFreakyVille() {
    return this.currentServer != FreakyVilleServer.NONE;
  }

  public Optional<ClientPlayer> getClientPlayer() {
    return Optional.ofNullable(clientPlayer);
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

  public Optional<Prison> getPrison() {
    return Optional.ofNullable(prison);
  }

  public void setPrison(Prison prison) {
    this.prison = prison;
  }

  public boolean isUpdatedToCurrentServer() {
    return hasUpdatedToCurrentServer;
  }

  public void setHasUpdatedToCurrentServer(boolean hasUpdatedToCurrentServer) {
    this.hasUpdatedToCurrentServer = hasUpdatedToCurrentServer;
  }
}
