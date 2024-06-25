Feature: Add Products to Shopping Cart

 Background:
  Given user enters valid username in the email field
  And user enters valid password in the password field
  And user clicks on the login button
  And user clears the shopping cart

   Scenario: User is able to add products into the shopping cart
    Given user clicks on Show All Notebooks and Laptops link
    And user clicks on Macbook product
    And user enters the quantity of the product
    When user clicks on Add to Cart button for Macbook product
    And user clicks on Shopping Cart link
    Then Macbook product is added to the shopping cart

