Feature: Login Page

  @smoke
  Scenario: User is able to login with valid credentials

      Given user enters valid username in the email field
      And user enters valid password in the password field
      When user clicks on the login button
      Then user is logged in successfully

  @smoke @regression
  Scenario Outline: User is not able to login with invalid credentials

      Given user enters invalid <email> in the email field
      And user enters invalid <password> in the password field
      When user clicks on the login button
      Then error <message> is displayed

    Examples:
      | email             | password    |   message                                            |
      | patebij@gmail.com | 1234        | Warning: No match for E-Mail Address and/or Password.|
      | test@gmail.com    | test@123    | Warning: No match for E-Mail Address and/or Password.|
      | test1@gmail.com   | test1234    | Warning: No match for E-Mail Address and/or Password.|




