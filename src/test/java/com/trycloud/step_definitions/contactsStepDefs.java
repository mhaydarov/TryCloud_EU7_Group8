package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class contactsStepDefs extends BasePage {

    //@Given("user login with valid credentials")
   // public void user_login_with_valid_credentials() {
       //  Driver.get().get(ConfigurationReader.get("url"));


//        String username= ConfigurationReader.get("username");
//        String password=ConfigurationReader.get("password");
//        LoginPage loginPage=new LoginPage();
//        loginPage.logIn(username,password);
//    }

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        WebUtilities.waitFor(2);
        String currentUrl= Driver.get().getCurrentUrl();
        Assert.assertTrue("Verify that user is on dashboard page",currentUrl.contains("dashboard"));

    }

    @When("user clicks on the Contacts module")
    public void user_clicks_on_the_Contacts_module() {

        DashboardPage dashboardPage=new DashboardPage();

        WebUtilities.waitForClickablility(dashboardPage.contactsModule,3);

        dashboardPage.contactsModule.click();
        ContactsPage contactsPage=new ContactsPage();
        WebUtilities.waitFor(2);

        String actual=contactsPage.newContactButton.getText();
        String expected="New contact";
        Assert.assertEquals(actual,expected);


    }
    @When("user clicks on the New contact option")
    public void user_clicks_on_the_New_contact_option() {
    }
    @Then("user creates a new contact")
    public void user_creates_a_new_contact() {


    }
    @When("user clicks on a contact")
    public void user_clicks_on_a_contact() {

    }
    @When("user clicks on Delete option")
    public void user_clicks_on_Delete_option() {

    }
    @Then("user deletes the selected contact")
    public void user_deletes_the_selected_contact() {

    }

    @Then("user edits the selected contact")
    public void user_edits_the_selected_contact() {

    }

    }

