package com.automation.core;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class Manager {

  private ChromeDriver driver;

  public HashMap<String, Object> stash;

  public Manager() {
    this.stash =new HashMap<>();

  }

  public ChromeDriver getDriver() {
    return driver;
  }

  public void setDriver(ChromeDriver driver) {
    this.driver = driver;
  }
}