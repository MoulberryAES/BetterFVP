package org.champenslabyaddons.fvp.module;

import java.util.ArrayList;
import java.util.List;

public abstract class BigModule implements Module {
  private final ModuleService moduleService;
  protected List<Module> internalModules;

  public BigModule(ModuleService moduleService) {
    this.moduleService = moduleService;
  }

  @Override
  public void register() {
    moduleService.registerModules(internalModules.toArray(new Module[0]));
  }

  @Override
  public void unregister() {
    for (Module module : internalModules) {
      moduleService.unregisterModule(module);
    }
  }

  protected abstract ArrayList<Module> internalModulesOverview();

  @Override
  public abstract boolean shouldRegisterAutomatically();
}
