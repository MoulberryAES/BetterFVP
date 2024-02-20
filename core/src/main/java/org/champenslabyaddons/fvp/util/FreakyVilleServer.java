package org.champenslabyaddons.fvp.util;

/**
 * Enum for at repræsentere de forskellige FreakyVille servere.
 * Vi bruger denne til at identificere hvilken server klienten er på.
 * Den indeholder også repræsentationer af servere, der ikke længere er tilgængelige.
 */
public enum FreakyVilleServer {
  // FOR LABY DEVS: The server names are all in Danish, as the server is Danish.
  // There is no need to translate them, as the server is not International.
  PRISON("NPrison"),
  CREATIVE("Kreativ"),
  SKY_BLOCK("Skyblock"),
  THE_CITY("Friheden"),
  KIT_PVP("KitPvP"),
  HUB("Hubben"),
  NONE(""),

  /**
   * @deprecated Ekspeditionen er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated
  THE_EXPEDITION("Ekspeditionen"),

  /**
   * @deprecated Factions er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated
  FACTIONS("Factions"),

  /**
   * @deprecated OP-Prison er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated
  OP_PRISON("OP-Prison"),

  /**
   * @deprecated Rumrejsen er ikke længere tilgængelig. Den kan blive genaktiveret i fremtiden.
   */
  @Deprecated
  SPACE_JOURNEY("Rumrejsen"),
  ;

  private final String serverName;

  FreakyVilleServer(String serverName) {
      this.serverName = serverName;
  }

  public String getServerName() {
      return serverName;
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
