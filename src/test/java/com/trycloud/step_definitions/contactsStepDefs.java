package com.trycloud.step_definitions;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class contactsStepDefs {
    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        WebUtilities.waitFor(2);
        String currentUrl= Driver.get().getCurrentUrl();

        Assert.assertTrue("Verify that user is on dashboard page",currentUrl.contains("dashboard"));

    }

    @When("user clicks on the Contacts module")
    public void user_clicks_on_the_Contacts_module() {

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

