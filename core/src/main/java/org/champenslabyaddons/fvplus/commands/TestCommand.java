package org.champenslabyaddons.fvplus.commands;

import net.labymod.api.client.chat.command.Command;
import org.champenslabyaddons.fvplus.util.Messaging;

public class TestCommand extends Command {

  public TestCommand() {
    super("a", "b", "c", "a2");
  }
  @Override
  public boolean execute(String prefix, String[] arguments) {
    switch (prefix) {
      case "a":
        Messaging.executor().displayClientMessage("VAGT-ALARM: _ghost_v2 forsøger at røve vagternes værdi-boks i A!");
        break;
      case "b":
        Messaging.executor().displayClientMessage("VAGT-ALARM: Willads_den_seje har stjålet inventar fra Vagt-Huset B!");
        break;
      case "c":
        Messaging.executor().displayClientMessage("| FV-PRISON | VAGT-ALARM: Uhyrlig har haft fingrene i Vagt-Vaulten i C!");
        break;
      case "a2":
        Messaging.executor().displayClientMessage("VAGT-ALARM: _ghost_v2 gennemførte et røveri i vagternes værdi-boks i A!");
        break;
    }
    return false;
  }
}
