package com.automation.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsPage extends Page{

    public ProductsPage(ChromeDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
