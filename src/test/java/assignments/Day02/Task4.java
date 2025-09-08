package assignments.Day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


public class Task4 {

    static WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        // Launch Chrome browser
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    void testMultipleNavigation() {
        // Navigate to Google
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title should contain Google");

        // Navigate to YouTube
        driver.get("https://www.youtube.com");
        assertTrue(driver.getTitle().contains("YouTube"), "Title should contain YouTube");

        // Navigate to LinkedIn
        driver.get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"), "Title should contain LinkedIn");
    }

    @Test
    void testBackAndForward() {
        // Navigate back twice: LinkedIn -> YouTube -> Google
        driver.navigate().back(); // Back to YouTube
        driver.navigate().back(); // Back to Google
        assertTrue(driver.getCurrentUrl().contains("google.com"), "Should be back at Google");

        // Navigate forward twice: Google -> YouTube -> LinkedIn
        driver.navigate().forward(); // Forward to YouTube
        driver.navigate().forward(); // Forward to LinkedIn
        assertTrue(driver.getCurrentUrl().contains("linkedin.com"), "Should be at LinkedIn");
    }

    @AfterAll
    static void tearDownAll() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }



}
