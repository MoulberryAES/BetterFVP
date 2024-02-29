package org.champenslabyaddons.fvplus.module;

public interface Module {

  void register();
  void unregister();
  boolean shouldRegisterAutomatically();
  boolean isRegistered();
}
