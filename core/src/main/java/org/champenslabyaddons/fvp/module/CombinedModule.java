package org.champenslabyaddons.fvp.module;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class CombinedModule implements Module {
  private final CommandService commandService;
  private final List<Command> moduleCommands;
  private final EventBus eventBus;
  private final List<Object> moduleListeners;

  public CombinedModule(CommandService commandService, EventBus eventBus) {
    this.commandService = commandService;
    this.moduleCommands = moduleCommandsOverview();
    this.eventBus = eventBus;
    this.moduleListeners = moduleListenersOverview();
  }

  @Override
  public final void register() {
    for (Command command : this.moduleCommands) {
      this.commandService.register(command);
    }
    for (Object listener : this.moduleListeners) {
      this.eventBus.registerListener(listener);
    }
  }

  @Override
  public final void unregister() {
    for (Command command : this.moduleCommands) {
      this.commandService.unregister(command);
    }
    for (Object listener : this.moduleListeners) {
      this.eventBus.unregisterListener(listener);
    }
  }

  protected abstract ArrayList<Command> moduleCommandsOverview();

  protected abstract ArrayList<Object> moduleListenersOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();
}
