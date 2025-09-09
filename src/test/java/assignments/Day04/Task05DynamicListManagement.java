package assignments.Day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
public class Task05DynamicListManagement {
    /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    void testToDoList() throws InterruptedException {
        // 1. Add 5 random tasks
        for (int i = 0; i < 5; i++) {
            String task = faker.lorem().sentence(3); // random text
            WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
            input.sendKeys(task);
            input.sendKeys(Keys.ENTER);
        }

        Thread.sleep(2000);

        // 2. Mark every other task as completed (strikethrough)
        List<WebElement> tasks = driver.findElements(By.xpath("//li"));
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 0) {  // كل ثاني عنصر
                tasks.get(i).click();
            }
        }

        Thread.sleep(2000);

        // 3. Delete all completed tasks
        List<WebElement> tasksList = driver.findElements(By.xpath("//li"));
        for (WebElement task : tasksList) {
            if (task.getAttribute("class").contains("completed")) {
                WebElement deleteBtn = task.findElement(By.tagName("span"));
                new Actions(driver).moveToElement(task).perform(); // hover
                deleteBtn.click();
                Thread.sleep(500);
            }
        }


        // 4. Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.xpath("//li"));
        for (WebElement task : remainingTasks) {
            assertFalse(task.getAttribute("class").contains("completed"),
                    "Task should not be completed");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}