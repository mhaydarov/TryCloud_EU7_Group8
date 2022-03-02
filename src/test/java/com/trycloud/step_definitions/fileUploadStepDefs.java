package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

public class fileUploadStepDefs {

    FilesPage filesPage = new FilesPage();

    String [] originalStorageSize = filesPage.quota.getText().split(" ");
    String storageUsed = originalStorageSize[0];
    String storageUsedMeasure = originalStorageSize[1];

    @When("User clicks + button and uploads file")
    public void user_clicks_button_and_uploads_file() {

        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("document.getElementsByClassName('hiddenuploadfield')[0].style.display = \"block\"");
        WebUtilities.waitFor(2);

        filesPage.input.sendKeys("C:\\Users\\Merdan\\Desktop\\Test\\file1.txt");

        WebUtilities.waitFor(5);


    }

    @Then("the file should appear in that folder after being uploaded")
    public void the_file_should_appear_in_that_folder_after_being_uploaded() {


    }

    @Then("the number of uploaded files should increase accordingly")
    public void the_number_of_uploaded_files_should_increase_accordingly() {


    }

}
