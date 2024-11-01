package com.automation.steps;

import com.automation.core.Context;
import com.automation.core.Manager;
import com.automation.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsSteps extends Context {
    public ProductsSteps(Manager manager) {
        super(manager);
    }

    ProductsPage productsPage = new ProductsPage(getDriver());


    @When("first product added to the cart")
    public void first_product_added_to_the_cart() {
        stash("product", productsPage.getItems().get(0).findElement(By.className("inventory_item_name")).getText());
        stash("price", productsPage.getItems().get(0).findElement(By.className("inventory_item_price")).getText());
        productsPage.getItems().get(0).findElement(By.className("btn_inventory")).click();
    }

    @When("second product added to the cart")
    public void second_product_added_to_the_cart() {
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
