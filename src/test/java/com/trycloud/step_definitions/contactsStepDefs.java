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



    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        WebUtilities.waitFor(2);
        String currentUrl= Driver.get().getCurrentUrl();
        Assert.assertTrue("Verify that user is on dashboard page",currentUrl.contains("dashboard"));

    }

    @Given("user clicks on the Contacts module  on Dashboard page")
    public void user_clicks_on_the_Contacts_module_on_Dashboard_page() {
        DashboardPage dashboardPage=new DashboardPage();

        WebUtilities.waitForClickablility(dashboardPage.contactsModule,3);

        dashboardPage.contactsModule.click();

    }

    @Then("new page opens with title Contacts")
    public void new_page_opens_with_title_Contacts() {

        String actualTitle=Driver.get().getTitle();

        String expectedTitle="Contacts - Trycloud QA";

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user clicks on the New contact button")
    public void user_clicks_on_the_New_contact_button() {
        new ContactsPage().newContactButton.click();
        WebUtilities.waitFor(3);

    }

    @Then("contact details section opens on the right")
    public void contact_details_section_opens_on_the_right() {
        ContactsPage contactsPage=new ContactsPage();
        contactsPage.contactFullName.click();

       String actualResult= contactsPage.contactFullName.getText();

       WebUtilities.waitFor(3);
        String expectedResult="New contact";

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Then("user enters the contact details")
    public void user_enters_the_contact_details() {

        new ContactsPage().contactFullName.clear();
        WebUtilities.waitFor(3);
        new ContactsPage().contactFullName.sendKeys("Aysoltan");

        new ContactsPage().emailBox.sendKeys("nana@example.com");
    }



    @Then("user creates a new contact")
    public void user_creates_a_new_contact() {

        ContactsPage contactsPage=new ContactsPage();
        contactsPage.searchButton.click();
        contactsPage.searchBox.sendKeys("Aysoltan");

        WebUtilities.waitFor(3);

       String actualContact= contactsPage.newContact.getText();
       String expectedContact="Aysoltan";
       Assert.assertEquals(expectedContact,actualContact);




    }
    @When("user clicks on a contact")
    public void user_clicks_on_a_contact() {

    }
    @When("user clicks on Delete option")
    public void user_clicks_on_Delete_option() {

        new ContactsPage().actionMenu.click();
    }
    @Then("user deletes the selected contact")
    public void user_deletes_the_selected_contact() {


    }

    @Then("user edits the selected contact")
    public void user_edits_the_selected_contact() {

    }

    }

