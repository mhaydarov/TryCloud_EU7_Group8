package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.util.List;

public class fileUploadStepDefs {

    FilesPage filesPage = new FilesPage();

    String [] originalStorageSize = filesPage.quota.getText().split(" ");
    int storageUsed = Integer.parseInt(originalStorageSize[0]);
    String storageUsedMeasure = originalStorageSize[1];

    @When("User clicks + button and uploads file")
    public void user_clicks_button_and_uploads_file() {

        String filePath = "C:\\Users\\Merdan\\Desktop\\Test\\file1.txt";

        //making browser show the hidden box
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("document.getElementsByClassName('hiddenuploadfield')[0].style.display = \"block\"");
        WebUtilities.waitFor(2);

        //uploading file
        filesPage.input.sendKeys(filePath);

        WebUtilities.waitFor(2);

        File file = new File(filePath);
        int uploadedFileSizeKB = (int) (file.length()/1024);
        System.out.println("uploadedFileSizeKB = " + uploadedFileSizeKB);

        System.out.println("file.getName() = " + file.getName());

    }

    @Then("the file should appear in that folder after being uploaded")
    public void the_file_should_appear_in_that_folder_after_being_uploaded() {

        List<WebElement> allFileNames = filesPage.fileNames;
        for (WebElement cells : allFileNames) {
            System.out.println(cells.getText());
        }

        Assert.assertTrue(allFileNames);

    }

    @Then("the number of uploaded files should increase accordingly")
    public void the_number_of_uploaded_files_should_increase_accordingly() {


    }

}
