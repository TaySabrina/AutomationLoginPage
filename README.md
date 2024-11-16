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
