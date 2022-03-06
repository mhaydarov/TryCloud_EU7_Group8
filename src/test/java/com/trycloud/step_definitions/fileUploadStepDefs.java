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

    //names
    String docName;


    //folder creations
    String folder1, folder2;

    //doc creations
    String document1, document2;

    //CLEANING UP!!!
    @Given("the storage is empty")
    public void the_storage_is_empty() {

        WebUtilities.waitFor(2);
//        filesPage.selectAll.click();

        if(!filesPage.selectTestOnly.isEmpty() || !filesPage.selectNewTextDocOnly.isEmpty()){
            for(WebElement el : filesPage.selectTestOnly){
                el.click();
            }

            for(WebElement el : filesPage.selectNewTextDocOnly){
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

    @When("user clicks + button and tries to create {string} and {string} folders")
    public void user_clicks_button_and_tries_to_create_and_folders(String folder1, String folder2) {

        this.folder1 = folder1;
        this.folder2 = folder2;

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new folder==========");

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createFolderButton.click();
        WebUtilities.waitFor(1);

        filesPage.inputFolder.sendKeys(folder1 + Keys.ENTER);

        WebUtilities.waitFor(2);

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createFolderButton.click();
        WebUtilities.waitFor(1);

        filesPage.inputFolder.sendKeys(folder2 + Keys.ENTER);

        WebUtilities.waitFor(2);

    }

    @When("user clicks + button and tries to create folder with empty name")
    public void user_clicks_button_and_tries_to_create_folder_with_empty_name() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new folder with empty name==========");

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createFolderButton.click();
        WebUtilities.waitFor(1);

        filesPage.inputFolder.clear();
        filesPage.inputFolder.sendKeys("" + Keys.ENTER);

        WebUtilities.waitFor(2);

    }

    @Then("user should see both folders on the screen")
    public void user_should_see_both_folders_on_the_screen() {

        //expected folders
        String expectedFolder1 = folder1;
        System.out.println("expectedFolder1 = " + expectedFolder1);
        String expectedFolder2 = folder2;
        System.out.println("expectedFolder2 = " + expectedFolder2);


        //Actual folders

        String actualFolder1 = Driver.get().findElement(By.xpath("//*[@data-file='"+folder1+"']")).getAttribute("data-file");
        System.out.println("actualFolder1 = " + actualFolder1);

        String actualFolder2 = Driver.get().findElement(By.xpath("//*[@data-file='"+folder2+"']")).getAttribute("data-file");
        System.out.println("actualFolder2 = " + actualFolder2);

        Assert.assertEquals(folder1, actualFolder1);
        Assert.assertEquals(folder2, actualFolder2);

    }



    @Then("user should should see {string} warning message")
    public void user_should_should_see_warning_message(String message) {

        WebUtilities.waitFor(2);

        String expectedMessage = message;

        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("filesPage.folderDuplicateMessage = " + filesPage.folderDuplicateMessage.getText());

        Assert.assertEquals(message,filesPage.folderDuplicateMessage.getText());



    }

    @When("user clicks + button and creates a default doc file")
    public void user_clicks_button_and_creates_a_default_doc_file() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc==========");

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createDocButton.click();
        WebUtilities.waitFor(1);

        filesPage.createDocSubmitButton.click();

        WebUtilities.waitFor(2);

        System.out.println("=========the new doc opens automatically==========");


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

        docName = "test123_" + filesPage.generateName(leftLimit,rightLimit,targetStringLength-8);

        filesPage.inputFile.sendKeys(docName+ Keys.ENTER);

        WebUtilities.waitFor(2);

        System.out.println("=========the new doc opens automatically==========");


    }

    @When("User clicks + button and creates a doc and navigates into it")
    public void user_clicks_button_and_creates_a_doc_and_navigates_into_it() {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new doc file ==========");

        filesPage.createDocButton.click();

    }

    @When("user clicks + button and creates a default doc file \\({string})")
    public void user_clicks_button_and_creates_a_default_doc_file(String defaultDoc) {

        WebUtilities.waitFor(2);

        System.out.println("=========Creating new default doc==========");

        docName = defaultDoc;

        filesPage.buttonNew.click();
        WebUtilities.waitFor(1);
        filesPage.createDocButton.click();
        WebUtilities.waitFor(1);

        System.out.println("defaultDoc = " + defaultDoc);

        System.out.println("filesPage.inputFile.getText() = " + filesPage.inputFile.getText());

        String actualDoc = filesPage.inputFile.getAttribute("value");
        System.out.println("actualDoc = " + actualDoc);

        Assert.assertEquals(defaultDoc, actualDoc);

        filesPage.createDocSubmitButton.click();

        WebUtilities.waitFor(2);

        System.out.println("=========the new default doc opens automatically==========");


    }

    @Then("user should should see {string} warning message and the file should not upload")
    public void user_should_should_see_warning_message_and_the_file_should_not_upload(String message) {

        String expectedWarning = message;

        // implement locator for actualWarning
        String actualWarning = "";

        Assert.assertEquals("Verify warning message",expectedWarning,actualWarning);

        WebUtilities.waitFor(2);

    }


    @Then("user should see the new doc file opened")
    public void user_should_see_the_new_doc_file_opened() {

        //Get expected info
        String expectedFileName = docName.split("\\.")[0];
        String expectedFileType = docName.split("\\.")[1];

        System.out.println("expectedFileName = " + expectedFileName);
        System.out.println("expectedFileType = " + expectedFileType);

        //Get actual info
        String [] actualFullDoc = filesPage.docTitle.getText().split("\\.");
        String actualFileName = actualFullDoc[0];
        String actualFileType = actualFullDoc[1];

        System.out.println("actualFileName = " + actualFileName);
        System.out.println("actualFileType = " + actualFileType);

        Assert.assertEquals(expectedFileName,actualFileName);
        Assert.assertEquals(expectedFileType,actualFileType);

    }


    @When("user clicks + button and tries to create {string} and {string} doc files")
    public void user_clicks_button_and_tries_to_create_and_doc_files(String doc1, String doc2) {

        document1 = filesPage.createDoc(doc1);

        document2 = filesPage.createDoc(doc2);

    }

    @Then("user should see both doc files on the screen")
    public void user_should_see_both_doc_files_on_the_screen() {


        //expected docs
        String expectedDocument1 = document1;
        System.out.println("expectedDocument1 = " + expectedDocument1);
        String expectedDocument2 = document2;
        System.out.println("expectedDocument2 = " + expectedDocument2);

        //Actual docs
        String actualDocument1 = Driver.get().findElement(By.xpath("//*[@data-file='"+document1+"']")).getAttribute("data-file");
        System.out.println("actualDocument1 = " + actualDocument1);

        String actualDocument2 = Driver.get().findElement(By.xpath("//*[@data-file='"+document2+"']")).getAttribute("data-file");
        System.out.println("actualDocument2 = " + actualDocument2);

        Assert.assertEquals(document1, actualDocument1);
        Assert.assertEquals(document2, actualDocument2);

    }

    @When("user clicks + button and tries to create doc file with empty name")
    public void user_clicks_button_and_tries_to_create_doc_file_with_empty_name() {

        filesPage.createDoc("");

    }



}
