package com.talentlms.UI.pages;

import com.talentlms.UI.helpers.Helper;
import com.talentlms.UI.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class loginPage {

    public loginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    Helper helper = new Helper();

    @FindBy(xpath = "//input[@name=\"login\"]")
    public WebElement userNameOrEmailInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name=\"submit\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//img[@class=\"avatar-square\"]")
    public WebElement avatar;

    public loginPage inputUserNameOrEmail(String userNameOrEmail){
        helper.sendKeys(userNameOrEmailInput,userNameOrEmail);
        return this;
    }

    public loginPage inputPassword(String password){
        helper.sendKeys(passwordInput,password);
        return this;
    }

    public loginPage clickLoginBotton(){
        helper.click(loginButton);
        return this;
    }

    public loginPage clickAvatar(){
        helper.click(avatar);
        return this;
    }
}
