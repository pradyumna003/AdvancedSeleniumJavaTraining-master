package com.qascript.PageObjects;

import com.qascript.BaseClass;
import com.qascript.Utils.BrowserUtils;
import com.qascript.Utils.ExcelUtils;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage extends BaseClass {

    private static String txtEmail = "//input[@id='input-email']";
    private static String txtPassword = "//input[@id='input-password']";
    private static String btnLogin = "//input[@value='Login']";
    private static String linkForgottenPassword = "(//a[text()='Forgotten Password'])[1]";
    private static String alertLoginError = "//div[contains(@class,'alert-danger')]";

    static ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData/Sample.xlsx");

    public static void enterUsername(String email){
        List<String> usernames = excelUtils.readExcelData("Login","Username");
        String username = usernames.get(0);
        System.out.println(usernames.get(0));
        BrowserUtils.enterText(txtEmail,email);
    }

    public static void enterPassword(String password){
        BrowserUtils.enterText(txtPassword,password);
    }

    public static void clickLogin(){
        BrowserUtils.clickElement(btnLogin);
    }

    public static void clickForgottenPassword(){
        driver.findElement(By.xpath(linkForgottenPassword)).click();
    }

    public static void validateInvalidLogin(String expectedMessage) {
        BrowserUtils.validateText(alertLoginError,expectedMessage);
    }

    public static void getUsername(){

    }

    public static void getPassword(){
        List<String> passwords = excelUtils.readExcelData("Login","Password");
    }
}
