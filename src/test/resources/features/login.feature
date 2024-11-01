Feature: Login functionality of saucedemo

  @TC#001
  Scenario Outline: Successful login with valid user credentials
    Given navigate to login page of sauce demo 'https://www.saucedemo.com/v1/index.html'
    When valid username "<username>" and password "<password>" supplied
    And click on the login button
    Then user should be redirected to products page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |

  @TC#002
  Scenario Outline: Unsuccessful login with invalid user credentials
    Given navigate to login page of sauce demo 'https://www.saucedemo.com/v1/index.html'
    When invalid username "<username>" and password "<password>" supplied
    And click on the login button
    Then user should be notified with invalid login message

    Examples:
      | username      | password     |
      | invalid_user | secret_sauce |


