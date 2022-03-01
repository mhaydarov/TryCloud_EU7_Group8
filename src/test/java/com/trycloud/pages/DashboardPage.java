package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy (xpath = "//*[@id='appmenu']/*[@data-id='files']")
    public WebElement filesMenu;

}
