package org.stng.tests.steps;

import org.jbehave.core.annotations.*;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveFirstStorySteps {

    @Given("a system state")
    public void theGameIsRunning() {
        System.out.println("a system state");
    }

    @When("I do something")
    public void iToggleTheCellAt() {
        System.out.println("I do something");

    }

    @Then("system is in a normal state")
    public void theGridShouldLookLike() {
        System.out.println("system is in a normal state");
    }
}
