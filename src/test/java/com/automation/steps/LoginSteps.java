package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginSteps extends Context {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    public LoginSteps(Manager manager) {
        super(manager);
    }
    LoginPage loginPage = new LoginPage(getDriver());
    ProductsPage productsPage = new ProductsPage(getDriver());


    @Given("navigate to login page of sauce demo {string}")
    public void navigate_to_login_page_of_sauce_demo(String url) {
        manager.getDriver().get(url);
    }

    @When("valid username {string} and password {string} supplied")
    public void valid_username_and_password_supplied(String username, String password) {
        log.info("User logged in with valid username and password"+ username);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

    }
    @When("click on the login button")
    public void click_on_the_login_button() {
        loginPage.clickLogin();
    }
    @Then("user should be redirected to products page")
    public void user_should_be_redirected_to_products_page() {
        Assert.assertEquals(productsPage.getTitle(), Constants.TITLE);
    }

    @Given("Log into saucedemo {string} with valid credentials")
    public void log_into_saucedemo_with_valid_credentials(String url) {
        manager.getDriver().get(url);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        log.info("Valid user logged in");
    }

    @When("invalid username {string} and password {string} supplied")
    public void invalid_username_and_password_supplied(String username, String password) {
        log.info("User logged in with valid username and password"+ username);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

    }

    @Then("user should be notified with invalid login message")
    public void user_should_be_notified_with_invalid_login_message() {
        log.info("Invalid login message should be displayed");
        Assert.assertTrue(loginPage.getInvalidLoginMessage().contains(Constants.INVALID_LOGIN_MESSAGE));
    }


}
