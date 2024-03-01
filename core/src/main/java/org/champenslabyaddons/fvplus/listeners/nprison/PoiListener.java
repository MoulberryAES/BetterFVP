package org.champenslabyaddons.fvplus.listeners.nprison;

import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.Pair;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.internal.PoiList;
import org.champenslabyaddons.fvplus.objects.POI;
import java.util.Objects;

public class PoiListener {

  private final ClientInfo clientInfo;
  private final PoiList poiList;

  public PoiListener(ClientInfo clientInfo, PoiList poiList) {
    this.clientInfo = clientInfo;
    this.poiList = poiList;
  }

  public void onChatReceive(ChatReceiveEvent event) {
    if (!this.clientInfo.isOnFreakyVille()) {
      return;
    }
    String plainMessage = event.chatMessage().getPlainText().trim();
    this.poiList.getPois().forEach(poi -> {
      if (!isPoiMessage(poi, plainMessage)) {
        return;
      }
      handle(poi, plainMessage);
    });
  }

  private void handle(POI poi, String message) {
    String demystifiedMessage = message.replace(getPlayerFromString(poi, message), "").trim();
    if (demystifiedMessage.equals(pairToString(poi.getActivationPair()))) {
      activation(poi);
    } else if (demystifiedMessage.equals(pairToString(poi.getCancelationPair()))) {
      cancellation(poi);
    }
  }

  private void activation(POI poi) {

  }

  private void cancellation(POI poi) {

  }

  private String getPlayerFromString(POI poi, String message) {
    String player = "";
    if (message.startsWith(Objects.requireNonNull(poi.getActivationPair().getFirst())) &&
        message.endsWith(Objects.requireNonNull(poi.getActivationPair().getSecond()))) {
      player = message.substring(poi.getActivationPair().getFirst().length() + 1,
          message.length() - poi.getActivationPair().getSecond().length());
    } else if (message.startsWith(Objects.requireNonNull(poi.getCancelationPair().getFirst())) &&
        message.endsWith(Objects.requireNonNull(poi.getCancelationPair().getSecond()))) {
      player = message.substring(poi.getCancelationPair().getFirst().length() + 1,
          message.length() - poi.getCancelationPair().getSecond().length());
    }
    return player;
  }

  private String pairToString(Pair<String, String> pair) {
    return pair.getFirst() + pair.getSecond();
  }

  private boolean isPoiMessage(POI poi, String message) {
    return (message.startsWith(Objects.requireNonNull(poi.getActivationPair().getFirst()))
        && message.endsWith(Objects.requireNonNull(poi.getActivationPair().getSecond()))) || (
        message.startsWith(Objects.requireNonNull(poi.getCancelationPair().getFirst()))
            && message.endsWith(Objects.requireNonNull(poi.getCancelationPair().getSecond())));
  }
}
