package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.util.List;
import java.util.Map;

public class fileUploadStepDefs {

    FilesPage filesPage = new FilesPage();


    //Storage size checks
    String [] originalStorageSize = filesPage.quota.getText().split(" ");
    int originalStorageUsed = Integer.parseInt(originalStorageSize[0]);

    //String storageUsedMeasure = originalStorageSize[1];


    //files to upload
    File uploadedFile;



    @When("User clicks + button and uploads {string}")
    public void user_clicks_button_and_uploads(String file) {


        WebUtilities.waitFor(2);

        //just for demo
        filesPage.buttonNew.click();
        WebUtilities.waitFor(2);
        filesPage.buttonNew.click();


        //making browser show the hidden box
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("document.getElementsByClassName('hiddenuploadfield')[0].style.display = \"block\"");
        WebUtilities.waitFor(2);

        //uploading file
        filesPage.input.sendKeys(file);

        System.out.println("==========File uploading==========");

        WebUtilities.waitFor(2);

        uploadedFile = new File(file);

    }

    @Then("the file should appear in that folder after being uploaded")
    public void the_file_should_appear_in_that_folder_after_being_uploaded() {

        List<WebElement> allFiles = filesPage.dataFile;

        boolean found = false;

        for (WebElement file : allFiles) {

            if(file.getAttribute("data-file").equals(uploadedFile.getName())){
                found = true;
                break;
            }

        }
        
        Assert.assertTrue("Verify file is uploaded",found);

        WebUtilities.waitFor(2);

        System.out.println("==========File uploaded!==========");

        WebUtilities.waitFor(2);

    }

    @Then("the storage size should change accordingly")
    public void the_storage_size_should_change_accordingly() {

        Driver.get().navigate().refresh();

        WebUtilities.waitFor(2);

        System.out.println("=========Storage==========");
        System.out.println("originalStorageUsed = " + originalStorageUsed);

        String [] newStorageSize = filesPage.quota.getText().split(" ");
        int newStorageUsed = Integer.parseInt(newStorageSize[0]);

        WebUtilities.waitFor(2);

        System.out.println("uploadedFile.length()/1024 = " + uploadedFile.length() / 1024);
        System.out.println("newStorageSize = " + newStorageUsed);


        int uploadedFileSizeKB = (int) (uploadedFile.length()/1024);

        Assert.assertEquals(uploadedFileSizeKB,newStorageUsed-originalStorageUsed);

        String xpathMenu = "//*[@data-file='"+uploadedFile.getName()+"']//*[@class='icon icon-more']";
        String xpathDelete = "//*[@data-file='"+uploadedFile.getName()+"']//*[@class=' action-delete-container']";

        Driver.get().findElement(By.xpath(xpathMenu)).click();

        WebUtilities.waitFor(2);

        Driver.get().findElement(By.xpath(xpathDelete)).click();


        WebUtilities.waitFor(2);


    }

    @When("User clicks + button and creates a folder and navigates into it")
    public void user_clicks_button_and_creates_a_folder_and_navigates_into_it() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new folder==========");

        filesPage.buttonNew.click();
        filesPage.createFolderButton.click();
        String newFolderName = "Testing Folder";
        filesPage.inputFolder.sendKeys(newFolderName+ Keys.ENTER);

        WebUtilities.waitFor(2);

        System.out.println("=========Going into the new folder created ==========");

        Driver.get().findElement(By.xpath("//*[@data-file='"+newFolderName+"']")).click();

        WebUtilities.waitFor(2);


    }

    @When("User clicks + button and creates a doc and navigates into it")
    public void user_clicks_button_and_creates_a_doc_and_navigates_into_it() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc file ==========");

        filesPage.createDocButton.click();


    }

}
