package org.stng.tests.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveSecondStorySteps {

    @Given("a system is in a different state")
    public void theGameIsRunning() {
        System.out.println("a system is in a different state");
    }

    @When("I do something differently")
    public void iToggleTheCellAt() {
        System.out.println("I do something differently");

    }

    @Then("system is in a different state")
    public void theGridShouldLookLike() {
        System.out.println("system is in a different state");
    }
}
