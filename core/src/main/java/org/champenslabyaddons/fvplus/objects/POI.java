package org.champenslabyaddons.fvplus.objects;

import net.labymod.api.util.Pair;
import java.time.LocalDateTime;

public class POI {
  private final String name;
  private final Pair<String, String> activationPair;
  private final Pair<String, String> cancelationPair;
  private final String updateTimerMessage;
  private final int timedCooldown;
  private LocalDateTime activatableAtTimeAll;
  private LocalDateTime activatableAtTimePersonal;
  private final int waitTimeUponFinish;
  private final int expectedTimeToFinish;
  private final int personalTimedCooldown;

  public POI(String name,
      Pair<String, String> activationPair, Pair<String, String> cancelationPair, String updateTimerMessage,
      int timedCooldown, int waitTimeUponFinish, int expectedTimeToFinish, int personalTimedCooldown) {
    this.name = name;
    this.activationPair = activationPair;
    this.cancelationPair = cancelationPair;
    this.updateTimerMessage = updateTimerMessage;
    this.timedCooldown = timedCooldown;
    this.waitTimeUponFinish = waitTimeUponFinish;
    this.expectedTimeToFinish = expectedTimeToFinish;
    this.personalTimedCooldown = personalTimedCooldown;
  }

  public String getName() {
    return name;
  }

  public Pair<String, String> getActivationPair() {
    return activationPair;
  }

  public Pair<String, String> getCancelationPair() {
    return cancelationPair;
  }

  public String getUpdateTimerMessage() {
    return updateTimerMessage;
  }

  public int getTimedCooldown() {
    return timedCooldown;
  }

  public LocalDateTime getActivatableAtTimeAll() {
    return activatableAtTimeAll;
  }

  public void setActivatableAtTimeAll(LocalDateTime activatableAtTimeAll) {
    this.activatableAtTimeAll = activatableAtTimeAll;
  }

  public LocalDateTime getActivatableAtTimePersonal() {
    return activatableAtTimePersonal;
  }

  public void setActivatableAtTimePersonal(LocalDateTime activatableAtTimePersonal) {
    this.activatableAtTimePersonal = activatableAtTimePersonal;
  }

  public int getWaitTimeUponFinish() {
    return waitTimeUponFinish;
  }

  public int getExpectedTimeToFinish() {
    return expectedTimeToFinish;
  }

  public int getPersonalTimedCooldown() {
    return personalTimedCooldown;
  }
}
