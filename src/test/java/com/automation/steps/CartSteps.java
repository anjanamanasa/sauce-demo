package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class CartSteps extends Context {

    public CartSteps(Manager manager) {
        super(manager);
    }
    CartPage cartPage = new CartPage(getDriver());

    @Then("the cart page should show the selected items")
    public void the_cart_page_should_show_the_selected_items() {
        List<String> products = (List<String>)getTestStash().get("products");
        List<String> prices = (List<String>)getTestStash().get("prices");
        Assert.assertEquals(cartPage.getProductsSize(), products.size());
        Assert.assertEquals(cartPage.getProductNames(), products);
        Assert.assertEquals(cartPage.getProductPrices(), prices);
    }


    @When("click on the checkout button")
    public void click_on_the_checkout_button() {
        cartPage.checkOut();
    }

}
