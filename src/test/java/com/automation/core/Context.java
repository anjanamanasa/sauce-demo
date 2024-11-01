package com.automation.core;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class Context {

  protected Manager manager;

  public Context(Manager manager) {
    this.manager = manager;
  }

  public ChromeDriver getDriver() {
    return manager.getDriver();
  }

  public HashMap<String, Object> getTestStash() {
    return  manager.stash;
  }

  public <T> void stash(String key , T value) {
    manager.stash.put(key , value);
  }

}