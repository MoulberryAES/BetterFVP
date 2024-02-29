package org.champenslabyaddons.fvplus.listeners.internal;

import net.labymod.api.event.Subscribe;
import org.champenslabyaddons.fvplus.event.module.ModuleEvent;
import org.champenslabyaddons.fvplus.module.ModuleService;

public class ModuleListener {
  private final ModuleService moduleService;

  public ModuleListener(ModuleService moduleService) {
    this.moduleService = moduleService;
  }

  @Subscribe
  public void onModuleEvent(ModuleEvent event) {
    this.moduleService.getModules().forEach((module) -> {
      if (module.getClass().getCanonicalName().equals(event.getModuleClass().getCanonicalName())) {
        if (event.getType() == ModuleEvent.Type.ACTIVATE) {
          moduleService.registerModule(module);
        } else if (event.getType() == ModuleEvent.Type.DEACTIVATE) {
          moduleService.unregisterModule(module);
        }
      }
    });
  }
}
