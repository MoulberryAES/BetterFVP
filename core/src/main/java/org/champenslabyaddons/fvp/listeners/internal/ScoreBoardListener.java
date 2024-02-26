package org.champenslabyaddons.fvp.listeners.internal;

import net.labymod.api.Laby;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.TextComponent;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.scoreboard.ScoreboardObjectiveUpdateEvent;
import org.champenslabyaddons.fvp.connection.ClientInfo;
import org.champenslabyaddons.fvp.event.RequestEvent;
import org.champenslabyaddons.fvp.event.RequestEvent.RequestType;
import org.champenslabyaddons.fvp.util.FreakyVilleServer;

public class ScoreBoardListener {
  private final ClientInfo clientInfo;
  private final CommandService commandService;

  public ScoreBoardListener(ClientInfo clientInfo, CommandService commandService) {
    this.clientInfo = clientInfo;
    this.commandService = commandService;
  }

  @Subscribe
  public void onScoreboardObjectiveUpdate(ScoreboardObjectiveUpdateEvent event) {
    if (!this.clientInfo.isOnFreakyVille()) {
      return;
    }
    if (this.clientInfo.isUpdatedToCurrentServer()) {
      return;
    }
    Component title = event.objective().getTitle();
    StringBuilder titleTextBuilder = new StringBuilder(((TextComponent) title).getText());
    Component[] children = title.getChildren().toArray(new Component[0]);
    for (int i = 0; i < title.getChildren().size(); i++) {
      titleTextBuilder.append(((TextComponent) children[i]).getText());
    }
    String titleText = titleTextBuilder.toString();
    if (titleText.matches("[a-zA-Z ]*") && !titleText.isEmpty()) {
      updateClientAndRPC(titleText);
    } else {
      for (Component child : title.getChildren()) {
        String text = ((TextComponent) child).getText();
        if (text == null) {
          continue;
        }
        text = text.replaceAll("[^a-zA-Z \\.]", "").trim();
        if (text.matches("[a-zA-Z ]+")) {
          updateClientAndRPC(text);
          break;
        }
      }
    }
  }

  private void updateClientAndRPC(String text) {
    this.clientInfo.setCurrentServer(FreakyVilleServer.fromString(text.trim()));
    this.clientInfo.setHasUpdatedToCurrentServer(true);
    if (this.clientInfo.getCurrentServer() == FreakyVilleServer.PRISON) {
      this.commandService.fireCommand("/list", new String[]{});
    }
    Laby.fireEvent(new RequestEvent(RequestType.DISCORD_RPC));
  }
}
