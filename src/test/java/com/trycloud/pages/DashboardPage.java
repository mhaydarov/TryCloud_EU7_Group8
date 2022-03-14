package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy (xpath = "//*[@id='appmenu']/*[@data-id='files']")
    public WebElement filesMenu;



    public void navigateAppMenu(String module) {

        String appmenuLocator = "//*[@id='appmenu']/*[@data-id='"+module+"']";

        Driver.get().findElement(By.xpath(appmenuLocator)).click();

    }

}
