
# Java Test Framework

[Selenium](https://www.selenium.dev/) with [TestNG](https://testng.org) Integration.





## Using Maven

### Setup

* Clone the repo
* Install dependencies `mvn compile`

### To run your tests

- To run Suite with Chrome, run `mvn clean test`
- To run Suite with Firefox, run `mvn clean test -Dbrowser="firefox"`
- To run Suite with Edge, run `mvn clean test -Dbrowser="edge"`


## Notes
### Implements 
* Page Object Model
* Singleton Webdriver Factory
* Selenium By locators for elements
