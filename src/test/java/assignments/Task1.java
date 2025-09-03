package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
   //craete main method
    public static void main(String[] args) {


        //Create chromeDeiver
        WebDriver driver = new ChromeDriver() ;
        // open google home page
        driver.navigate().to("https://www.google.com");

           //Get Title on page

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);


        //Get Current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //Close /Quite the browser
        driver.close();
        driver.quit();


    }



}
