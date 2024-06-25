package com.qascript.StepDefs;

import com.qascript.PageObjects.HomePage;
import com.qascript.PageObjects.ProductsPage;
import com.qascript.PageObjects.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepDefs {

    @Given("user clicks on Show All Notebooks and Laptops link")
    public void userClicksOnShowAllNotebooksAndLaptopsLink() {
        HomePage.clickAllLaptopsAndNotebooks();
    }


    @When("user clicks on Add to Cart button for Macbook product")
    public void userClicksOnAddToCartButtonForMacbookProduct() {
        ProductsPage.validateProduct("MacBook");
        ProductsPage.validatePrice("$500.00");
        ProductsPage.clickAddToCartButton();
    }

    @Then("Macbook product is added to the shopping cart")
    public void macbookProductIsAddedToTheShoppingCart() {
        ShoppingCartPage.validateProductName("MacBook");
        ShoppingCartPage.validateProductQuantity("2");
        ShoppingCartPage.validateProductPrice("$500.00");
        ShoppingCartPage.validateProductTotalPrice("500.00","2");
    }

    @And("user clicks on Macbook product")
    public void userClicksOnMacbookProduct() {
        ProductsPage.clickProduct();
    }

    @And("user enters the quantity of the product")
    public void userEntersTheQuantityOfTheProduct() {
        ProductsPage.enterQuantity("10");
    }

    @And("user clicks on Shopping Cart link")
    public void userClicksOnShoppingCartLink() {
        HomePage.clickShoppingCart();
    }

    @And("user clears the shopping cart")
    public void userClearsTheShoppingCart() {
        ShoppingCartPage.clearShoppingCart();
    }

    @Then("HP product is added to the shopping cart")
    public void hpProductIsAddedToTheShoppingCart() {
        ShoppingCartPage.validateProductName("HP LP3065");
        ShoppingCartPage.validateProductQuantity("10");
        ShoppingCartPage.validateProductPrice("$100.00");
        ShoppingCartPage.validateProductTotalPrice("100.00","10");

    }

    @And("user clicks on HP Laptop")
    public void userClicksOnHPLaptop() {
        ProductsPage.clickHPLaptop();
    }

    @When("user clicks on Add to Cart button for HP Laptop")
    public void userClicksOnAddToCartButtonForHPLaptop() {
        ProductsPage.validateProduct("HP LP3065");
        ProductsPage.validatePrice("$100.00");
        ProductsPage.clickAddToCartButton();
    }
}
