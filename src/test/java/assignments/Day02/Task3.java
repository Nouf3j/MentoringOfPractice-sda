package assignments.Day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;



public class Task3 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Open Chrome browser before each test
        driver = new ChromeDriver();
    }

    @Test
    void testBrowserSize() {
        // Navigate to BBC
        driver.get("https://www.bbc.com");

        // Set window size to 800x600
        Dimension dimension = new Dimension(800, 600);
        driver.manage().window().setSize(dimension);


        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(800, actualSize.getWidth(), "Width should be 800");
        assertEquals(600, actualSize.getHeight(), "Height should be 600");
    }

    @Test
    void testBrowserPosition() {
        // Set window position to (100,100)
        Point point = new Point(100, 100);
        driver.manage().window().setPosition(point);

        // Verify window position
        Point actualPosition = driver.manage().window().getPosition();
        assertEquals(100, actualPosition.getX(), "X position should be 100");
        assertEquals(100, actualPosition.getY(), "Y position should be 100");
    }

    @AfterEach
    void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }




}
