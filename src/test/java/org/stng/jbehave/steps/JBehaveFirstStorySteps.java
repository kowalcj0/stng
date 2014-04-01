package org.stng.jbehave.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.stng.jbehave.DriverManager;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveFirstStorySteps {

    static Logger log = Logger.getLogger(JBehaveFirstStorySteps.class);
    WebDriver driver = DriverManager.getDriver();

    @Given("a system state")
    public void givenASystemState() {
        Reporter.log("Given a system state<br/>");
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        log.info("I'm running step: Given a system state! using: " + driver.getClass().toString() + " / " + ste[ste.length - 1 - 1].getMethodName());
        driver.get("http://google.pl");
    }

    @When("I do something")
    public void whenIDoSomething() {
        log.info("I'm running step: When I do something");
        Reporter.log("When I do something<br/>");
    }

    @Then("system is in a normal state")
    public void thenSystemIsInANormalState() {
        log.info("I'm running step: Then system is in a normal state");
        Reporter.log("Then system is in a normal state<br/>");
    }
}
