package com.trycloud.step_definitions;

import com.trycloud.pages.CalendarPageAsh;
import com.trycloud.pages.DashboardPage;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarAshStepDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("the user click on calenderMenu")
    public void theUserClickOnCalenderMenu() {
        dashboardPage.navigateAppMenu("calendar");


        //selenium code
        System.out.println("the user clicked on to Calender");
    }


    @Then("the title should be {string}")
    public void theTitleShouldBe(String expectedTitle) {
        WebUtilities.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        System.out.println("Expected and Actual title are matching");
    }

    CalendarPageAsh calendarPageAsh = new CalendarPageAsh();

    @When("the user click on to Hamburger menu")
    public void the_user_click_on_to_Hamburger_menu() {
        WebUtilities.waitFor(3);
        calendarPageAsh.hamburgerButton.click();
    }


    @Then("User should see & click following options")
    public void user_should_see_click_following_options(List<String> expected) {

        List<String> actual = WebUtilities.getElementsText(calendarPageAsh.hamburgerOption);

        for (WebElement eachElement : calendarPageAsh.hamburgerOption) {

            WebUtilities.waitFor(3);

            eachElement.click();
        }
            Assert.assertEquals(expected,actual);
        }

//            Actions actions = new Actions(Driver.getDriver());
//            actions.moveToElement(eachElement).perform();
//            actions.click(eachElement).perform();


    }


