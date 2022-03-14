package com.trycloud.pages;

import com.trycloud.utilities.WebUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDisplayPage extends BasePage {

    @FindBy (xpath="//div[@class='avatardiv avatardiv-shown']")
    public WebElement NameIkon;

    @FindBy (linkText = "Settings")
    public WebElement SettingBtn;

    @FindBy(id = "displayname")
    public WebElement NameBox;

    @FindBy(id="email")
    public WebElement EmailBox;

    @FindBy (id="phone")
    public WebElement PhoneBox;

    //@FindBy
    public  void getSettingsPage(){
        NameIkon.click();
      WebUtilities.waitFor(2);
        SettingBtn.click();
    }
    public void setNameBox(String name2){
        WebUtilities.waitFor(3);
        NameBox.click();
        NameBox.clear();
        NameBox.sendKeys(name2, Keys.ENTER);



    }
    public void cleanBox(){

    }
}
