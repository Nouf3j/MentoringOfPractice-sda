package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T01SauceDemoTest {

    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String password = "secret_sauce";

    // Locators
    By userNameById = By.id("user-name");
    By passwordById = By.id("password");
    By loginButtonById = By.id("login-button");
    By sortDropDownByClass = By.className("product_sort_container");
    By pricesByXpath = By.className("inventory_item_price");

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void sauceDemoTest() throws InterruptedException {
        // Given: Go to https://www.saucedemo.com/
        driver.get(url);

        // When: Enter username as "standard_user"
        driver.findElement(userNameById).sendKeys(userName);

        // And: Enter password as "secret_sauce"
        driver.findElement(passwordById).sendKeys(password);

        // And: Click login button
        driver.findElement(loginButtonById).click();

        // And: Order products by "Price (low to high)"
        WebElement sortDropdown = driver.findElement(sortDropDownByClass);
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (low to high)");

        // Then: Assert last product costs $49.99, first product costs $7.99
        List<WebElement> prices = driver.findElements(pricesByXpath);

        Assertions.assertEquals("$7.99", prices.get(0).getText());
        Assertions.assertEquals("$49.99", prices.get(prices.size() - 1).getText());

        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
