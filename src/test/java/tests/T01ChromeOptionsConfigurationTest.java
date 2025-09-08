package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class T01ChromeOptionsConfigurationTest {
    /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");


        driver = new ChromeDriver(options);
    }

    @Test
    public void openBrowserAndCheckTitle() throws InterruptedException {

        driver.get("https://www.example.com");
           Thread.sleep(3000);

        String pageTitle = driver.getTitle();
        Assertions.assertTrue(pageTitle.contains("Example"), "Title does not contain 'Example'");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

