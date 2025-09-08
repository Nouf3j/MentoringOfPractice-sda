package assignments.Day03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01fistAssignment {

    // Navigate to: https://opensource-demo.orangehrmlive.com/

    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/form/div[1]/div/div[2]/input"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']"; // Fill relative path

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/form/div[2]/div/div[2]/input";
    String relativePasswordXPath = "//input[@name='password']";

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/form/div[3]/button";
    String relativeLoginButtonXPath = "//button[@type='submit']";

    // TODO: Test both approaches work
    @Test
    void relativeXpathTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.xpath(relativeUsernameXPath));
        WebElement password = driver.findElement(By.xpath(relativePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(relativeLoginButtonXPath));

        username.sendKeys("Nouf");
        password.sendKeys("Nouf123");
        loginButton.click();

        driver.quit();
    }

    @Test
    void absoluteXpathTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement password = driver.findElement(By.xpath(absolutePasswordXPath));
        WebElement loginButton = driver.findElement(By.xpath(absoluteLoginButtonXPath));

        username.sendKeys("Nouf");
        password.sendKeys("Nouf123");
        loginButton.click();

        driver.quit();
    }
}
