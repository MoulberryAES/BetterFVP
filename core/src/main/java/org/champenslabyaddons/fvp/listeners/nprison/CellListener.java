package org.champenslabyaddons.fvp.listeners.nprison;

import net.labymod.api.client.component.Component;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.Pair;
import org.champenslabyaddons.fvp.connection.ClientInfo;
import org.champenslabyaddons.fvp.util.FreakyVilleServer;
import org.champenslabyaddons.fvp.util.Messaging;

public class CellListener {

  private final ClientInfo clientInfo;

  public CellListener(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
  }

  @Subscribe
  public void onChatReceived(ChatReceiveEvent event) {
    if (!this.clientInfo.isOnFreakyVille()
        && this.clientInfo.getCurrentServer() == FreakyVilleServer.PRISON) {
      return;
    }
    String plainMessage = event.chatMessage().getPlainText().trim();
    if (plainMessage.startsWith(headerDecoration().getFirst()) &&
        plainMessage.endsWith(headerDecoration().getSecond())) {
      Messaging.executor().displayClientMessage(cellLocation(plainMessage));
    }
  }

  private Component cellLocation(String header) {
    String restProduct = header
        .replace(headerDecoration().getFirst(), "")
        .replace(headerDecoration().getSecond(), "")
        .trim();
    return Component.empty(); // MIDLERTIDIGT
  }

  private Pair<String, String> headerDecoration() {
    return Pair.of("------------={", "}=------------");
  }
}
