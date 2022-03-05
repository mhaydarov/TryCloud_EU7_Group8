package com.trycloud.step_definitions;

import com.trycloud.pages.OnlineStatusPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    @Then("user should see {string} as header")
    public void user_should_see_as_header(String setStatusMessageHeader) {
        WebUtilities.waitForVisibility(onlineStatusPage.setStatusMessageHeader,3);
        String actualSetStatusMessageHeader = onlineStatusPage.setStatusMessageHeader.getText();

        Assert.assertEquals("Verify that online status header is as expected",actualSetStatusMessageHeader,setStatusMessageHeader);
    }

    @Then("user should see {string} message in message input box")
    public void user_should_see_message_in_message_input_box(String expectedInputBoxMessage) {

        WebUtilities.waitForVisibility(onlineStatusPage.setStatusMessageInputBox,4);
        String inputBoxDeafultMessage = onlineStatusPage.setStatusMessageInputBox.getAttribute("placeholder");

        Assert.assertTrue("Verify the default message is as expected",inputBoxDeafultMessage.equals(expectedInputBoxMessage));

    }

    @Then("Status Message input box should be interactable and user should be able to insert {string} into it")
    public void status_Message_input_box_should_be_interactable_and_user_should_be_able_to_insert_into_it(String exampleMessage) {

        WebUtilities.waitForVisibility(onlineStatusPage.setStatusMessageInputBox,4);
        onlineStatusPage.setStatusMessageInputBox.sendKeys(exampleMessage);


        Assert.assertTrue("Verify that Status Message input box is interactable", onlineStatusPage.setStatusMessageInputBox.isEnabled());

    }

    @Then("user should see {string} and {string} near to it")
    public void user_should_see_and_near_to_it(String expectedMainMessage, String expectedSideMessage) {

        String fullMessage=expectedMainMessage+"-"+expectedSideMessage;
        switch (fullMessage) {
            case "In a meeting-an hour":
                WebUtilities.waitFor(5);
                String actualMainMessage = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][1]//span[2]")).getText();
                String actualSideMessage = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][1]//span[3]")).getText();

                Assert.assertTrue("Verify the main message of default status message is as expected", actualMainMessage.equals(expectedMainMessage));
                Assert.assertTrue("Verify that side message of default status message is as expected", actualSideMessage.equals(expectedSideMessage));

                break;
            case "Commuting-30 minutes":
                WebUtilities.waitFor(5);
                String actualMainMessage1 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][2]//span[2]")).getText();
                String actualSideMessage1 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][2]//span[3]")).getText();

                Assert.assertTrue("Verify the main message of default status message is as expected", actualMainMessage1.equals(expectedMainMessage));
                Assert.assertTrue("Verify that side message of default status message is as expected", actualSideMessage1.equals(expectedSideMessage));

                break;

            case "Working remotely-Today":

                WebUtilities.waitFor(5);
                String actualMainMessage2 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][3]//span[2]")).getText();
                String actualSideMessage2 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][3]//span[3]")).getText();

                Assert.assertTrue("Verify the main message of default status message is as expected", actualMainMessage2.equals(expectedMainMessage));
                Assert.assertTrue("Verify that side message of default status message is as expected", actualSideMessage2.equals(expectedSideMessage));

                break;

            case "Out sick-Today":
                WebUtilities.waitFor(5);
                String actualMainMessage3 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][4]//span[2]")).getText();
                String actualSideMessage3 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][4]//span[3]")).getText();

                Assert.assertTrue("Verify the main message of default status message is as expected", actualMainMessage3.equals(expectedMainMessage));
                Assert.assertTrue("Verify that side message of default status message is as expected", actualSideMessage3.equals(expectedSideMessage));

                break;

            case "Vacationing-Don't clear":

                WebUtilities.waitFor(5);
                String actualMainMessage4 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][5]//span[2]")).getText();
                String actualSideMessage4 = Driver.get().findElement(By.xpath("//div[@class='predefined-status'][5]//span[3]")).getText();

                Assert.assertTrue("Verify the main message of default status message is as expected", actualMainMessage4.equals(expectedMainMessage));
                Assert.assertTrue("Verify that side message of default status message is as expected", actualSideMessage4.equals(expectedSideMessage));

                break;




        }

    }

    @Then("user should see clear selection dropdown near the  {string} name")
    public void user_should_see_clear_selection_dropdown_near_the_name(String expectedClearStatusMessage) {

        WebUtilities.waitFor(5);
        String actualClearStatusMessage = onlineStatusPage.clearStatusMessage.getText();

        Assert.assertTrue("Verify that the message is as expected", actualClearStatusMessage.equals(expectedClearStatusMessage));
        Assert.assertTrue("Verify clear status message dropdown is displayed",onlineStatusPage.clearStatusDropDown.isDisplayed());




    }
    @When("user clicks on Clear status after dropdown")
    public void user_clicks_on_Clear_status_after_dropdown() {
        WebUtilities.waitForVisibility(onlineStatusPage.clearStatusDropDownButton,10);
        onlineStatusPage.clearStatusDropDownButton.click();


    }

    @Then("user should see following Clear status options")
    public void user_should_see_following_Clear_status_options(List<String> expectedClearStatusDropDownOptions) {

        String expectedOption="";
        String actualOptions="";

        for (String expectedClearStatusDropDownOption : expectedClearStatusDropDownOptions) {
            expectedOption+=expectedClearStatusDropDownOption;
        }

        for (int i = 0; i < onlineStatusPage.clearStatusDropDownOptions.size(); i++) {

            actualOptions+=onlineStatusPage.clearStatusDropDownOptions.get(i).getAttribute("title");

        }


        Assert.assertTrue("Verify that clear status options are as ecpected and in same order",actualOptions.equals(expectedOption));



    }

    @When("user clicks on {string} option")
    public void user_clicks_on_option(String option) {
        List<WebElement> clearStatusOption=onlineStatusPage.clearStatusDropDownOptions;
        for (WebElement webElement : clearStatusOption) {
            if(webElement.getAttribute("title").equals(option)){
                onlineStatusPage.clearStatusDropDownButton.click();
                webElement.click();

            }

        }

    }

    @Then("{string} should displayed on Clear status input box")
    public void should_displayed_on_Clear_status_input_box(String option) {

        WebUtilities.waitFor(3);
        System.out.println(onlineStatusPage.recentClearStatusOption.getText());
        try {
            Assert.assertTrue("Verify that selected option is displayed on input box", onlineStatusPage.recentClearStatusOption.getText().equals(option));
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }







}
