package org.champenslabyaddons.fvplus.module;

import java.util.ArrayList;
import java.util.List;

public abstract class BigModule implements Module {
  private final ModuleService moduleService;
  protected List<Module> internalModules;
  private boolean registered;

  public BigModule(ModuleService moduleService) {
    this.moduleService = moduleService;
    this.registered = false;
  }

  @Override
  public void register() {
    moduleService.registerModules(internalModules.toArray(new Module[0]));
    this.registered = true;
  }

  @Override
  public void unregister() {
    for (Module module : internalModules) {
      moduleService.unregisterModule(module);
    }
    this.registered = false;
  }

  protected abstract ArrayList<Module> internalModulesOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();

  public boolean isRegistered() {
    return this.registered;
  }
}
