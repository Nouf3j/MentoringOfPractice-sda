package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


    public class C02WindowsComments {
        public static void main(String[] args) throws InterruptedException {

   /*
       TC - 02

 1- Go to www.yahoo.com
 2-  Maximize Window
3- Go to www.amazon.com
4-  Maximize Window
5-  Navigate Back
6-  Navigate Forward
 7-Refresh The Page

*/

            WebDriver driver = new ChromeDriver();

            driver.navigate().to("https://www.linkedIn.com");


            //Maximize Window
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //Go to www.amazon.com
            driver.navigate().to("https://www.amazon.com");

            //Maximize Window
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //Navigate Back
            driver.navigate().back();
            Thread.sleep(3000);

            //Navigate Forward
            driver.navigate().forward();
            Thread.sleep(3000);

            //Refresh The Page
            driver.navigate().refresh();
            Thread.sleep(3000);


            driver.close();
            driver.quit();

        }
    }


