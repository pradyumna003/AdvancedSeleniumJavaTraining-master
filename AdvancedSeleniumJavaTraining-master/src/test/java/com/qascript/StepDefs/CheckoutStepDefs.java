package com.qascript.StepDefs;

import com.qascript.PageObjects.CheckoutPage;
import com.qascript.PageObjects.ConfirmationPage;
import com.qascript.PageObjects.ShoppingCartPage;
import io.cucumber.java.en.And;

public class CheckoutStepDefs {
    @And("user clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        ShoppingCartPage.clickCheckout();
    }

    @And("user clicks on Continue button on Billing Details")
    public void userClicksOnContinueButtonOnBillingDetails() {
        CheckoutPage.clickBillingAddress();
        CheckoutPage.clickBillingAddress();
        CheckoutPage.clickContinueBillingAddress();
    }

    @And("user clicks on Continue button on Delivery Details")
    public void userClicksOnContinueButtonOnDeliveryDetails() {
        CheckoutPage.clickContinueDeliveryAddress();
    }

    @And("user clicks on Continue button on Delivery Method")
    public void userClicksOnContinueButtonOnDeliveryMethod() {
        CheckoutPage.clickContinueDeliveryMethod();
    }

    @And("user clicks on Terms checkbox on Payment Method")
    public void userClicksOnTermsCheckboxOnPaymentMethod() {
        CheckoutPage.clickTermsAndConditionsCheckbox();
    }

    @And("user clicks on Continue button on Payment Method")
    public void userClicksOnContinueButtonOnPaymentMethod() {
        CheckoutPage.clickContinuePaymentMethod();
    }

    @And("user clicks on Confirm Order button")
    public void userClicksOnConfirmOrderButton() {
        CheckoutPage.validateProductTotalPrice("100.00","5");
        CheckoutPage.clickConfirmOrder();
    }

    @And("user gets a confirmation message")
    public void userGetsAConfirmationMessage() {
        ConfirmationPage.validateConfirmation("Your order has been placed!");
    }
}
