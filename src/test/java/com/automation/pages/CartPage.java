package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page{
    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='cart_contents_container']//a[contains(.,'CHECKOUT')]")
    private WebElement checkOutButton;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;
    @FindBy(className = "inventory_item_price")
    private WebElement productPrice;

    public void checkOut() {
        checkOutButton.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}
