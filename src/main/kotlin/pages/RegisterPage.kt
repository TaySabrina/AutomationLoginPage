package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class RegisterPage(driver: WebDriver): BasePage(driver) {
    private val nameField: WebElement
        get() = driver.findElement(By.name("name"))

    private val emailField: WebElement
        get() = driver.findElement(By.xpath("//input[@data-qa='signup-email']"))

    private val signupButton: WebElement
        get() = driver.findElement(By.xpath("//button[text()='Signup']"))

    fun fillName(name: String){
        nameField.sendKeys(name)
    }

    fun fillEmail(email: String){
        emailField.sendKeys(email)
    }

    fun submitSignup(){
        signupButton.click()
    }
}