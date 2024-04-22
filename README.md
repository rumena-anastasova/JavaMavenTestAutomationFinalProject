AutomationFinalProjectSkillo:
This repository hosts a Java test automation project developed using Maven, aimed at testing a web application. The project utilizes Selenium WebDriver and TestNG for automated testing.

Project Structure:
The project is organized as follows:

src/main/object: Contains Java classes representing different pages and objects in the web application, such as Header, HomePage, LoginPage, ProfilePage, PostPage, and RegistrationPage.

src/test/java: Includes test classes that leverage the objects defined in the 'object' package to perform automated tests on the web application.

src/test/resources: Holds additional resources used in testing, such as screenshots and uploaded files for specific test scenarios.


Dependencies:
The project relies on the following dependencies managed by Maven:

Selenium WebDriver: Version 4.18.1

WebDriverManager: Version 5.7.0

TestNG: Version 7.7.0

Apache Commons IO: Included implicitly for file manipulation

JetBrains Annotations: Used for annotation support


Test Suite Configuration:
The test suite configuration is defined in the testng.xml file located at the root of the project. The suite includes the following test classes:

VerifyHomePageTest

HomePageScrollTest

UserRegistrationTest

UserLoginTest

UserCreatePostTest

UserLogoutTest


Test Execution
To run the automated tests, execute the following Maven command in the terminal:

mvn clean test

This command triggers the execution of the test suite configured in the testng.xml file.


Before and After Test Logic:
The TestObject class defines common setup and teardown logic for tests:

Before Suite: Cleans the screenshots directory and sets up the WebDriver.

Before Method: Initializes the WebDriver instance before each test method.

After Method: Captures a screenshot in case of test failure and quits the WebDriver instance.


Screenshots: 
Screenshots for failed test cases are stored in the src/test/resources/screenshots directory. The directory is cleaned before each test suite run.


Contributing:
Contributions to this project are welcome! If you'd like to contribute, please follow the guidelines outlined in CONTRIBUTING.md.


License

This project is licensed under the MIT License - see the LICENSE file for details.

