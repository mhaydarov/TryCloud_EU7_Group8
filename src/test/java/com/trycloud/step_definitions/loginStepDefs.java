package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user enters {string} into username input box")
    public void user_enters_into_username_input_box(String username) {
        username = ConfigurationReader.get("username");
        loginPage.usernameInputBox.sendKeys(username);

    }

    @When("user enters {string} into password input box")
    public void user_enters_into_password_input_box(String password) {
        password=ConfigurationReader.get("password");
       loginPage.passwordInputBox.sendKeys(password);
    }

    @Then("user should be log in dashboard")
    public void user_should_be_log_in_dashboard() {
        loginPage.loginButton.click();
        String currentUrl=Driver.get().getCurrentUrl();

        Assert.assertTrue("Verify that user is on dahsboard page",currentUrl.contains("dashboard"));


    }
}
