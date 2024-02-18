package org.champenslabyaddons.fvp.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleService {
  private final List<Module> registeredModules;

  public ModuleService() {
    this.registeredModules = new ArrayList<>();
  }

  /**
   * Registrere et enkelt modul, der er ikke et check for om modulet bør registreres.
   *
   * @param module Modulet du vil registrere
   * @apiNote Lad være med at benytte denne medmindre du ved hvad du laver.
   */
  public void registerModule(Module module) {
    module.register();
    registeredModules.add(module);
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
    module.unregister();
    registeredModules.remove(module);
  }

  /**
   * Fjerner alle registrerede moduler fra listen.
   * @deprecated Det er ikke sikkert der vil være et behov for metoden. Vi har den her til hvis den skulle blive nødvendig.
   */
  @Deprecated(since = "pre-1.0.0")
  public void unregisterAllModules() {
    for (Module module : registeredModules) {
      unregisterModule(module);
    }
  }
}
