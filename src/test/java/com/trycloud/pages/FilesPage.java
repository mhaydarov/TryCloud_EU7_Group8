package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy (xpath = "//*[@class='filenameform']/input[@type='submit']")
    public WebElement createDocSubmitButton;

    @FindBy (xpath = "//input[contains(@id, 'input-folder')]")
    public WebElement inputFolder;

    @FindBy (xpath = "//input[contains(@id, 'input-file')]")
    public WebElement inputFile;

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

    @FindBy (xpath = "//*[@class='innernametext']/text()[contains(translate(.,'TEST','test'),'test')]/../../../../../td[@class='selection']")
    public List<WebElement> selectTestOnly;

    @FindBy (xpath = "//*[contains(text(),'New text document')]/../../../../td[@class='selection']")
    public List<WebElement> selectNewTextDocOnly;

    @FindBy (xpath = "//*[@class='modal-title']")
    public WebElement docTitle;

    @FindBy (xpath = "//*[@class='tooltip-inner']")
    public WebElement folderDuplicateMessage;

    @FindBy (xpath = "//button[@rel='noreferrer noopener'][2]")
    public WebElement docCloseButton;

    @FindBy (xpath = "//*[@class='newFileMenu popovermenu bubble menu open menu-left']")
    public WebElement plusBubble;

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

    public String createDoc(String docname){
        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc==========");

        try {
            if(plusBubble.getAttribute("style").equals("display: block;")){
                buttonNew.click();
                WebUtilities.waitFor(1);
            }
        }
        catch (NoSuchElementException ex){

        }



        buttonNew.click();
        WebUtilities.waitFor(1);

        createDocButton.click();
        WebUtilities.waitFor(2);

        inputFile.clear();

        inputFile.sendKeys(docname + Keys.ENTER);

        WebUtilities.waitFor(2);

        System.out.println("=========the new doc close==========");

        Actions actions = new Actions(Driver.get());
        actions.sendKeys(Keys.ESCAPE).perform();

        WebUtilities.waitFor(2);

        return docname;
    }

}
