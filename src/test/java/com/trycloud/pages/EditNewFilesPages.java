package com.trycloud.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class EditNewFilesPages extends BasePage {
    @FindBy(xpath ="//*[@id='appmenu']/*[@data-id='files']/a")
    public WebElement EditPageBtn;


    @FindBy(xpath="//span[@class='icon icon-add']")
    public WebElement PlusBtn;

    @FindBy(xpath="//span[text()='Upload file']")
    public WebElement UpLoadFileOpt;
    @FindBy (xpath="//span[text='Albert_Interview_Prep']")
    public WebElement FileUploaded;


public void Verifyfile(){
    String expectedResult="Albert_Interview_Prep";
    String actualResult= FileUploaded.getText();
    Assert.assertEquals(expectedResult,actualResult);

}
public void WsTab(){
    UpLoadFileOpt.click();

}
}
