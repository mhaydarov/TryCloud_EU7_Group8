package com.trycloud.pages;

import com.trycloud.utilities.WebUtilities;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.trycloud.utilities.WebUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//ul[@id='appmenu']/*[@data-id='contacts']")
    public WebElement contactsModule;
    @FindBy(css = "#expand")
    public WebElement profileButton;

    public void clickOnDashBoard(WebElement element){
        WebUtilities.waitForVisibility(element,5);
        element.click();

    }

}
