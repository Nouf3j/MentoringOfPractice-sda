package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {

    public static void main(String[] args)throws InterruptedException {


        /*
        // TC – 03

// Expected Title
// Set Path of the Chrome driver
// Launch Chrome browser
// Open URL of Website
// Maximize Window
// Get Title of current Page
// Validate/Compare Page Title
// Close Browser
         */

        // WebDriverManager is better because it downloads and updates
        // the driver automatically

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
            Thread.sleep(1000);

            String expectedTitle = "CHECK24"; driver.get("https://check24.de");
            Thread.sleep(1000);

            driver.manage().window().maximize();
            Thread.sleep(1000);

            String titlePage = driver.getTitle();
            Thread.sleep(1000);

        if (titlePage.contains(expectedTitle)) {
            System.out.println("Passed test");
        } else {
            System.out.println("Failed test");
            String pageSource = driver.getPageSource();
            driver.close();
            driver.quit();
            System.out.println(pageSource);
        }

    }

            }









