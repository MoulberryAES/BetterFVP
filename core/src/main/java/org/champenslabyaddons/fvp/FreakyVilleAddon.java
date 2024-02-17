package org.champenslabyaddons.fvp;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class FreakyVilleAddon extends LabyAddon<FreakyVillePlusConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<FreakyVillePlusConfiguration> configurationClass() {
    return FreakyVillePlusConfiguration.class;
  }
}
