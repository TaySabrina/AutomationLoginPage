package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class BasePage(protected val driver: WebDriver) {
    protected val wait = WebDriverWait(driver, Duration.ofSeconds(10))

    fun navigateTo(url: String){
        driver.get(url)
    }
    fun closeBrowser(){
        driver.quit()
    }
}