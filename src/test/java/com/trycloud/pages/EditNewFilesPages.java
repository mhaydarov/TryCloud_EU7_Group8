package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditNewFilesPages {
    @FindBy(className ="app-icon")
    public WebElement EditPageBtn;

    @FindBy(xpath="//span[@class='icon icon-add']")
    public WebElement PlusBtn;

    @FindBy(className = "displayname")
    public WebElement UpLoadFileOpt;

}
