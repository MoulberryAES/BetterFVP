package org.champenslabyaddons.fvplus.commands.timers;

import net.labymod.api.client.component.format.NamedTextColor;
import org.champenslabyaddons.fvplus.commands.FreakyVillePlusCommand;
import org.champenslabyaddons.fvplus.commands.timers.sub.TimerGlobalCommand;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.internal.PoiList;
import java.util.List;

public class TimerCommand extends FreakyVillePlusCommand {
  private final ClientInfo clientInfo;

  public TimerCommand(ClientInfo clientInfo, PoiList poiList) {
    super("timer", "", "tim");
    this.clientInfo = clientInfo;
    this.withSubCommand(new TimerGlobalCommand(getServerAndCategoryKey(), this.getPrefix(), clientInfo, poiList));
  }

  @Override
  public List<String> complete(String[] arguments) {
    return super.subCommandPrefixes();
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!this.clientInfo.isOnFreakyVille()) return false;
    if (arguments.length < 1) {
      displayTranslatable("usage", NamedTextColor.RED);
      return true;
    }
    return true;
  }
}
