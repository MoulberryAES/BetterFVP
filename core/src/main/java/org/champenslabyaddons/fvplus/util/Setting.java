package org.champenslabyaddons.fvplus.util;

import net.labymod.api.Laby;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import org.champenslabyaddons.fvplus.event.module.ModuleEvent;
import org.champenslabyaddons.fvplus.module.Module;

public final class Setting {
  private Setting() {}

  public static void addModuleListener (ConfigProperty<Boolean> to, Class<? extends Module> moduleClass) {
    to.addChangeListener((enabled) -> {
      if (enabled) {
        Laby.fireEvent(new ModuleEvent(moduleClass, ModuleEvent.Type.ACTIVATE));
      } else {
        Laby.fireEvent(new ModuleEvent(moduleClass, ModuleEvent.Type.DEACTIVATE));
      }
    });
  }
}
