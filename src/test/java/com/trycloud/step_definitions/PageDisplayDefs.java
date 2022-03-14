package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.PageDisplayPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class PageDisplayDefs {
    PageDisplayPage pdp= new PageDisplayPage();
    LoginPage loginPage=new LoginPage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginPage.logIn(username,password);

        //Driver.get().get(ConfigurationReader.get("url2"));
    }

    @When("User click the name on the right top")
    public void user_click_the_name_on_the_right_top() {
        //pdp.getSettingsPage();
       // Assert.assertEquals(Driver.get().getTitle(), "Settings");

        pdp.NameIkon.click();
    }





    @When("click on the Settings button")
    public void click_on_the_Settings_button() {
        WebUtilities.waitFor(2);
        pdp.SettingBtn.click();
    }

    @Then("User should see the tıtle as {string}")
    public void user_should_see_the_title_as(String expectedTitle) {
        expectedTitle="Settings - Trycloud QA";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Verify",expectedTitle,actualTitle);

    }

    @When("User enter {string} to the full name box")
    public void user_enter_to_the_full_name_box( String name2) {
        pdp.getSettingsPage();
        pdp.setNameBox("Dakota");
        WebUtilities.waitFor(4);
       String  actualresult= pdp.NameBox.getAttribute("value");
       WebUtilities.waitFor(2);
       //Assert.assertEquals("Verify","Dakota",actualresult);



    }

    @When("User hit the enter key")
    public void user_hit_the_enter_key() {
       pdp.NameBox.sendKeys(Keys.ENTER);
    }

    @When("User enter {string} to the email box")
    public void user_enter_to_the_email_box(String email) {
        email="dakato@yahoo.com";
        pdp.EmailBox.click();
        WebUtilities.waitFor(1);
        pdp.EmailBox.clear();
        WebUtilities.waitFor(1);
        pdp.EmailBox.sendKeys(email);
    }

    @Then("User should see this new data displayed on the boxes")
    public void user_should_see_this_new_data_displayed_on_the_boxes() {
        String  actualresult=pdp.NameBox.getAttribute("value");
        Assert.assertEquals("Verify","Dakota",actualresult);
        String actualresult2=pdp.EmailBox.getAttribute("value");
        Assert.assertEquals("Verify","dakato@yahoo.com",actualresult2);
    }

    @When("User enters wrong data {string} to the phone box")
    public void user_enters_wrong_data_to_the_phone_box(String phoneData) {
        pdp.getSettingsPage();
   phoneData= "okul oku!";
   WebUtilities.waitFor(2);
   pdp.PhoneBox.click();
   WebUtilities.waitFor(1);
   pdp.PhoneBox.clear();
   WebUtilities.waitFor(2);
   pdp.PhoneBox.sendKeys(phoneData,Keys.ENTER);

    }

    @Then("User should not see this wrong data accepted")
    public void user_should_not_see_this_wrong_data_accepted() {
       String actualresult=pdp.PhoneBox.getAttribute("value");
       String expectedresult= "1234 123";
        Assert.assertTrue("Verify", expectedresult.equals(actualresult));
    }


}