package org.champenslabyaddons.fvp.listeners.internal;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.scoreboard.ScoreboardObjectiveUpdateEvent;
import org.champenslabyaddons.fvp.connection.ClientInfo;

public class ScoreBoardListener {
  private final ClientInfo clientInfo;

  public ScoreBoardListener(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
  }

  @Subscribe
  public void onScoreboardObjectiveUpdate(ScoreboardObjectiveUpdateEvent event) {

  }
}
