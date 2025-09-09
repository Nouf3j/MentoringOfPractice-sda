package assignments.Day05;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class T07MultiSelectOperations {
    /*
    Launch browser
Open https://demoqa.com/select-menu
Select Standard Multi-Select using element id
Verify element is multi-select
Select 'Opel' using index, then deselect using index
Select 'Saab' using value, then deselect using value
Deselect all options
Close browser

     */
        WebDriver driver;

        @BeforeEach
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/select-menu");
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void standardMultiSelectTest() {

            //Select Standard Multi-Select using element id
            WebElement multiSelectElement = driver.findElement(By.id("cars"));
            Select multiSelect = new Select(multiSelectElement);

            //Verify element is multi-select
            Assertions.assertTrue(multiSelect.isMultiple());

            //Select 'Opel' using index, then deselect using index
            multiSelect.selectByIndex(2);
            System.out.println("Selected by index: " + multiSelect.getFirstSelectedOption().getText());
            multiSelect.deselectByIndex(2);
            System.out.println("Deselected by index");

             //Select 'Saab' using value, then deselect using value
            multiSelect.selectByValue("saab");
            System.out.println("Selected by value: " + multiSelect.getFirstSelectedOption().getText());
            multiSelect.deselectByValue("saab");
            System.out.println("Deselected by value");

            //Deselect all options
            multiSelect.selectByIndex(0);
            multiSelect.selectByIndex(1);
            multiSelect.deselectAll();
            System.out.println("Deselected all options");
        }
    }






