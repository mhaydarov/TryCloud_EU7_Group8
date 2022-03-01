package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }




    public void navigateAppMenu(String module) {

        String appmenuLocator = "//*[@id='appmenu']/*[@data-id='"+module+"']";

        Driver.get().findElement(By.xpath(appmenuLocator)).click();

    }


}
