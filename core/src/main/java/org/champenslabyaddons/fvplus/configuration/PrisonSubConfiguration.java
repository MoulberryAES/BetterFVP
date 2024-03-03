package org.champenslabyaddons.fvplus.configuration;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import org.champenslabyaddons.fvplus.module.nprison.CellModule;
import org.champenslabyaddons.fvplus.module.nprison.NPrisonModule;
import org.champenslabyaddons.fvplus.module.nprison.PoiModule;
import org.champenslabyaddons.fvplus.util.Setting;

public class PrisonSubConfiguration extends Config {
  @ParentSwitch
  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> enabledCellModule = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> enabledPoiModule = new ConfigProperty<>(true);

  public PrisonSubConfiguration() {
    Setting.addModuleListener(this.enabled, NPrisonModule.class);
    Setting.addModuleListener(this.enabledCellModule, CellModule.class);
    Setting.addModuleListener(this.enabledPoiModule, PoiModule.class);
  }

  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Boolean> getEnabledCellModule() {
    return this.enabledCellModule;
  }

  public ConfigProperty<Boolean> getEnabledPoiModule() {
    return this.enabledPoiModule;
  }
}
