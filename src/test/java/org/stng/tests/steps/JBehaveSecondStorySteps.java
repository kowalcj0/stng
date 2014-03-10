package org.stng.tests.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import organized.chaos.LocalDriverManager;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveSecondStorySteps {

    @Given("a system is in a different state")
    public void theGameIsRunning() {
        System.out.println("I'm running step: a system is in a different state");
        LocalDriverManager.getDriver().get("http://google.pl");
    }

    @When("I do something differently")
    public void iToggleTheCellAt() {
        System.out.println("I'm running step: I do something differently");

    }

    @Then("system is in a different state")
    public void theGridShouldLookLike() {
        System.out.println("I'm running step: system is in a different state");
    }
}
