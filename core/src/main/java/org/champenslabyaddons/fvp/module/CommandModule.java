package org.champenslabyaddons.fvp.module;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandModule implements Module {
  private final CommandService commandService;
  private final List<Command> moduleCommands;

  public CommandModule(CommandService commandService) {
    this.commandService = commandService;
    this.moduleCommands = moduleCommandsOverview();
  }

  @Override
  public void register() {
    for (Command command : this.moduleCommands) {
      this.commandService.register(command);
    }
  }

  @Override
  public void unregister() {
    for (Command command : this.moduleCommands) {
      this.commandService.unregister(command);
    }
  }

  protected abstract ArrayList<Command> moduleCommandsOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();
}
