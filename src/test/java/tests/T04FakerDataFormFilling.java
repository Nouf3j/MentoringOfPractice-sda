package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T04FakerDataFormFilling {
    /*
    Task: Go to "https://demoqa.com/text-box"
        . Use Java Faker to:

        Generate and enter a fake full name
        Generate and enter a fake email address
        Generate and enter a fake current address
        Generate and enter a fake permanent address
        Submit the form and verify the output contains the entered data
    */
    WebDriver driver;
    String url = "https://demoqa.com/text-box";
    Faker faker;

    @Test
    void fakerTest() {
        driver.get(url);

        //Generate and enter a fake full name
        String fullName = faker.name().fullName();
        //Generate and enter a fake email address
        String email = faker.internet().emailAddress();
        //Generate and enter a fake current address
        String currentAddress = faker.address().fullAddress();
        // Generate and enter a fake permanent address
        String permanentAddress = faker.address().secondaryAddress();


        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);


        driver.findElement(By.id("submit")).click();

        // التحقق أن البيانات ظهرت في output
        WebElement output = driver.findElement(By.id("output"));
        String outputText = output.getText();

        assertTrue(outputText.contains(fullName), "Full Name not found in output");
        assertTrue(outputText.contains(email), "Email not found in output");
        assertTrue(outputText.contains(currentAddress), "Current Address not found in output");
        assertTrue(outputText.contains(permanentAddress), "Permanent Address not found in output");

        System.out.println("✅ All generated data found in the output!");
    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        faker = new Faker();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
