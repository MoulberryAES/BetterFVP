package org.champenslabyaddons.fvplus.listeners.internal;

import net.labymod.api.event.Priority;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.Pair;
import net.labymod.api.util.logging.Logging;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.util.FreakyVilleServer;
import org.champenslabyaddons.fvplus.util.Messaging;
import org.champenslabyaddons.fvplus.util.Prison;
import java.util.Objects;

public class PrisonNavigationListener {
  private final ClientInfo clientInfo;

  public PrisonNavigationListener(ClientInfo clientInfo) {
    this.clientInfo = clientInfo;
  }

  @Subscribe(Priority.FIRST)
  public void onChatReceive(ChatReceiveEvent event) {
    if (!this.clientInfo.isOnFreakyVille()) {
      return;
    }
    if (this.clientInfo.getCurrentServer() != FreakyVilleServer.PRISON) {
      return;
    }
    if (this.clientInfo.getPrison().isPresent()) {
      return;
    }
    String plainMessage = event.chatMessage().getPlainText().trim();
    if (plainMessage.startsWith(Objects.requireNonNull(headerDecoration().getFirst())) &&
        plainMessage.endsWith(Objects.requireNonNull(headerDecoration().getSecond()))) {
      try {
        this.clientInfo.setPrison(prisonFromHeader(plainMessage));
      } catch (IllegalArgumentException e) {
        this.clientInfo.setPrison(null);
        Logging.getLogger().error("Could not find the correct prison, most functionality will not work.", e);
        Messaging.executor().displayClientMessage("Fandt ikke blokken, de fleste funktioner vil ikke virke.");
      }
    }
  }

  private Prison prisonFromHeader(String header) {
    String restProduct = header
        .replace(Objects.requireNonNull(headerDecoration().getFirst()), "")
        .replace(Objects.requireNonNull(headerDecoration().getSecond()), "")
        .trim();
      return switch (restProduct.toUpperCase()) {
      case "C" -> Prison.C;
      case "B" -> Prison.B;
      case "A" -> Prison.A;
      default -> throw new IllegalArgumentException("Unexpected value: " + restProduct.toUpperCase());
    };
  }

  private Pair<String, String> headerDecoration() {
    return Pair.of("----- Online Fanger i", "----");
  }
}
