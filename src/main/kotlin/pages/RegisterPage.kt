package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class RegisterPage( driver: WebDriver): BasePage(driver) {

    // Submit Information
    @FindBy(name = "name")
    lateinit var nameField: WebElement

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    lateinit var emailField: WebElement

    @FindBy(xpath = "//button[text()='Signup']")
   lateinit var signupButton: WebElement


    // Account Information
    @FindBy(id = "id_gender1")
    lateinit var titleMaleRadioButton: WebElement

    @FindBy(name = "id_gender2")
    lateinit var titleFemaleRadioButton:WebElement

    @FindBy(xpath = "//input[@data-qa='name']")
    lateinit var nameInformation: WebElement

    @FindBy(xpath = "//input[@data-qa='email']")
    lateinit var emailInformation: WebElement

    @FindBy(xpath = "//input[@data-qa='password']")
    lateinit var passwordInformation: WebElement

    @FindBy(id = "days")
   lateinit var dateOfBirth:WebElement

    @FindBy(id = "months")
    lateinit var monthOfBirth: WebElement

    @FindBy(id = "years")
    lateinit var yearOfBirth: WebElement

    @FindBy(id = "uniform-newsletter")
    lateinit var newsletterCheckBox: WebElement

    @FindBy(id = "uniform-optin")
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
    lateinit var country: WebElement

    @FindBy(xpath = "//input[@data-qa='state']")
    lateinit var stateName: WebElement

    @FindBy(xpath = "//input[@data-qa='city']")
    lateinit var cityName: WebElement

    @FindBy(id = "zipcode")
    lateinit var zipCode: WebElement

    @FindBy(id = "mobile_number")
    lateinit var mobileNumber: WebElement

    @FindBy(xpath = "//input[@data-qa='create-account']")
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
    fun selectMaleTitle(){
        titleMaleRadioButton.click()
    }

    fun selectFemaleTitle(){
        titleFemaleRadioButton.click()
    }

    fun fillNameInfo(fullName: String){
        nameInformation.sendKeys(fullName)
    }

    fun fillEmailInfo(registerEmail: String){
        emailInformation.sendKeys(registerEmail)
    }

    fun fillPasswordInfo(registerPassword: String){
        passwordInformation.sendKeys(registerPassword)
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
        newsletterCheckBox.click()
    }

    fun checkOffers(){
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

    fun selectCountry(countrySelection: String){
        country.sendKeys(countrySelection)
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
}