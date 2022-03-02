package com.trycloud.step_definitions;


import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefs {

    LoginPage loginPage=new LoginPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user login with valid credentials")
    public void user_login_with_valid_credentials() {
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginPage.logIn(username,password);
    }

    @Then("user should be log in dashboard")
    public void user_should_be_log_in_dashboard() {


        String currentUrl=Driver.get().getCurrentUrl();

        Assert.assertTrue("Verify that user is on dahsboard page",currentUrl.contains("dashboard"));


    }

    @When("user login with invalid credentials")
    public void user_login_with_invalid_credentials() {
        String invalidUsername=ConfigurationReader.get("wrong_username");
        String invalidPassword=ConfigurationReader.get("wrong_password");
        loginPage.logIn(invalidUsername,invalidPassword);
    }

    @Then("user should see {string} warning message")
    public void user_should_see_warning_message(String warningMessage) {

        String actualWarningMessage = loginPage.warningMessageForInvalidCr.getText();

        Assert.assertTrue("Verify that user sees warning message for login with invalid credentials",actualWarningMessage.equals(warningMessage));
    }

    @When("user insert {string} as username and valid password")
    public void user_insert_as_username_and_valid_password(String insensitiveUserName) {

        loginPage.logIn(insensitiveUserName,ConfigurationReader.get("password"));
        Assert.assertTrue("Verify that wrong username warning message is displayed",loginPage.warningMessageForInvalidCr.isDisplayed());

    }
}
