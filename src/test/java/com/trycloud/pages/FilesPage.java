package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

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

    @FindBy (xpath = "//*[@for='select_all_files']")
    public WebElement selectAll;

    @FindBy (id = "selectedActionsList")
    public WebElement actionsButton;

    @FindBy (className = "item-delete")
    public WebElement actionsDeleteButton;


    public String generateName(int leftLimit, int rightLimit, int targetStringLength) {

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public int checkStorage(){
        Driver.get().navigate().refresh();
        WebUtilities.waitFor(2);
        String [] newStorageSize = quota.getText().split(" ");
        return Integer.parseInt(newStorageSize[0]);
    }

}
