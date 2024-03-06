package org.champenslabyaddons.fvplus.commands.timers;

import org.champenslabyaddons.fvplus.commands.FreakyVillePlusCommand;
import java.util.List;

public class TimerCommand extends FreakyVillePlusCommand {
  public TimerCommand() {
    super("timer", "timers", "tim");
  }

  @Override
  public List<String> complete(String[] arguments) {
    return super.subCommandPrefixes();
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    return false;
  }
}
