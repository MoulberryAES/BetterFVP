package org.champenslabyaddons.fvplus.configuration;

import net.labymod.api.Laby;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import org.champenslabyaddons.fvplus.event.module.ModuleEvent;
import org.champenslabyaddons.fvplus.module.general.RPCModule;
import org.champenslabyaddons.fvplus.module.nprison.NPrisonModule;
import org.champenslabyaddons.fvplus.util.Setting;

public class DiscordSubConfiguration extends Config {
  @ParentSwitch
  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> showCurrentServer = new ConfigProperty<>(true);

  public DiscordSubConfiguration() {
    Setting.addModuleListener(this.enabled, RPCModule.class);
  }

  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Boolean> getShowCurrentServer() {
    return this.showCurrentServer;
  }
}
