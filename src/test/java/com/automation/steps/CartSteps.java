package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps extends Context {

    public CartSteps(Manager manager) {
        super(manager);
    }
    CartPage cartPage = new CartPage(getDriver());

    @Then("the cart page should show the selected item")
    public void the_cart_page_should_show_the_selected_item() {
        Assert.assertEquals(cartPage.getProductName(), getTestStash().get("product"));
        Assert.assertEquals("$"+cartPage.getProductPrice(), getTestStash().get("price"));
    }

    @When("click on the checkout button")
    public void click_on_the_checkout_button() {
        cartPage.checkOut();
    }

}
