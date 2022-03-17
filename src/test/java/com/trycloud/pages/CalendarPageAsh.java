package com.trycloud.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CalendarPageAsh extends BasePage {


    @FindBy(xpath = "//button[starts-with(@aria-controls,'menu')]")
    public WebElement hamburgerButton;

    @FindBy(xpath = "//ul[starts-with(@id,'menu')]//span[@ class='action-button__text']")
    public List<WebElement> hamburgerOption;
    }
