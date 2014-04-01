# STNG

This project should run JBehave stories as JUnit stories in parallel using TestNG and Selenium WebDriver.
Tests can be executed locally or remotely.


## PROBLEM
I used the "[Getting Started](http://jbehave.org/reference/stable/getting-started.html)" JBehave example to run JBehave stories as JUnit tests.
And then I tried to run these ['JBehave/JUnit' tests using TestNG](http://testng.org/doc/documentation-main.html#junit).
To do it I set the junit parameter in the TestNG xml suite file to "true" -> src/test/resources/org.stng.jbehave.LocalWebDriverListener.xml
(if it's set to false, no test will be executed!)

## JBehave Report
Unfortunately

JBehave Report can be found:

    target/jbehave/view/index.html

## TestNG Report
As we all know reporting is very important.
That's why in both local and remote WebDriverListeners I'm changing the name of the test method
that will appear in the final TestNG HTML report to one that also contains browser name its version and OS name.
It's very handy when you need to analyse the results.

btw. after running tests from CLI, TestNG HTML report is here:

    target/surefire-reports/index.html


## Configuration
Before you run your tests locally or remotely, you need to:

* decide in what browsers you want to run them
* configure TestNG XML suites accordingly (they are in src/test/resources)
* get the OS specific driver binaries
    * this process can be automated using Mark Collin's "selenium-standalone-server-plugin"
    * more details below


### Local configuration
Change the path to driver binaries in src/test/java/org/stng/jbehave/LocalDriverFactory.java
Of course you can parametrize this class differently, but for now I tried to keep things simple.

Btw. there's no need to do it for Firefox as its driver binary comes together with Selenium jar.

### Remote configuration
You don't have to change anything in project, simply:

Start the hub

    java -jar selenium-server-standalone-2.39.0.jar -role hub

Then register the nodes:
FF:

    java -jar selenium-server-standalone-2.39.0.jar -role node -hub http://127.0.0.1:4444/grid/register -browser browserName=firefox,version=27,maxInstances=1,platform=LINUX

Chrome:

    java -Dwebdriver.chrome.driver="/path/to/the/chrome/driver/binary/chromedriver" -jar selenium-server-standalone-2.39.0.jar -role node -hub http://127.0.0.1:4444/grid/register -browser browserName=chrome,version=30,maxInstances=1,platform=LINUX -port 5557


## How to run tests locally from CLI

    mvn clean test

or if you want to explicitly specify the profile then:

    mvn clean test -P runLocally


## How to run tests remotely using Selenium GRID
First of all prepare your Grid environment, then:

    mvn clean test -P runRemotely


## How to run tests from IDE
Tested with IntelliJ Idea 13.0.1
Once your environment is configure and ready to run your tests, then:
* right click on one the TestNG XML test suite file in "src/test/resources/"
* and chose "Run ...."


## How to download WebDriver binaries automatically
This project is using Mark Collin's "selenium-standalone-server-plugin" which is a Maven plugin that can download
WebDriver binaries automatically.
The pom.xml is currently configured to download only a Chrome driver binary for 64bit Linux OSes.
If you need a different one, then change the plugin configuration or download the binary manually and set the path to it
accordingly in the:

    org.stng.jbehave.LocalDriverFactory

If you can't download desired binary, check if the URL specified in:

    src/main/resources/RepositoryMapForMavenWebDriverBinaryDownloaderPlugin.xml

To this file and its hash are correct.


## Known issues
Dunno why I can't run tests with HTMLUnit!


## Varia
Interesting posts with some ideas that can be used later in this project:
https://groups.google.com/forum/#!search/Can$20i$20call$20JBehave$20java$20class$20in$20TestNG/selenium-users/hgHmQJPwPhg/6KJ8u7VcJD4J
http://packtlib.packtpub.com/library/9781849515740/pref05