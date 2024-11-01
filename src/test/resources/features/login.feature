Feature: Login functionality of saucedemo

  Scenario: Unsuccessful login with invalid user credentials
    Given navigate to login page of sauce demo 'https://www.saucedemo.com/v1/index.html'
    When invalid username and password supplied
    And click on the login button
    Then user should be notified with invalid login message


  Scenario: Successful login with valid user credentials
    Given navigate to login page of sauce demo 'https://www.saucedemo.com/v1/index.html'
    When valid username and password supplied
    And click on the login button
    Then user should be redirected to products page

