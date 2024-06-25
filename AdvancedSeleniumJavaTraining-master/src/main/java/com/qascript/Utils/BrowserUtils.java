package com.qascript.Utils;

import com.qascript.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class BrowserUtils extends BaseClass {

    static Properties properties = PropertiesUtil.loadFrameworkProperties();

    public static void clickElement(String element){
        findAndWaitForElement(element).click();
    }

    public static void hoverAndClickOnElement(String element1,String element2){
        WebElement e1 = driver.findElement(By.xpath(element1));
        WebElement e2 = driver.findElement(By.xpath(element2));

        Actions actions = new Actions(driver);
        actions.moveToElement(e1).click(e2).build().perform();
    }

    public static void enterText(String element,String text){
        findAndWaitForElement(element).clear();
        findAndWaitForElement(element).sendKeys(text);
    }

    public static WebElement findAndWaitForElement(String xpath){
        String timeout = properties.getProperty("timeout.maximum");
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(timeout));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        return element;
    }


    public static void validateText(String element,String expectedText) {

        String actualText = findAndWaitForElement(element).getText();
        Assert.assertTrue("Expected Text: " + expectedText + " is not matching with Actual Text: " + actualText,
                expectedText.equals(actualText));

    }

    public static void validateActualText(String expectedText, String actualText){
        Assert.assertTrue("Expected Text: " + expectedText + " is not matching with Actual Text: " + actualText,
                expectedText.equals(actualText));
    }

    public static void validateValue(String element,String expectedValue,String attributeType){

        String actualValue = findAndWaitForElement(element).getAttribute(attributeType);
        Assert.assertTrue("Expected Value: " + expectedValue + " is not matching with Actual Value: " + actualValue,
                expectedValue.equals(actualValue));
    }
}
