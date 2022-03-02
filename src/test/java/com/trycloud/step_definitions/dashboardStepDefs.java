package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import io.cucumber.java.en.When;

public class dashboardStepDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("User navigates to {string} module")
    public void user_navigates_to_module(String module) {

        dashboardPage.navigateAppMenu(module);

    }

}
