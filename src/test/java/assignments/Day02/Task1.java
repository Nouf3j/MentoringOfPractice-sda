package assignments.Day02;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class Task1 {



        WebDriver driver;

        @BeforeEach
        void setUp() {
            // Launch Chrome and maximize window before each test
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        @DisplayName("Test browser back and forward navigation with title verification")
        void testBackAndForwardNavigation() {
            // Navigate to Wikipedia
            driver.get("https://www.wikipedia.org");
            assertTrue(driver.getTitle().contains("Wikipedia"), "Title should contain Wikipedia");

            // Navigate to Google
            driver.get("https://www.google.com");
            assertTrue(driver.getTitle().contains("Google"), "Title should contain Google");

            // Navigate back -> should go to Wikipedia
            driver.navigate().back();
            assertTrue(driver.getTitle().contains("Wikipedia"), "Title should contain Wikipedia after going back");

            // Navigate forward -> should go to Google
            driver.navigate().forward();
            assertTrue(driver.getTitle().contains("Google"), "Title should contain Google after going forward");

            // Navigate back again -> Wikipedia
            driver.navigate().back();
            assertTrue(driver.getTitle().contains("Wikipedia"), "Title should contain Wikipedia after going back again");

            // Navigate forward again -> Google
            driver.navigate().forward();
            assertTrue(driver.getTitle().contains("Google"), "Title should contain Google after going forward again");
        }

        @Test
        @DisplayName("Test refresh on Google page")
        void testRefreshOnGoogle() {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Refresh the page
            driver.navigate().refresh();

            // Verify the title still contains Google
            assertTrue(driver.getTitle().contains("Google"), "Title should still contain Google after refresh");
        }

        @AfterEach
        void tearDown() {
            // Close the browser after each test
            if (driver != null) {
                driver.quit();
            }
        }
    }


