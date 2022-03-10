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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class contactsStepDefs extends BasePage {
ContactsPage contactsPage =new ContactsPage();

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
       contactsPage.dashboardPageAssert();
    }

    @Given("user clicks on the Contacts module  on Dashboard page")
    public void user_clicks_on_the_Contacts_module_on_Dashboard_page() {
      contactsPage.contactsModuleClick();

    }

    @Then("new page opens with title Contacts")
    public void new_page_opens_with_title_Contacts() {

        contactsPage.contactsTitleAssert();
    }

    @When("user clicks on the New contact button")
    public void user_clicks_on_the_New_contact_button() {
       contactsPage.newContactButtonClick();

    }

    @Then("contact details section opens on the right")
    public void contact_details_section_opens_on_the_right() {

       contactsPage.contactDetailsOpen();

    }

    @Then("user enters the contact details")
    public void user_enters_the_contact_details() {

       contactsPage.enterContactDetails();
    }


    @Then("user creates a new contact")
    public void user_creates_a_new_contact() {

       contactsPage.assertNewContactCreated();

    }


    @When("user clicks on a random contact")
    public void user_clicks_on_a_random_contact() {


        contactsPage.selectContact("Aysoltan");

    }

    @Then("user sees selected contacts details")
    public void user_sees_selected_contacts_details() {

        contactsPage.selectedContactDetails();

    }


    @Then("user clicks on three dots on the right")
    public void user_clicks_on_three_dots_on_the_right() {
       contactsPage.clickThreeDots();
    }

    @Then("user clicks on Delete and selected contact disappears")
    public void user_clicks_on_Delete_and_selected_contact_disappears() {
        contactsPage.clickDeleteButton();
    }


}

