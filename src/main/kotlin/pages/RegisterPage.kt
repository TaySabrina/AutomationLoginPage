package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import io.github.cdimascio.dotenv.dotenv
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


class RegisterPage( driver: WebDriver): BasePage(driver) {

    // Submit Information
    @FindBy(name = "name")
    lateinit var nameField: WebElement

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    lateinit var emailField: WebElement

    @FindBy(xpath = "//button[text()='Signup']")
   lateinit var signupButton: WebElement


    // Account Information
    @FindBy(xpath = "//input[@type='radio' and @value='Mr']")
    lateinit var titleMaleRadioButton: WebElement

    @FindBy(xpath = "//input[@type='radio' and @value='Mrs']")
    lateinit var titleFemaleRadioButton:WebElement

    @FindBy(xpath = "//input[@data-qa='name']")
    lateinit var nameInformation: WebElement

    @FindBy(xpath = "//input[@data-qa='email']")
    lateinit var emailInformation: WebElement

    @FindBy(xpath = "//input[@data-qa='password']")
    lateinit var paswInformation: WebElement

    @FindBy(id = "days")
   lateinit var dateOfBirth:WebElement

    @FindBy(id = "months")
    lateinit var monthOfBirth: WebElement

    @FindBy(id = "years")
    lateinit var yearOfBirth: WebElement

    @FindBy(id = "newsletter")
    lateinit var newsletterCheckBox: WebElement

    @FindBy(id = "optin")
    lateinit var offersCheckBox: WebElement


    //Address Information
    @FindBy(xpath = "//input[@data-qa='first_name']")
    lateinit var firstName: WebElement

    @FindBy(xpath = "//input[@data-qa='last_name']")
    lateinit var lastName: WebElement

    @FindBy(xpath = "//input[@data-qa='company']")
    lateinit var companyName: WebElement

    @FindBy(id = "address1")
    lateinit var address1: WebElement

    @FindBy(id = "address2")
    lateinit var address2: WebElement

    @FindBy(id = "country")
    lateinit var countryDropdown: WebElement

    @FindBy(xpath = "//input[@data-qa='state']")
    lateinit var stateName: WebElement

    @FindBy(xpath = "//input[@data-qa='city']")
    lateinit var cityName: WebElement

    @FindBy(id = "zipcode")
    lateinit var zipCode: WebElement

    @FindBy(id = "mobile_number")
    lateinit var mobileNumber: WebElement

    @FindBy(xpath = "//button[@data-qa='create-account']")
    lateinit var createAccountButton: WebElement

    @FindBy(name = "email")
    lateinit var emailInput: WebElement

    init {
        // Inicializa os elementos da página
        PageFactory.initElements(driver, this)
    }


    //Submit Information Functions
    fun fillName(name: String){
        nameField.sendKeys(name)
    }

    fun fillEmail(email: String){
        emailField.sendKeys(email)
    }

    fun submitSignup(){
        signupButton.click()
    }

    // Account Information Functions
    fun selectMaleTitle() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        val radioButton = wait.until(ExpectedConditions.elementToBeClickable(titleMaleRadioButton))
        radioButton.click()
    }

    fun selectFemaleTitle(){
        val wait = WebDriverWait(driver, Duration.ofSeconds(5))
        val radioButton = wait.until(ExpectedConditions.elementToBeClickable(titleFemaleRadioButton))
        radioButton.click()
    }

    fun fillNameInfo(fullName: String){
        nameInformation.sendKeys(fullName)
    }

    fun fillEmailInfo(registerEmail: String){
        emailInformation.sendKeys(registerEmail)
    }

    fun fillPasswordInfo() {
        val dotenv = dotenv()
        val password = dotenv["TEST_PASSWORD"] ?: throw IllegalStateException("Password not found")

        paswInformation.sendKeys(password)
    }

    fun selectDateOfBirth(day: String){
        dateOfBirth.sendKeys(day)
    }

    fun selectMonthOfBirth(month: String){
        monthOfBirth.sendKeys(month)
    }

    fun selectYearOfBirth(year: String){
        yearOfBirth.sendKeys(year)
    }

    fun checkNewsletter(){
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].scrollIntoView(true);", newsletterCheckBox)
        newsletterCheckBox.click()

    }

    fun checkOffers(){
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].scrollIntoView(true);", offersCheckBox)
        offersCheckBox.click()
    }

    // Address Information Functions
    fun fillFirstName(firstNameInput: String){
        firstName.sendKeys(firstNameInput)
    }

    fun fillLastName(lastNameInput: String){
        lastName.sendKeys(lastNameInput)
    }

    fun fillCompanyName(company: String){
        companyName.sendKeys(company)
    }

    fun fillAddress1(principalAddress: String){
        address1.sendKeys(principalAddress)
    }

    fun fillAddress2(secondAddress: String){
        address2.sendKeys(secondAddress)
    }

    fun selectCountry(countryName: String){
        val select = Select(countryDropdown)
        select.selectByVisibleText(countryName)
    }

    fun fillStateName(state: String){
        stateName.sendKeys(state)
    }

    fun fillCityName(city: String){
        cityName.sendKeys(city)
    }

    fun fillZipCode(zipCodeNumber: String){
        zipCode.sendKeys(zipCodeNumber)
    }

    fun fillMobileNumber(mobile: String){
        mobileNumber.sendKeys(mobile)
    }

    fun submitCreateAccount(){
        createAccountButton.click()
    }

    fun getValidationMessage(): String? {
        return emailInput.getAttribute("validationMessage")
    }

    fun isAccountCreated(): Boolean {
        val successMessage = "//h2[contains(text(), 'ACCOUNT CREATED!)']"
        return try{
            driver.findElement(By.xpath(successMessage)).isDisplayed
        } catch (e: NoSuchElementException){
            false
        }
    }
}