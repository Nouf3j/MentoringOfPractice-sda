package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01NavigateBackAndForward {

    public static void main(String[] args) throws InterruptedException {

/*
        // TC - 01

   Invoke Chrome Browser
   Navigate to URL: https://www.w3schools.com/
   Navigate to URL: https://stackoverflow.com/
   Come back to the w3schools using the back command.
   Again go back to the stackoverflow website using forward command
   Refresh the Browser using refresh command.
  Close the Browser.

*/
        //Invoke Chrome Browser
        WebDriver driver = new ChromeDriver() ;

        //Navigate to URL: https://www.w3schools.com/
        driver.navigate().to("https://www.w3schools.com");

        Thread.sleep(3000);

        //Navigate to URL: https://stackoverflow.com/
        driver.get("https://stackoverflow.com");

        //Come back to the w3schools using the back command.
        driver.navigate().back();
        Thread.sleep(1000);  // use this to see ,  because the procce fast , but the sleep it is use for bugs


        //Again go back to the stackoverflow website using forward command
        driver.navigate().forward();
        Thread.sleep(1000);

        //refresh the Browser using refresh command.
        driver.navigate().refresh();
        Thread.sleep(1000);




        driver.close(); // to close the current tap
        driver.quit();  //to close all tap + end the session

    }
}

