package com.trycloud.step_definitions;

import com.trycloud.pages.EditNewFilesPages;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.*;

public class EditNeFileStepDefs {

    LoginPage loginPage=new LoginPage();
    EditNewFilesPages editNewFilesPages= new EditNewFilesPages();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginPage.logIn(username,password);
    }

    @When("user clicks the folder button right top of the dashboard page")
    public void user_clicks_the_folder_button_right_top_of_the_dashboard_page() {
        WebUtilities.waitFor(2);
        editNewFilesPages.EditPageBtn.click();

    }

    @When("user clicks the plus sign at the all files page")
    public void user_clicks_the_plus_sign_at_the_all_files_page() {
        WebUtilities.waitFor(2);
        editNewFilesPages.PlusBtn.click();
    }


    @When("select the upload file button")
    public void select_the_upload_file_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the upload successfully achieved")
    public void verify_the_upload_successfully_achieved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks the three dots of the selected folder or file")
    public void user_clicks_the_three_dots_of_the_selected_folder_or_file() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("select the {string} option")
    public void select_the_option(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify copying process done successfully")
    public void verify_copying_process_done_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the that the file deleted")
    public void verify_the_that_the_file_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
