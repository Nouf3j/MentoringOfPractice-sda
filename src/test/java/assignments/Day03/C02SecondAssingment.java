package assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02SecondAssingment {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://testpages.herokuapp.com/styled/index.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    void testNumberInput() {
        // TODO: Click on "Locators - Find By Playground Test Page"
        WebElement locatorsPage = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Locators - Find By Playground Test Page")));
        locatorsPage.click();

        // TODO: Print current URL
        System.out.println("Current URL after clicking Locators page: " + driver.getCurrentUrl());

        // TODO: Navigate back
        driver.navigate().back();

        // TODO: Print URL after going back
        System.out.println("URL after navigating back: " + driver.getCurrentUrl());

        // TODO: Click on "WebDriver Example Page"
        WebElement webdriverPage = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("WebDriver Example Page")));
        webdriverPage.click();

        // TODO: Print current URL
        System.out.println("Current URL after clicking WebDriver Example Page: " + driver.getCurrentUrl());

        // TODO: Enter value 20 in number input
        WebElement numberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("numberinput")));
        numberInput.clear();
        numberInput.sendKeys("20");

        // TODO: Verify 'two, zero' message appears
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("result")));
        String messageText = message.getText();
        System.out.println("Message displayed: " + messageText);

        if (messageText.contains("two, zero")) {
            System.out.println("Test Passed: Correct message displayed!");
        } else {
            System.out.println("Test Failed: Message is incorrect!");
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
