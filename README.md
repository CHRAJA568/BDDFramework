# Selenium Cucumber Page Object Model

---

## Project Objective
This project aims to automate any web application across browsers by using the tools Selenium and Cucumber with Java as the programming language.

---

## Framework flow
* This project is an Maven Project.
* It is completely page object Model meaning each page in the UI will have an corresponding pageobject in the code which is basically for code readability and maintainability
* Framework flow starts from Runner class which is the package  src/test/java/runners
* Then based on the tag attribute feature from runner class the flows cntinues to particular feature file.
* Then from the feature file based on the attribute glue the stepdefinitions are traced and the flow continues to stepsdefs.
* From the stepdef(which are in Java language) the respective Page Obect is initialised and ations are performed.For now as it is a demo application went with only onepage object but in reality every Page in UI will have a corresponding pageObject in Code which basically defines the page object model design pattern
*The driver initialization and page object initialization are handled in src/main/java/managers package based on the configurations mentioned in the config file.
*The before and After hookks are managed in stefdefinations package
* Whenever any scenario fails in the After Hook a screenshot is taken
* As it is a maven project all the dependencies are managed in POM.XML file.

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber,Maven.


## Requirements
* Java Development Kit
* Maven
* WebDriver, using ChromeDriver

## Running Tests
* Clone the repository 
* Open the project using any Java IDE
* Run the runner class


## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`


