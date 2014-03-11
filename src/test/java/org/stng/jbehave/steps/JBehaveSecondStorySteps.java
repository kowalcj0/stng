package org.stng.jbehave.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import organized.chaos.LocalDriverManager;


public class JBehaveSecondStorySteps {

    static Logger log = Logger.getLogger(JBehaveSecondStorySteps.class);

    @Given("a system is in a different state")
    public void givenASystemIsInADifferentState() {
        log.info("I'm running step: a system is in a different state");
        LocalDriverManager.getDriver().get("http://google.pl");
    }

    @When("I do something differently")
    public void whenIDoSomethingDifferently() {
        log.info("I'm running step: I do something differently");
    }

    @Then("system is in a different state")
    public void thenSystemIsInADifferentState() {
        log.info("I'm running step: system is in a different state");
    }
}
