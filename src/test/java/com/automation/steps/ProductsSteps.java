package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsSteps extends Context {

    private static final Logger log = LoggerFactory.getLogger(ProductsSteps.class);
    public ProductsSteps(Manager manager) {
        super(manager);
    }

    ProductsPage productsPage = new ProductsPage(getDriver());


    @When("first product added to the cart")
    public void first_product_added_to_the_cart() {
        List<String> products = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        products.add(productsPage.getItems().get(0).findElement(By.className("inventory_item_name")).getText());
        prices.add(productsPage.getItems().get(0).findElement(By.className("inventory_item_price")).getText());
        stash("products", products);
        stash("prices", prices);
        log.info("The selected product: " + getTestStash().get("products"));
        productsPage.getItems().get(0).findElement(By.className("btn_inventory")).click();
    }

    @When("second product added to the cart")
    public void second_product_added_to_the_cart() {
        List<String> products = (List<String>) getTestStash().get("products");
        List<String> prices = (List<String>) getTestStash().get("prices");
        products.add(productsPage.getItems().get(1).findElement(By.className("inventory_item_name")).getText());
        prices.add(productsPage.getItems().get(1).findElement(By.className("inventory_item_price")).getText());
        stash("products", products);
        stash("prices", prices);

        productsPage.getItems().get(1).findElement(By.className("btn_inventory")).click();
    }
    @Then("the cart size should be displayed as \\{{int}}")
    public void the_cart_size_should_be_displayed_as(Integer count) {
        Assert.assertEquals(productsPage.getCartSize(), count);
    }

    @When("click on the cart button")
    public void click_on_the_cart_button() {
        productsPage.clickOnTheCart();
    }

    @When("first product removed from the cart")
    public void first_product_removed_from_the_cart() {
        productsPage.getItems().get(0).findElement(By.className("btn_inventory")).click();
    }

}
