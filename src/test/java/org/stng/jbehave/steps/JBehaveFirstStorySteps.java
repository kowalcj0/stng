package org.stng.jbehave.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import organized.chaos.LocalDriverManager;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveFirstStorySteps {

    static Logger log = Logger.getLogger(JBehaveFirstStorySteps.class);
    WebDriver driver = LocalDriverManager.getDriver();

    @Given("a system state")
    public void givenASystemState() {
        Thread.currentThread().getStackTrace();
        Reporter.log("Given a system state");
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        log.info("I'm running step: a system state! using: " + driver.getClass().toString() + " / " + ste[ste.length - 1 - 1].getMethodName());
        driver.get("http://google.pl");
    }

    @When("I do something")
    public void whenIDoSomething() {
        log.info("I'm running step: I do something");
        Reporter.log("When I do something");
    }

    @Then("system is in a normal state")
    public void thenSystemIsInANormalState() {
        log.info("I'm running step: system is in a normal state");
        Reporter.log("Then system is in a normal state");
    }
}
