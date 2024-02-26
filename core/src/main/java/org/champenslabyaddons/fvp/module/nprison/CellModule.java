package org.champenslabyaddons.fvp.module.nprison;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import net.labymod.api.util.logging.Logging;
import org.champenslabyaddons.fvp.commands.CellWaypointCommand;
import org.champenslabyaddons.fvp.connection.ClientInfo;
import org.champenslabyaddons.fvp.internal.CellList;
import org.champenslabyaddons.fvp.listeners.nprison.CellListener;
import org.champenslabyaddons.fvp.module.CombinedModule;
import java.io.IOException;
import java.util.ArrayList;

public class CellModule extends CombinedModule {
  private final ClientInfo clientInfo;
  private final CellList cellList;

  public CellModule(CommandService commandService, EventBus eventBus, ClientInfo clientInfo) {
    super(commandService, eventBus);
    this.clientInfo = clientInfo;
    this.cellList = new CellList();
    try {
      cellList.init();
    } catch (IOException e) {
      Logging.getLogger().error("Caught Exception upon trying to load the cells.", e);
    }
    this.moduleCommands = moduleCommandsOverview();
    this.moduleListeners= moduleListenersOverview();
  }

  @Override
  protected ArrayList<Command> moduleCommandsOverview() {
    ArrayList<Command> commands = new ArrayList<>();
    commands.add(new CellWaypointCommand(clientInfo, cellList));
    return commands;
  }

  @Override
  protected ArrayList<Object> moduleListenersOverview() {
    ArrayList<Object> listeners = new ArrayList<>();
    listeners.add(new CellListener(clientInfo, cellList));
    return listeners;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return true;
  }
}
