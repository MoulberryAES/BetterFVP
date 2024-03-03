package org.champenslabyaddons.fvplus.configuration;

import net.labymod.api.Laby;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import org.champenslabyaddons.fvplus.event.module.ModuleEvent;
import org.champenslabyaddons.fvplus.module.nprison.CellModule;
import org.champenslabyaddons.fvplus.module.nprison.NPrisonModule;

public class PrisonSubConfiguration extends Config {
  @ParentSwitch
  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> enabledCellModule = new ConfigProperty<>(true);

  public PrisonSubConfiguration() {
    this.enabled.addChangeListener((enabled) -> {
      if (enabled) {
        Laby.fireEvent(new ModuleEvent(NPrisonModule.class, ModuleEvent.Type.ACTIVATE));
      } else {
        Laby.fireEvent(new ModuleEvent(NPrisonModule.class, ModuleEvent.Type.DEACTIVATE));
      }
    });
    this.enabledCellModule.addChangeListener((enabled) -> {
      if (enabled) {
        Laby.fireEvent(new ModuleEvent(CellModule.class, ModuleEvent.Type.ACTIVATE));
      } else {
        Laby.fireEvent(new ModuleEvent(CellModule.class, ModuleEvent.Type.DEACTIVATE));
      }
    });
  }

  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Boolean> getEnabledCellModule() {
    return this.enabledCellModule;
  }
}
