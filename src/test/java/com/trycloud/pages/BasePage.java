package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#expand")
    public WebElement profileButton;

    public void clickOnDashBoard(WebElement element){
        WebUtilities.waitForVisibility(element,5);
        element.click();

    }
}
