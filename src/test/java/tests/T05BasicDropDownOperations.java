package tests;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T05BasicDropDownOperations {
 /*
    Go to https://the-internet.herokuapp.com/dropdown
Create selectByIndexTest method - Select Option 1 using index
Create selectByValueTest method - Select Option 2 by value
Create selectByVisibleTextTest method - Select Option 1 by visible text
Create printAllTest method - Print all dropdown values
Verify dropdown has Option 2 text
Create printFirstSelectedOptionTest - Print first selected option
Verify dropdown size equals 3 elements


  */

        WebDriver driver;

        @BeforeEach
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://the-internet.herokuapp.com/dropdown");
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        @Test

        public void allDropdownTests() {
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(dropdownElement);

            //  Select Option 1 by index
            dropdown.selectByIndex(1);
            System.out.println("Selected by index: " + dropdown.getFirstSelectedOption().getText());
            Assertions.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());

            //  Select Option 2 by value
            dropdown.selectByValue("2");
            System.out.println("Selected by value: " + dropdown.getFirstSelectedOption().getText());
            Assertions.assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

            //  Select Option 1 by visible text
            dropdown.selectByVisibleText("Option 1");
            System.out.println("Selected by visible text: " + dropdown.getFirstSelectedOption().getText());
            Assertions.assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());

            //  Print all dropdown values
            List<WebElement> allOptions = dropdown.getOptions();
            System.out.println("All dropdown options:");
            for (WebElement option : allOptions) {
                System.out.println(option.getText());
            }

            //  Verify dropdown has Option 2 text
            boolean foundOption2 = allOptions.stream()
                    .anyMatch(option -> option.getText().equals("Option 2"));
            Assertions.assertTrue(foundOption2, "Dropdown should contain Option 2");

            //  Print first selected option
            WebElement firstSelected = dropdown.getFirstSelectedOption();
            System.out.println("First selected option: " + firstSelected.getText());

            // Verify dropdown size equals 3 elements
            Assertions.assertEquals(3, allOptions.size(), "Dropdown should have 3 elements");
        }
    }


