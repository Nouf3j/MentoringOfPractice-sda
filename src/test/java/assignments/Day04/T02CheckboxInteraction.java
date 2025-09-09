package assignments.Day04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class T02CheckboxInteraction {
    /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */



   static WebDriver driver;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Ensure both checkboxes are selected (Default Lifecycle)")
    void testCheckboxesSelection() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");


        List<WebElement> boxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));


        Assertions.assertEquals(2, boxes.size());


        for (int i = 0; i < boxes.size(); i++) {
            WebElement box = boxes.get(i);
            System.out.println("Checkbox " + (i + 1) + " initially selected? " + box.isSelected());

            if (!box.isSelected()) {
                box.click();
            }
        }


        for (int i = 0; i < boxes.size(); i++) {
            WebElement box = boxes.get(i);
            System.out.println("Checkbox " + (i + 1) + " final selected? " + box.isSelected());
            assertTrue(box.isSelected(), "Checkbox " + (i + 1));
        }
    }

}