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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T05DynamicListManagement {
    /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */


        WebDriver driver;
        String url = "http://webdriveruniversity.com/To-Do-List/index.html";

        @BeforeEach
        void setUp() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

        @Test
        void todoListTest() {
            driver.get(url);

            Faker faker = new Faker();

            // 1️⃣ إضافة 5 مهام عشوائية
            for (int i = 0; i < 5; i++) {
                String task = faker.lorem().word();
                WebElement input = driver.findElement(By.cssSelector("input.new-todo"));
                input.sendKeys(task);
                input.submit(); // enter key
            }

            List<WebElement> tasks = driver.findElements(By.cssSelector("li.todo"));

            // 2️⃣ وضع خط على كل مهمة ثانية (index 1,3,..)
            for (int i = 1; i < tasks.size(); i += 2) {
                WebElement task = tasks.get(i).findElement(By.tagName("label"));
                task.click(); // هذا يؤشر على المهمة كمنجزة
            }

            // 3️⃣ حذف المهام المكتملة
            List<WebElement> completedTasks = driver.findElements(By.cssSelector("li.todo.completed button.destroy"));
            for (WebElement deleteBtn : completedTasks) {
                // زر الحذف يظهر عند hover → نستخدم JS
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
            }

            // 4️⃣ تحقق أن المهام المتبقية غير مكتملة
            List<WebElement> remainingTasks = driver.findElements(By.cssSelector("li.todo"));
            for (WebElement task : remainingTasks) {
                assertTrue(!task.getAttribute("class").contains("completed"),
                        "A completed task still remains!");
            }

            System.out.println("Test completed successfully. Remaining tasks are incomplete.");
        }
    }

