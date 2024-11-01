Feature: Add to cart and remove products from the cart

  Background:
    Given Log into saucedemo 'https://www.saucedemo.com/v1/index.html' with valid credentials

  Scenario: Add and remove products and verify the products size in cart
    When first product added to the cart
    And second product added to the cart
    Then the cart size should be displayed as {2}
    When first product removed from the cart
    Then the cart size should be displayed as {1}