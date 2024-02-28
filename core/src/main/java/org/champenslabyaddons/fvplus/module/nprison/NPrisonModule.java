package org.champenslabyaddons.fvplus.module.nprison;

import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import org.champenslabyaddons.fvplus.connection.ClientInfo;
import org.champenslabyaddons.fvplus.module.BigModule;
import org.champenslabyaddons.fvplus.module.Module;
import org.champenslabyaddons.fvplus.module.ModuleService;
import java.util.ArrayList;

public class NPrisonModule extends BigModule {

  private final CommandService commandService;
  private final EventBus eventBus;
  private final ClientInfo clientInfo;

  public NPrisonModule(ModuleService moduleService, CommandService commandService, EventBus eventBus, ClientInfo clientInfo) {
    super(moduleService);
    this.commandService = commandService;
    this.eventBus = eventBus;
    this.clientInfo = clientInfo;
    this.internalModules = internalModulesOverview();
  }

  @Override
  protected ArrayList<Module> internalModulesOverview() {
    ArrayList<Module> modules = new ArrayList<>();
    modules.add(new CellModule(commandService, eventBus, clientInfo));
    return modules;
  }

  @Override
  public boolean shouldRegisterAutomatically() {
    return true;
  }
}
