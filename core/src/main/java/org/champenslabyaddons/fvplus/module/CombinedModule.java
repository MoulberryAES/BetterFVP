package org.champenslabyaddons.fvplus.module;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class CombinedModule implements Module {
  private final CommandService commandService;
  protected List<Command> moduleCommands;
  private final EventBus eventBus;
  protected List<Object> moduleListeners;
  private boolean registered;

  public CombinedModule(CommandService commandService, EventBus eventBus) {
    this.commandService = commandService;
    this.eventBus = eventBus;
    this.registered = false;
  }

  @Override
  public final void register() {
    for (Command command : this.moduleCommands) {
      this.commandService.register(command);
    }
    for (Object listener : this.moduleListeners) {
      this.eventBus.registerListener(listener);
    }
    this.registered = true;
  }

  @Override
  public final void unregister() {
    for (Command command : this.moduleCommands) {
      this.commandService.unregister(command);
    }
    for (Object listener : this.moduleListeners) {
      this.eventBus.unregisterListener(listener);
    }
    this.registered = false;
  }

  protected abstract ArrayList<Command> moduleCommandsOverview();

  protected abstract ArrayList<Object> moduleListenersOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();

  public boolean isRegistered() {
    return this.registered;
  }
}
