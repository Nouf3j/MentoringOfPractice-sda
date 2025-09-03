package assignments;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task2 {

    public static void main(String[] args) {
        //  Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        try {
            //  Go to YouTube
            driver.get("https://www.youtube.com/");

            //  Verify the page title contains the word video
            String title = driver.getTitle().toLowerCase();
            if (title.contains("video")) {
                System.out.println("Test Passed: Title contains 'video'");
            } else {
                System.out.println("Test Failed: Title does not contain 'video'");
            }

        } finally {
            // Close the driver
            driver.quit();
        }











    }

}


