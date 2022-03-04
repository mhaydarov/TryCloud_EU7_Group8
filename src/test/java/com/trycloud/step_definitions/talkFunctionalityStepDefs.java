package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.TalkModulePage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class talkFunctionalityStepDefs {



    TalkModulePage talkModulePage = new TalkModulePage();

    @When("User Clicks on {string} button on the upper side of the page")
    public void user_Clicks_on_button_on_the_upper_side_of_the_page(String string) {
        WebUtilities.waitFor(3);
        talkModulePage.talkModule.click();
    }

    @When("User Click on + icon from the up left corner next toSearch converations or users input box")
    public void user_Click_on_icon_from_the_up_left_corner_next_toSearch_converations_or_users_input_box() {
    talkModulePage.createConv.click();

    }

    @When("User Enter conversation name on the pop up box")
    public void user_Enter_conversation_name_on_the_pop_up_box() {
        talkModulePage.convName.sendKeys("New Conversation");
        talkModulePage.addParticipants.click();

    }

    @When("User Selects user names")
    public void user_Selects_user_names() {
        WebUtilities.waitFor(3);

       talkModulePage.Employee1.click();
       talkModulePage.Employee100.click();
//       talkModulePage.Employee103.click();
//       talkModulePage.circle1.click();

    }


    @Then("User Click on {string} conversation button")
    public void user_Click_on_conversation_button(String string) {
        WebUtilities.waitFor(3);
        talkModulePage.createConverastion.click();
    }

    @Then("User Verify name the conversation is  displayed first on the conversations list")
    public void user_Verify_name_the_conversation_is_displayed_first_on_the_conversations_list() {
        String convnameActual = talkModulePage.convBOX.getText();
        System.out.println(convnameActual);
        String convnameExp = "New Conversation";
        Assert.assertEquals("VERIFY IF CONVERSTION IS ON THE LIST",convnameExp,convnameActual);
    }


}
