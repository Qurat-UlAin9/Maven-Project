package SeleniumTests;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class JenkinsTest {

    @Test
    public void testAutomation() {

        // Auto setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Jenkins-safe headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
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