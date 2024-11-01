package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends Page{

    @FindBy(xpath = "//div[@id='shopping_cart_container']//span")
    private WebElement cartSize;


    @FindBy(xpath = "//div[@id='shopping_cart_container']//a")
    private WebElement cart;

    @FindBy(xpath = "//div[@class='inventory_container']//div//div[@class='inventory_item']")
    private List<WebElement> items;

    public ProductsPage(ChromeDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getItems() {
        return items;
    }

    public Integer getCartSize() {
        return Integer.parseInt(cartSize.getText());
    }

    public void clickOnTheCart() {
        cart.click();
    }

}
