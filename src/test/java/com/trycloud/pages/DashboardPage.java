package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    @FindBy(xpath="//ul[@id='appmenu']/*[@data-id='contacts']")
    public WebElement contactsModule;
}
