package com.qascript.PageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BaseClass {

    private static String btnCheckout = "//a[text()='Checkout']";
    private static String btnContinueShopping = "//a[text()='Continue Shopping']";
    private static String linkProduct = "(//div[@id='content']//table)[1]//tbody//tr[1]/td[2]/a";
    private static String txtboxQuantity = "(//div[@id='content']//table)[1]//tbody//tr[1]/td[4]//input";
    private static String txtPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]/td[5]";
    private static String txtTotalPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]/td[6]";
    private static String btnRemove = "//button[@title='Remove']";
    private static String btnItems = "//div[@id='cart']/button";

    public static void clickCheckout(){
        BrowserUtils.clickElement(btnCheckout);
    }

    public static void clickContinueShopping(){
        BrowserUtils.clickElement(btnContinueShopping);
    }

    public static void validateProductName(String expectedProductName){
        BrowserUtils.validateText(linkProduct,expectedProductName);
    }

    public static void validateProductQuantity(String expectedQuantity){
         BrowserUtils.validateValue(txtboxQuantity,expectedQuantity,"value");
    }

    public static void validateProductPrice(String expectedProductPrice){
        BrowserUtils.validateText(txtPrice,expectedProductPrice);
    }

    public static void validateProductTotalPrice(String expectedProductPrice,String quantity){
        Double totalProductPrice = Double.parseDouble(expectedProductPrice) * Double.parseDouble(quantity);
        String expectedPrice = "$" + String.format("%.2f",totalProductPrice);
        String actualPrice = driver.findElement(By.xpath(txtTotalPrice)).getText().replaceAll(",","");
        System.out.println("Total Expected Price: " + expectedPrice);
        System.out.println("Total Actual Price: " + actualPrice);
        BrowserUtils.validateActualText(expectedPrice,actualPrice);
    }

    public static void clearShoppingCart(){
        List<WebElement> removeElements = driver.findElements(By.xpath(btnRemove));
        if(removeElements.size()>0){
            for(WebElement element: removeElements){
                BrowserUtils.clickElement(btnItems);
                element.click();
            }
        }

    }

}
