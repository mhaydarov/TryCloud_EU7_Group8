package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
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
import java.util.Random;

public class fileUploadStepDefs {

    FilesPage filesPage = new FilesPage();

    //files to upload
    File uploadedFile;
    int originalStorageUsed;
    int newStorageUsed;

    //naming limits
    int leftLimit = 65; // numbers
    int rightLimit = 90; // letter 'z'
    int targetStringLength;


    //CLEANING UP!!!
    @Given("the storage is empty")
    public void the_storage_is_empty() {

        WebUtilities.waitFor(2);
//        filesPage.selectAll.click();

        if(!filesPage.selectTestOnly.isEmpty()){
            for(WebElement el : filesPage.selectTestOnly){
                el.click();
            }

            WebUtilities.waitFor(3);
            filesPage.actionsButton.click();
            WebUtilities.waitFor(2);
            filesPage.actionsDeleteButton.click();
            WebUtilities.waitFor(2);
            Driver.get().navigate().refresh();
            WebUtilities.waitFor(1);
        }

    }


    //user uploads a file
    @When("user clicks + button and uploads a file")
    public void user_clicks_button_and_uploads_a_file(String file) {

        WebUtilities.waitFor(2);

        originalStorageUsed = filesPage.checkStorage();

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

        newStorageUsed = filesPage.checkStorage();

    }

    @When("user clicks + button and uploads files")
    public void user_clicks_button_and_uploads_files(List<String> files) {

        String pathAll = "";

        for (int i = 0; i<files.size(); i++){
            if(i == files.size()-1){
                pathAll = pathAll+files.get(i);
            } else {
                pathAll = pathAll + files.get(i)+ "\n";
            }
        }


        WebUtilities.waitFor(2);

        originalStorageUsed = filesPage.checkStorage();

        //just for demo
        filesPage.buttonNew.click();
        WebUtilities.waitFor(2);
        filesPage.buttonNew.click();

        //making browser show the hidden box
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("document.getElementsByClassName('hiddenuploadfield')[0].style.display = \"block\"");
        WebUtilities.waitFor(2);

        //uploading file
        filesPage.input.sendKeys(pathAll);

        System.out.println("==========File uploading==========");

        WebUtilities.waitFor(2);

        uploadedFile = new File(pathAll);

        newStorageUsed = filesPage.checkStorage();

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

        System.out.println("==========File uploaded!==========");


    }

    @Then("the storage size should change accordingly")
    public void the_storage_size_should_change_accordingly() {

        WebUtilities.waitFor(2);

        int uploadedFileSizeKB = (int) (uploadedFile.length()/1024);

        System.out.println("originalStorageUsed = " + originalStorageUsed);
        System.out.println("uploadedFileSizeKB = " + uploadedFileSizeKB);
        System.out.println("newStorageUsed = " + newStorageUsed);

        if(originalStorageUsed==newStorageUsed){
            Assert.assertEquals(uploadedFileSizeKB,newStorageUsed);
        }else{
            Assert.assertEquals(uploadedFileSizeKB,newStorageUsed-originalStorageUsed);
        }



    }



    @When("user clicks + button and creates a folder and opens it")
    public void user_clicks_button_and_creates_a_folder_and_opens_it(Map<String, Integer> folderProperties) {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new folder==========");

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createFolderButton.click();
        WebUtilities.waitFor(1);

        targetStringLength = folderProperties.get("char limit");

        String folderName = "test123_" + filesPage.generateName(leftLimit,rightLimit,targetStringLength-8);

        filesPage.inputFolder.sendKeys(folderName+ Keys.ENTER);

        WebUtilities.waitFor(2);

        System.out.println("=========Going into the new folder created ==========");

        Driver.get().findElement(By.xpath("//*[@data-file='"+folderName+"']")).click();

        WebUtilities.waitFor(2);

    }

    @When("user clicks + button and creates a doc file")
    public void user_clicks_button_and_creates_a_doc_file(Map<String, Integer> fileProperties) {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc==========");

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createDocButton.click();
        WebUtilities.waitFor(1);

        targetStringLength = fileProperties.get("char limit");

        String fileName = "test123_" + filesPage.generateName(leftLimit,rightLimit,targetStringLength-8);

        filesPage.inputFolder.sendKeys(fileName+ Keys.ENTER);

        WebUtilities.waitFor(2);

        System.out.println("=========Going into the new folder created ==========");

        Driver.get().findElement(By.xpath("//*[@data-file='"+fileName+"']")).click();

        WebUtilities.waitFor(2);

    }

    @When("User clicks + button and creates a doc and navigates into it")
    public void user_clicks_button_and_creates_a_doc_and_navigates_into_it() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc file ==========");

        filesPage.createDocButton.click();

    }

    @Then("user should should see {string} warning message and the file should not upload")
    public void user_should_should_see_warning_message_and_the_file_should_not_upload(String message) {

        String expectedWarning = message;

        // implemeent locator for actualWarning
        String actualWarning = "";

        Assert.assertEquals("Verify warning message",expectedWarning,actualWarning);

        WebUtilities.waitFor(2);

    }

}
