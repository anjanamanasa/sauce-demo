package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.CheckoutPage;
import com.automation.utils.Constants;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class CheckoutSteps extends Context {

    private static final Logger log = LoggerFactory.getLogger(CheckoutSteps.class);

    CheckoutPage checkoutPage = new CheckoutPage(getDriver());
    public CheckoutSteps(Manager manager) {
        super(manager);
    }

    @Then("supply {string} as firstName and {string} as lastName")
    public void supply_as_first_name_and_as_last_name(String fName, String lName) {
        log.info("supply first name and last name");
        checkoutPage.sendFirstName(fName);
        checkoutPage.sendLastName(lName);
    }

    @Then("supply {string} as postCode")
    public void supply_as_post_code(String postCode) {
        log.info("supply post code: "+postCode);
        checkoutPage.sendPostCode(postCode);
    }

    @Then("click on the continue button")
    public void click_on_the_continue_button() {
        checkoutPage.clickContinue();
    }

    @Then("Finish button should show and click")
    public void finish_button_should_show_and_click() {
        checkoutPage.clickFinishButton();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertEquals(checkoutPage.getSuccessMessage(), message);
    }

    @Then("Mandatory validation message should be displayed")
    public void mandatory_validation_message_should_be_displayed() {
        Assert.assertTrue(checkoutPage.getErrorMessage().contains(Constants.FIRSTNAME_ERROR_MESSAGE));
    }


}
