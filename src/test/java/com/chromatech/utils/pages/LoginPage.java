package com.chromatech.utils.pages;

import com.chromatech.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "form-username")
    private WebElement usernameTextBox;

    @FindBy(id = "form-password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div[2]/form/button")
    private WebElement signInButton;

    public WebElement getUsernameTextBox(){
        return usernameTextBox;
    }

    public WebElement getPasswordTextBox(){
        return passwordTextBox;
    }

    public WebElement getSignInButton(){
        return signInButton;
    }

    public LoginPage(){
        PageFactory.initElements(WebDriverUtils.driver, this);
    }
}
