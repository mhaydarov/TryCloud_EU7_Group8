package com.trycloud.step_definitions;

import com.trycloud.pages.OnlineStatusPage;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class onlineStatusStepDef {

    OnlineStatusPage onlineStatusPage=new OnlineStatusPage();

    @When("user clicks on profile Icon at the right corner of Dashboard page")
    public void user_clicks_on_profile_Icon_at_the_right_corner_of_Dashboard_page() {
        onlineStatusPage.clickOnDashBoard(onlineStatusPage.profileButton);
        WebUtilities.waitFor(3);
        onlineStatusPage.clickOnDashBoard(onlineStatusPage.setStatusButton);
    }

    @Then("user should see recent status is displayed under profile dropdown")
    public void user_should_see_recent_status_is_displayed_under_profile_dropdown() {

        Assert.assertTrue("Verify that online status is visible under profile dorpdown", onlineStatusPage.setStatusButton.isDisplayed());

    }
}
