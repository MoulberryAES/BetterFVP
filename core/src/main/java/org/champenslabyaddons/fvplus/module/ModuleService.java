package org.champenslabyaddons.fvplus.module;

import net.labymod.api.util.logging.Logging;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleService {
  private final Logging logger;
  private final List<Module> modules;

  public ModuleService(Logging logger) {
    this.logger = logger;
    this.modules = new ArrayList<>();
  }

  /**
   * Registrere et enkelt modul.
   *
   * @param module Modulet du vil registrere
   */
  public void registerModule(Module module) {
    if (module.isRegistered()) {
      return;
    }
    module.register();
    if (!modules.contains(module)) {
      modules.add(module);
    }
    String registrationMessage = "REGISTERED MODULE | " + module.getClass().getTypeName();
    if (module instanceof BigModule) {
      registrationMessage += (" " + Arrays.toString(((BigModule) module).internalModulesOverview().toArray(new Module[0])));
    }
    logger.info(registrationMessage);
  }

  /**
   * Registrere flere moduler på én gang, hvis de bør registres.
   *
   * @param modules Modulerne du vil registrere
   */
  public void registerModules(Module... modules) {
    for (Module module : modules) {
      if (module.shouldRegisterAutomatically()) {
        this.registerModule(module);
      }
    }
  }

  /**
   * Fjerner et modul fra listen over registrerede moduler.
   * @param module Modulet du vil fjerne
   * @apiNote Lad være med at fjerne et registreret modul hvis det ikke er meningen.
   */
  public void unregisterModule(Module module) {
    if (!module.isRegistered()) {
      return;
    }
    module.unregister();
    logger.info("UNREGISTERED MODULE | " + module.getClass().getTypeName());
  }

  /**
   * Fjerner alle registrerede moduler fra listen.
   * @deprecated Det er ikke sikkert der vil være et behov for metoden. Vi har den her til hvis den skulle blive nødvendig.
   */
  @Deprecated(since = "pre-1.0.0")
  public void unregisterAllModules() {
    for (Module module : modules) {
      unregisterModule(module);
    }
  }

  public List<Module> getModules() {
    return List.copyOf(modules);
  }
}
