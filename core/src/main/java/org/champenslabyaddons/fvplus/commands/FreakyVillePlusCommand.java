package org.champenslabyaddons.fvplus.commands;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public abstract class FreakyVillePlusCommand extends Command {

  protected FreakyVillePlusCommand(@NotNull String prefix, String serverAndCategoryKey, @NotNull String... aliases) {
    super(prefix, aliases);
    String translationKey = "fvplus.";
    if (serverAndCategoryKey != null && !serverAndCategoryKey.isEmpty()) {
      translationKey += "server." + serverAndCategoryKey + ".";
    }
    translationKey += "commands." + prefix;
    this.translationKey(translationKey);
    this.messagePrefix(this.addonPrefix());
  }

  public abstract boolean execute(String prefix, String[] arguments);

  protected final List<String> subCommandPrefixes() {
    return this.getSubCommands().stream().map(Command::getPrefix).toList();
  }

  private Component addonPrefix() {
    Component leftBracket = Component.text("[", NamedTextColor.DARK_GRAY);
    Component rightBracket = Component.text("] ", NamedTextColor.DARK_GRAY);
    Component text = Component.translatable("fvplus.prefix", NamedTextColor.GOLD)
        .append(Component.text("+", NamedTextColor.AQUA));
    return leftBracket.append(text).append(rightBracket);
  }
}
