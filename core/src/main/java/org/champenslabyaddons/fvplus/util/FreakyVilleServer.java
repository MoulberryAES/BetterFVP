package org.champenslabyaddons.fvplus.util;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.TranslatableComponent;
import net.labymod.api.util.I18n;

/**
 * Enum for at repræsentere de forskellige FreakyVille servere.
 * Vi bruger denne til at identificere hvilken server klienten er på.
 * Den indeholder også repræsentationer af servere, der ikke længere er tilgængelige.
 */
public enum FreakyVilleServer {
  PRISON("fvp.server.prison.name"),
  CREATIVE("fvp.server.creative.name"),
  SKY_BLOCK("fvp.server.skyBlock.name"),
  THE_CITY("fvp.server.city.name"),
  KIT_PVP("fvp.server.kitpvp.name"),
  HUB("fvp.server.hub.name"),
  NONE(""),

  /**
   * @deprecated Ekspeditionen er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated(forRemoval = false)
  THE_EXPEDITION("Ekspeditionen"),

  /**
   * @deprecated Factions er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated(forRemoval = false)
  FACTIONS("Factions"),

  /**
   * @deprecated OP-Prison er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated(forRemoval = false)
  OP_PRISON("OP-Prison"),

  /**
   * @deprecated Rumrejsen er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated(forRemoval = false)
  SPACE_JOURNEY("Rumrejsen"),
  ;

  private final String nameKey;

  FreakyVilleServer(String nameKey) {
      this.nameKey = nameKey;
  }

  public String getNameKey() {
      return nameKey;
  }

  public String getTranslatedName() {
      return I18n.getTranslation(nameKey);
  }

  public TranslatableComponent getTranslatedComponent() {
      return Component.translatable(nameKey);
  }

  public static FreakyVilleServer fromString(String scoreBoardTitle) {
      return switch (scoreBoardTitle) {
          case "FV Skyblock" -> FreakyVilleServer.SKY_BLOCK;
          case "FV PRISON" -> FreakyVilleServer.PRISON;
          case "FRIHEDEN" -> FreakyVilleServer.THE_CITY;
          case "FV Creative" -> FreakyVilleServer.CREATIVE;
          case "FreakyVille" -> FreakyVilleServer.HUB;
          /*
           * KitPvP har flere forskellige navne, ifølge det "scoreboard" klienten læser.
           * Derfor tjekker vi for flere navne. Det skifter engang i mellem?
           */
          case "FV KitPvP", "HP", "mvdwan" -> FreakyVilleServer.KIT_PVP;
          default -> FreakyVilleServer.NONE;
      };
  }
}
