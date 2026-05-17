package SeleniumTests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JenkinsTest {

    @Test
    public void testAutomation() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\QuratUlAin\\Desktop\\Softwares\\Software Installers\\Editors\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            // Amazon search
            driver.get("https://www.amazon.com");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nike shoes");
            driver.findElement(By.id("nav-search-submit-button")).click();
            Thread.sleep(3000);

            // Facebook login attempt
            driver.get("https://www.facebook.com");
            driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
            driver.findElement(By.name("pass")).sendKeys("1234");
            driver.findElement(By.name("login")).click();
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}