package com.qascript.PageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class CheckoutPage extends BaseClass {

    private static String btnContinueBillingAddress = "//input[@id='button-payment-address']";
    private static String btnContinueDeliveryAddress = "//input[@id='button-shipping-address']";
    private static String btnContinueDeliveryMethod = "//input[@id='button-shipping-method']";
    private static String chkboxTermsAndConditions = "//input[@name='agree']";
    private static String btnContinuePaymentMethod = "//input[@id='button-payment-method']";
    private static String btnConfirmOrder = "//input[@id='button-confirm']";
    private static String txtSubTotalPrice = "//div[@id='content']//table//tfoot/tr[1]//td[2]";
    private static String txtFlatShippingRate = "//div[@id='content']//table//tfoot/tr[2]//td[2]";
    private static String txtTotalPrice = "//div[@id='content']//table//tfoot/tr[3]//td[2]";
    private static String rbExistingAddress = "(//input[@name='payment_address'])[1]";
    private static String rbNewAddress = "(//input[@name='payment_address'])[2]";
    private static String linkPaymentAddress = "//a[contains(@href,'payment-address')]";

    private static final String flatShippingRate = "5.00";

    public static void clickContinueBillingAddress(){
        BrowserUtils.clickElement(btnContinueBillingAddress);
    }

    public static void clickContinueDeliveryAddress(){
        BrowserUtils.clickElement(btnContinueDeliveryAddress);
    }

    public static void clickContinueDeliveryMethod(){
        BrowserUtils.clickElement(btnContinueDeliveryMethod);
    }

    public static void clickContinuePaymentMethod(){
        BrowserUtils.clickElement(btnContinuePaymentMethod);
    }

    public static void clickConfirmOrder(){
        BrowserUtils.clickElement(btnConfirmOrder);
    }

    public static void clickTermsAndConditionsCheckbox(){
        BrowserUtils.clickElement(chkboxTermsAndConditions);
    }

    public static void clickExistingAddress(){
        BrowserUtils.clickElement(rbExistingAddress);
    }

    public static void clickNewAddress(){
        BrowserUtils.clickElement(rbNewAddress);
    }



    public static void validateProductTotalPrice(String expectedProductPrice,String quantity){
        Double totalProductPrice = (Double.parseDouble(expectedProductPrice) * Double.parseDouble(quantity)) + Double.parseDouble(flatShippingRate);
        String totalPrice = "$" + String.format("%.2f",totalProductPrice);
        String actualPrice = driver.findElement(By.xpath(txtTotalPrice)).getText().replaceAll(",","");

        System.out.println("Total Expected Price: " + totalPrice);
        System.out.println("Total Actual Price: " + actualPrice);
        BrowserUtils.validateActualText(totalPrice,actualPrice);
    }


    public static void clickBillingAddress() {
        BrowserUtils.clickElement(linkPaymentAddress);
    }
}
