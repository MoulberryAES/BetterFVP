package org.champenslabyaddons.fvp.util;

import net.labymod.api.client.chat.ChatExecutor;

public final class Messaging {
  private static ChatExecutor executor;
  private static boolean isSet;

  private Messaging() {}

  public static void setExecutor(ChatExecutor executor) {
    if (isSet) {
      throw new RuntimeException("You can not change the ChatExecutor later.");
    }
    Messaging.executor = executor;
    Messaging.isSet = true;
  }

  public static ChatExecutor executor() {
    return Messaging.executor;
  }
}
