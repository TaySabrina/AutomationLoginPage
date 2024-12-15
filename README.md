# AutomationLoginPage
#### The project focuses on automating a login page using Selenium with Kotlin

>  Login Page - SignUp Automation: https://automationexercise.com/login
<br>

***BasePage: is the foundation for pages in the Page Object Model (POM) pattern used in Selenium automation. It provides:***
- **driver**: controls the browser
- **wait**: defines explicit waits( 10 seconts by default)
- **navigateTo (url:String)**: navigates to a URL
- **closeBrowser()**: closes the browser
  
------
***RegisterPage: represents the registration page in the POM pattern. It extends `BasePage` and provides:***
- **nameField, emailField and signupButton**: locates, name by name atribute, email and signup button by xpath selector
- **key methods**: fillName (name:String), fillEmail (email: String) and submitSignup()
------   
***RegisterTest: automates a user registration flow using Selenium and JUnit. It focuses on testing the functionality of the `RegisterPage:`***
- Setup: Initializes the Chrome WebDriver and navigates to the login page before each test
- Test Method:
  - Fills the user's name and email using the `RegisterPage` methods
  - Submits the form by clicking the signup button
  - Verifies the redirection to te expected signup page using an assertion on the current URL
  - Optionally prints the page title
- Tear Down: closes the browser after each test to clean up resources
-----

***Refactoring and Improvements***    

I refactored the code and used Page Factory as an improvement.   
I also implemented new locators, which I will use soon for additional tests. Additionally, I included a new test to validate other data inputs.

Page Factory
The Page Factory design pattern is used in this project to efficiently initialize and manage web element locators.   
By using the @FindBy annotation, it maps elements such as input fields, buttons, and checkboxes to variables in the page object class.   
This helps keep the test code clean, organized, and easier to maintain.

**Key Features:**  
**@FindBy Annotations:** Locates elements using identifiers like name, xpath, id, etc.  
**PageFactory.initElements():** Initializes the elements on page load, linking the locators with the web elements.  
**Maintainability:** If a locator changes, it only needs to be updated in the page class, not throughout the test code.  
**Reusability:** Methods for interacting with elements can be reused across multiple tests.  
**Organization:** Keeps locators and actions related to a page in a single class for better structure and clarity.  

Using Page Factory helps create a scalable, efficient, and easily maintainable test automation framework.
