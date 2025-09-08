package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T03RadioButtonSelection {
    /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */



    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");


        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    void testRadioButtons() {
        String[][] radios = {
                {"yesRadio", "Yes"},
                {"impressiveRadio", "Impressive"},
                {"noRadio", "No"}
        };

        for (String[] r : radios) {
            String id = r[0];
            String name = r[1];

            WebElement input = driver.findElement(By.id(id));

            if (!input.isEnabled()) {
                System.out.println(name + " → Disabled (cannot be selected).");
                continue;
            }

            // اضغط على اللابل بدل الـ input
            driver.findElement(By.cssSelector("label[for='" + id + "']")).click();

            // تحقق من الاختيار
            Assertions.assertTrue(input.isSelected(), name + " radio should be selected");

            // اقرأ النتيجة المعروضة
            WebElement result = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.text-success"))
            );

            Assertions.assertEquals(name, result.getText().trim());

            System.out.println(name + " → Selected & verified.");
        }
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
