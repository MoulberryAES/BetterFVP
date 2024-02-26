package org.champenslabyaddons.fvp;

import net.labymod.api.Laby;
import net.labymod.api.LabyAPI;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.chat.command.CommandService;
import net.labymod.api.event.EventBus;
import net.labymod.api.models.addon.annotation.AddonMain;
import org.champenslabyaddons.fvp.connection.ClientInfo;
import org.champenslabyaddons.fvp.integrations.WaypointsIntegration;
import org.champenslabyaddons.fvp.listeners.internal.ScoreBoardListener;
import org.champenslabyaddons.fvp.listeners.internal.ServerNavigationListener;
import org.champenslabyaddons.fvp.module.ModuleService;
import org.champenslabyaddons.fvp.module.general.RPCModule;
import org.champenslabyaddons.fvp.module.nprison.NPrisonModule;
import org.champenslabyaddons.fvp.util.Messaging;

@AddonMain
public class FreakyVilleAddon extends LabyAddon<FreakyVillePlusConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();
    LabyAPI labyAPI = this.labyAPI();
    ClientInfo clientInfo = new ClientInfo(labyAPI.minecraft().getClientPlayer());
    EventBus eventBus = labyAPI.eventBus();
    CommandService commandService = labyAPI.commandService();
    Messaging.setExecutor(labyAPI.minecraft().chatExecutor());

    Laby.references().addonIntegrationService()
        .registerIntegration("labyswaypoints", WaypointsIntegration.class);
    this.registerListener(new ScoreBoardListener(clientInfo, commandService));
    this.registerListener(new ServerNavigationListener(clientInfo));

    ModuleService moduleService = new ModuleService(this.logger());
    moduleService.registerModules(
        new RPCModule(eventBus, clientInfo, labyAPI(), configuration().getDiscordSubSettings()),
        new NPrisonModule(moduleService, commandService, eventBus, clientInfo)
    );

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<FreakyVillePlusConfiguration> configurationClass() {
    return FreakyVillePlusConfiguration.class;
  }
}
