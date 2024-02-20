package org.champenslabyaddons.fvp.module.nprison;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvp.module.CombinedModule;
import java.util.ArrayList;

public class CellModule extends CombinedModule {

  public CellModule(CommandService commandService, EventBus eventBus) {
    super(commandService, eventBus);
  }

  @Override
  protected ArrayList<Command> moduleCommandsOverview() {
    ArrayList<Command> commands = new ArrayList<>();

    return commands;
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    ArrayList<Object> listeners = new ArrayList<>();

    return listeners;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return false;
  }
}
