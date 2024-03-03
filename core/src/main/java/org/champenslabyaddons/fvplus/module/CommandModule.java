package org.champenslabyaddons.fvplus.module;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandModule implements Module {
  private final CommandService commandService;
  protected List<Command> moduleCommands;
  private boolean registered;

  public CommandModule(CommandService commandService) {
    this.commandService = commandService;
    this.moduleCommands = this.moduleCommandsOverview();
    this.registered = false;
  }

  @Override
  public final void register() {
    for (Command command : this.moduleCommands) {
      this.commandService.register(command);
    }
    this.registered = true;
  }

  @Override
  public final void unregister() {
    for (Command command : this.moduleCommands) {
      this.commandService.unregister(command);
    }
    this.registered = false;
  }

  protected abstract ArrayList<Command> moduleCommandsOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();

  public boolean isRegistered() {
    return this.registered;
  }
}
