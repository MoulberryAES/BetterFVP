package org.champenslabyaddons.fvplus.commands;

import net.labymod.api.client.chat.command.SubCommand;
import org.champenslabyaddons.fvplus.util.Messaging;
import org.jetbrains.annotations.NotNull;

public abstract class FreakyVillePlusSubCommand extends SubCommand {
  protected FreakyVillePlusSubCommand(@NotNull String prefix, String serverAndCategoryKey, @NotNull String... aliases) {
    super(prefix, aliases);
    String translationKey = "fvplus.";
    if (serverAndCategoryKey != null && !serverAndCategoryKey.isEmpty()) {
      translationKey += "server." + serverAndCategoryKey + ".";
    }
    translationKey += "commands." + prefix;
    this.translationKey(translationKey);
    this.messagePrefix(Messaging.addonPrefix());
  }

  public abstract boolean execute(String prefix, String[] arguments);
}
