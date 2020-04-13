# Cucumber 8 JVM, Spring dependency injection
This is an example maven framework project demonstrating, the use of Springs dependency injection with Selenium-Webdriver/ cucumber. Using system properties to run either Desktop or Mobile specfic tests.

<h2>Dependency Injection</h2>
The project has been setup that each platform has its own page objects, driven from a signle implementation for the specfic page under test.
The decision as to which page implentation is determined at runtime using Spring profiles.

<h2>Usage</h2>
To run with just Chrome or Firefox browser pass the relevent parameter:<br/>

```
mvn clean test -Dweb.browser=chrome
```
<br/>


To run with Chrome Android 8.0.0 emulation:<br/>
```
mvn clean test -Dweb.browser=chrome -Dspring.profiles.active=mobile
```
The end of the test run a report is generated in root named `report` this can be opened in any browser.


