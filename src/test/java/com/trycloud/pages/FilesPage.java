package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilesPage extends BasePage{

    @FindBy (xpath = "//*[@id='quota']")
    public WebElement quota;

    @FindBy (xpath = "//*[@class='button new']")
    public WebElement buttonNew;

    @FindBy (xpath = "//*[@data-templatename='New folder']/..")
    public WebElement createFolderButton;

    @FindBy (xpath = "//*[@data-templatename='New text document.md']/..")
    public WebElement createDocButton;

    @FindBy (xpath = "//input[contains(@id, 'input-folder')]")
    public WebElement inputFolder;

    @FindBy (id = "file_upload_start")
    public WebElement input;



    @FindBy (xpath = "//div[@class='hiddenuploadfield']")
    public WebElement inputDiv;

    @FindBy (xpath = "//span[@class='nametext']")
    public List<WebElement> fileNames;

    @FindBy (xpath = "//*[@data-file]")
    public List<WebElement> dataFile;


}
