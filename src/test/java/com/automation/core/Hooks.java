package com.automation.core;

import com.automation.steps.LoginSteps;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import java.util.logging.Level;

public class Hooks extends Context {

  private static final Logger log = LoggerFactory.getLogger(Hooks.class);

  public Hooks(Manager manager) {
    super(manager);
  }

  @Before()
  public void before() {
    ChromeOptions options = new ChromeOptions();

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    options.addArguments("start-maximized");
    options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);

    manager.setDriver(new ChromeDriver(options));
    log.info("The new driver instance created");
  }

  @BeforeStep
  public void beforeStep() {
    log.info("Starting step..............................");
  }

  @AfterStep
  public void afterStep(Scenario scenario) {
    byte[] screenshot = getDriver().getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", scenario.getName());
    log.info("End of step..............................");
  }

  @After
  public void after() {
    getDriver().quit();
    log.info("Quit driver");
  }

}
