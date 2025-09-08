package assignments.Day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


public class Task2 {


    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Open Chrome browser and maximize before each test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Verify Selenium.dev page source contains 'WebDriver'")
    void testSeleniumPageSource() {
        // Navigate to Selenium website
        driver.get("https://www.selenium.dev");

        // Get page source and assert it contains "WebDriver"
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("WebDriver"), "Page source should contain 'WebDriver'");
    }

    @Test
    @DisplayName("Verify Python.org page source contains 'Python'")
    void testPythonPageSource() {
        // Navigate to Python website
        driver.get("https://www.python.org");

        // Get page source and assert it contains "Python"
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Python"), "Page source should contain 'Python'");
    }

    @AfterEach
    void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

}
