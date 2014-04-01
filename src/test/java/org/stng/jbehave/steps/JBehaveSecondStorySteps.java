package org.stng.jbehave.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.stng.jbehave.DriverManager;


public class JBehaveSecondStorySteps {

    static Logger log = Logger.getLogger(JBehaveSecondStorySteps.class);
    WebDriver driver = DriverManager.getDriver();

    @Given("a system is in a different state")
    public void givenASystemIsInADifferentState() {
        Thread.currentThread().getStackTrace();
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        log.info("I'm running step: a system is in a different state! using: " + driver.getClass().toString() + " / " + ste[ste.length - 1 - 1].getMethodName());
        driver.get("http://google.pl");
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
