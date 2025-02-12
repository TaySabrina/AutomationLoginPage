package tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import pages.RegisterPage
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class RegisterTest {
    private lateinit var driver: WebDriver
    private lateinit var registerPage: RegisterPage

    @BeforeEach
    fun setUp(){
        driver = ChromeDriver()
        registerPage = RegisterPage(driver)

        registerPage.navigateTo("https://automationexercise.com/login")
    }

    @Test
    fun testUserRegistration(){
        registerPage.fillName("João Souza")
        registerPage.fillEmail("joao.silva123@email.com")
        registerPage.submitSignup()

        try{
            val currentURL = driver.currentUrl
            assertEquals("https://automationexercise.com/signup", currentURL, "A url não corresponde a esperada!")

            val pageTitle = driver.title
            println("Título da página: $pageTitle")
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    @Test
    fun testUserRegistrationWithInvalidEmail(){
        registerPage.fillName("João Souza")
        registerPage.fillEmail("invalid-email")
        registerPage.submitSignup()

        val errorMessage = registerPage.getValidationMessage()
        assertEquals("Please fill out this field.", errorMessage, "The error message is incorrect!")
    }

    @Test
    fun testUserCompleteRegistration(){
        //sign in page ** New User Signup **
        testUserRegistration()
        //signup page ** Account Info **
        registerPage.selectMaleTitle()
        registerPage.fillNameInfo("João Souza Silva")
        registerPage.fillPasswordInfo()
        registerPage.selectDateOfBirth("10")
        registerPage.selectMonthOfBirth("8")
        registerPage.selectYearOfBirth("1988")
        registerPage.checkNewsletter()
        registerPage.checkOffers()
        //signup page ** Address Info **
        registerPage.fillFirstName("João")
        registerPage.fillLastName("Silva")
        registerPage.fillCompanyName("Innovation Development LTDA")
        registerPage.fillAddress1("Johnson Street, 45, SQDT 8")
        registerPage.selectCountry("Canada")
        registerPage.fillStateName("Alberta")
        registerPage.fillCityName("Edmonton")
        registerPage.fillZipCode("T4X 0A5")
        registerPage.fillMobileNumber("(780)989-5440")
        registerPage.submitCreateAccount()

        assertTrue(registerPage.isAccountCreated(), "Account creation failed!")
    }


    @AfterEach
    fun tearDown(){
        registerPage.closeBrowser()
    }
}