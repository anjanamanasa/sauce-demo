Feature: Add products to cart and checkout

  Background:
    Given Log into saucedemo 'https://www.saucedemo.com/v1/index.html' with valid credentials

  Scenario: Add products and verify the user should be able checkout with valid data
    When first product added to the cart
    And click on the cart button
    Then the cart page should show the selected item
    When click on the checkout button
    And supply 'Jack' as firstName and 'Daniel' as lastName
    And supply 'CV2 4EX' as postCode
    And click on the continue button
    Then Finish button should show and click
    And 'THANK YOU FOR YOUR ORDER' message should be displayed

  Scenario: The user should not be able checkout without providing user information
    When first product added to the cart
    And click on the cart button
    Then the cart page should show the selected item
    When click on the checkout button
    And click on the continue button
    Then Mandatory validation message should be displayed
