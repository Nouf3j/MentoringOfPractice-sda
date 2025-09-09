package assignments.Day05;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class T06OldStyleSelectMenu {


    /*
     Launch browser
Open https://demoqa.com/select-menu
Select Old Style Select Menu using element id
Print all dropdown options
Select 'Purple' using index
Select 'Magenta' using visible text
Select an option using value
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
        public void oldStyleSelectMenuTest() {
            //Select Old Style Select Menu using element id
            WebElement oldSelectElement = driver.findElement(By.id("oldSelectMenu"));
            Select oldSelect = new Select(oldSelectElement);

            //Print all dropdown options
            System.out.println("All options in Old Style Select Menu:");
            List<WebElement> allOptions = oldSelect.getOptions();
            for (WebElement option : allOptions) {
                System.out.println(option.getText());
            }

             //Select 'Purple' using index
            oldSelect.selectByIndex(4);
            System.out.println("Selected by index: " + oldSelect.getFirstSelectedOption().getText());

              //Select 'Magenta' using visible text
            oldSelect.selectByVisibleText("Magenta");
            System.out.println("Selected by visible text: " + oldSelect.getFirstSelectedOption().getText());

             //Select an option using value
            oldSelect.selectByValue("3");
            System.out.println("Selected by value: " + oldSelect.getFirstSelectedOption().getText());
        }
    }





