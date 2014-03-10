package org.stng.jbehave.steps;

import org.jbehave.core.annotations.*;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveFirstStorySteps {

    @Given("a system state")
    public void theGameIsRunning() {
        System.out.println("I'm running step: a system state");
        //LocalDriverManager.getDriver().get("http://google.pl");
    }

    @When("I do something")
    public void iToggleTheCellAt() {
        System.out.println("I'm running step: I do something");

    }

    @Then("system is in a normal state")
    public void theGridShouldLookLike() {
        System.out.println("I'm running step: system is in a normal state");
    }
}
