package com.qascript.PageObjects;

import com.qascript.Utils.BrowserUtils;

public class ConfirmationPage {

    private static String txtSuccessMessage = "//div[@id='content']/h1";


    public static void validateConfirmation(String expectedMessage){
        BrowserUtils.validateText(txtSuccessMessage,expectedMessage);
    }
}
