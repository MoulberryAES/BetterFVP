package org.champenslabyaddons.fvplus.commands.internal;

import com.google.gson.Gson;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.util.I18n;
import net.labymod.api.util.logging.Logging;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.objects.WheelData;
import org.champenslabyaddons.fvplus.objects.WheelData.Wheel;
import org.champenslabyaddons.fvplus.util.Messaging;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CheckRollCommand extends Command {
  private final ClientInfo clientInfo;

  public CheckRollCommand(ClientInfo clientInfo) {
    super("checkroll", "cr", "roll");
    this.clientInfo = clientInfo;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!this.clientInfo.isOnFreakyVille()) return true;
    if (arguments.length < 1) return true;
    if (arguments[0].length() != 36) return true;
    String uniqueId = arguments[0];

    InputStreamReader reader = null;
    try {
      URL url = new URL("https://freakyville.dk/api/wheel/" + uniqueId);
      reader = new InputStreamReader(url.openStream());
    } catch (Exception e) {
      Logging.getLogger().error("Could not fetch the wheel data.", e);
      return true;
    }

    WheelData data = new Gson().fromJson(reader, WheelData.class);
    displayInChat(data.getWheel());
    return true;
  }

  private void displayInChat(Wheel wheel) {
    String rollKey = "fvplus.commands.checkRoll.";
    String header = " -= [ " + I18n.getTranslation(rollKey + "header") + " ] =-";
    ZonedDateTime timestamp = ZonedDateTime.parse(wheel.getCreatedAt(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
    String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    Component time = Component.text(formattedTimestamp, NamedTextColor.GRAY);
    Component id = Component.text(wheel.getId(), NamedTextColor.AQUA);
    Component wheelID = Component.translatable(rollKey + "wheel.header", NamedTextColor.GOLD, id);
    Messaging.executor().displayClientMessage(Component.text(header, NamedTextColor.GOLD));
    Messaging.executor().displayClientMessage(time);
    Messaging.executor().displayClientMessage(wheelID);
    for (int i = 0; i < wheel.getOptions().length; i++) {
      if (wheel.getOptions().length > 10) {
        displayTranslatable(rollKey + "wheel.tooManyOptions", NamedTextColor.RED);
        break;
      }
      Component option = Component.text(" - " + wheel.getOptions()[i].getOption(), NamedTextColor.GRAY);
      Messaging.executor().displayClientMessage(option);
    }
    int winnerIndex = Integer.parseInt(wheel.getWinner());
    Component winner = Component.text(
        " - " + I18n.getTranslation(rollKey + "wheel.winner", wheel.getOptions()[winnerIndex].getOption()),
        NamedTextColor.GREEN);
    Messaging.executor().displayClientMessage(winner);
  }
}
