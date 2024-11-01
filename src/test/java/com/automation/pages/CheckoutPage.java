package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Page {

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postCode;

    @FindBy(xpath = "//div[@class='checkout_buttons']//input[@value='CONTINUE']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id= 'checkout_summary_container']//div[@class='cart_footer']//a[contains(.,'FINISH')]")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@id='checkout_complete_container']//h2")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@id='checkout_info_container']//h3")
    private WebElement errorMessage;

    public CheckoutPage(ChromeDriver driver) {
        super(driver);
    }

    public void sendFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void sendLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void sendPostCode(String pCode) {
        postCode.sendKeys(pCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
