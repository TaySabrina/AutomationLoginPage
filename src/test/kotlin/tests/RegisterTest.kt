package tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import pages.RegisterPage
import kotlin.test.assertEquals


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
        registerPage.fillName("João Souza Silva")
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
        registerPage.fillName("João Souza Silva")
        registerPage.fillEmail("invalid-email")
        registerPage.submitSignup()

        val errorMessage = registerPage.getValidationMessage()
        assertEquals("Preencha este campo.", errorMessage, "The error message is incorrect!")
    }



    @AfterEach
    fun tearDown(){
        registerPage.closeBrowser()
    }
}