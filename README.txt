--------------------------LogicStudioTest2 Automation Tests--------------------------
This repository contains automated test cases for the LogicStudioTest2 project, focusing on the login functionality of a technology store. The tests are implemented using Selenium, Java, and TestNG.

-----------------------------------Prerequisites-------------------------------------
Ensure you have Java installed on your machine.
Set up Selenium WebDriver for your project.
Configure TestNG for your project.
Download and configure ChromeDriver according to your operating system.

----------------------------------Getting Started------------------------------------
1. Clone this repository to your local machine using: git clone https://github.com/csorto2263/LogicStudioTest2.git
2. Configure the paths and dependencies in the project as needed for your setup.
3. Open the LoginTest.java file located in src/test/java/ to explore the implemented test cases.

--------------------------------Test Cases Overview----------------------------------
Case 1 - Successful Login
In this test, a successful login is simulated on the technology store's login page.

Steps
	1. Open the browser and navigate to the login URL.
	2. Enter valid credentials.
	3. Click the login button.
Validation
	*  Confirm the successful login by verifying the presence of the "My Account" link.

Case 2 - Failed Login
In this test, a failed login attempt is simulated using invalid credentials.

Steps
	1. Open the browser and navigate to the login URL.
	2. Enter invalid credentials.
	3. Click the login button.
Validation
	*  Confirm the failed login by checking the appearance of an error message.
	*  Validate that the error message is correct.



