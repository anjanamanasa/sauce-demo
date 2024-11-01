package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends Page{
    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='cart_contents_container']//a[contains(.,'CHECKOUT')]")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[@id='cart_contents_container']//div[@class='cart_item']")
    private List<WebElement> products;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    public void checkOut() {
        checkOutButton.click();
    }

    public List<String> getProductNames() {
        return productNames.stream().map(productName -> productName.getText()).collect(Collectors.toList());
    }

    public List<String> getProductPrices() {
        return productPrices.stream().map(productPrice -> "$"+productPrice.getText()).collect(Collectors.toList());
    }

    public Integer getProductsSize() {
        return products.size();
    }
}
