package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Nested
class C08GoogleSearchTest {
        static WebDriver driver;
        @BeforeAll
        public static void setUp() throws InterruptedException {
// TODO: Initialize static WebDrive
// TODO: Navigate to Google
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            Thread.sleep(5000);
            driver.manage().window().maximize();


        }
        @Test
        public void searchMovies() {
            String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};

            for(String movie : movies) {
// TODO: Find search box
// TODO: Clear and enter movie name
// TODO: Submit search
// TODO: Get and print result count
// TODO: Clear search box for next iteration

                  // TODO: Find search box
                WebElement searchBox = driver.findElement(By.name("q"));

                // Clear and enter movie name
                searchBox.clear();
                searchBox.sendKeys(movie);

                // Submit search
                searchBox.sendKeys(Keys.ENTER);

                // Get and print result count
                WebElement results = driver.findElement(By.id("result-stats"));
                System.out.println(movie + " → " + results.getText());

                // نرجع لصفحة البحث عشان ندخل الفيلم اللي بعده
                driver.navigate().back();

            }
        }
        @AfterAll
        public static void tearDown() {
// TODO: Close driver
            driver.quit();
        }
    }



