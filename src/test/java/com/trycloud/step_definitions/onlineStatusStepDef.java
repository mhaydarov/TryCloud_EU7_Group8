package com.trycloud.step_definitions;

import com.trycloud.pages.OnlineStatusPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @When("user clicks on recent online status button")
    public void user_clicks_on_recent_online_status_button() {
        onlineStatusPage.setStatusButton.click();
    }

    @Then("user shold see {string} as header")
    public void user_shold_see_as_header(String onlineStatusHeader) {

        WebUtilities.waitForVisibility(onlineStatusPage.onlineStatusHeader,3);
        String actualOnlineStatusHeader = onlineStatusPage.onlineStatusHeader.getText();

        Assert.assertEquals("Verify that online status header is as expecte",actualOnlineStatusHeader,onlineStatusHeader);


    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String statusKeyword) {
        WebUtilities.waitFor(3);
        WebElement onlineStatus= Driver.get().findElement(By.xpath("//label[@class='user-status-online-select__label icon-user-status-"+statusKeyword+"']"));
        WebUtilities.waitForVisibility(onlineStatus,3);

        Assert.assertTrue("Verify that online status options are visible",onlineStatus.isDisplayed());

    }



}
