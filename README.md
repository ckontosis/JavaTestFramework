
# Java Test Framework

[Selenium](https://www.selenium.dev/) with [TestNG](https://testng.org) Integration.

## Using Maven

### Requirements

* Java 11
* Maven 3

### Setup

* Clone the repo
* Install dependencies `mvn compile`

### To configure tests

* Create a Page Object Model for each page you want to include with BaseTest as parent 
* Use Selenium By locators to locate page elements 
* Create every test case as separate class
* Go to testng.xml located at the top level
* Add test case classes to testng.xml* 
* Set the required parameters for the tests  

### To run your tests

* To run Suite with Chrome, run `mvn clean test`
* To run Suite with Firefox, run `mvn clean test -Dbrowser="firefox"`
* To run Suite with Edge, run `mvn clean test -Dbrowser="edge"`


## Notes
### Implements 
* Page Object Model
* Singleton Webdriver Factory
* Selenium By locators for elements
