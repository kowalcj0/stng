# STNG

This project should run JBehave stories as JUnit stories in parallel using TestNG and Selenium WebDriver.


## PROBLEM
I used the "[Getting Started](http://jbehave.org/reference/stable/getting-started.html)" JBehave example to run JBehave stories as JUnit tests.
And then I tried to run these ['JBehave/JUnit' tests using TestNG](http://testng.org/doc/documentation-main.html#junit).
To do it I set the junit parameter in the TestNG xml suite file to "true" -> src/test/resources/org.stng.jbehave.LocalJbehaveWebDriverListener.xml
(if it's set to false, no test will be executed!)
At this point I hit the wall, for more details have a look at the comments in the org.stng.jbehave.LocalJbehaveWebDriverListener class.


## log.info("");
Yeah, I used a lot of them ;)


## Running WebDriver in parallel
Idea of parallel WebDriver execution is based on this article: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/


## How to run tests from CLI

    mvn clean test


## How to run tests from IDE
Tested with IntelliJ Idea 13.0.1
simply right click on the "src/test/resources/org.stng.jbehave.LocalJbehaveWebDriverListener.xml"
and chose "Run ...."


## How to download WebDriver binaries automatically
This project is using Mark Collin's "selenium-standalone-server-plugin" which is a Maven plugin that can download
WebDriver binaries automatically.
The pom.xml is currently configured to download only a Chrome driver binary for 64bit Linux OSes.
If you need a different one, then change the plugin configuration or download the binary manually and set the path to it
accordingly in the:

    organized.chaos.LocalDriverFactory
