Feature: Checkout Products

  Background:
    Given user enters valid username in the email field
    And user enters valid password in the password field
    And user clicks on the login button
    And user clears the shopping cart

  Scenario: User is able to checkout products from Shopping Cart

    Given user clicks on Show All Notebooks and Laptops link
    And user clicks on HP Laptop
    And user enters the quantity of the product
    When user clicks on Add to Cart button for HP Laptop
    And user clicks on Shopping Cart link
    Then HP product is added to the shopping cart
    And user clicks on Checkout button
    And user clicks on Continue button on Billing Details
    And user clicks on Continue button on Delivery Details
    And user clicks on Continue button on Delivery Method
    And user clicks on Terms checkbox on Payment Method
    And user clicks on Continue button on Payment Method
    And user clicks on Confirm Order button
    And user gets a confirmation message
