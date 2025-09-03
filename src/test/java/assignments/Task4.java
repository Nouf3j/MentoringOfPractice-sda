package assignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;


public class Task4 {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://www.google.com/");

        // Maximize the window
        driver.manage().window().maximize();

        //Print the position and Size of the page
        System.out.println("Maximized -> Pos: " + driver.manage().window().getPosition() +
                " Size: " + driver.manage().window().getSize());

        // Minimize the page
        driver.manage().window().minimize();

        // Wait 5 seconds in the icon state and maximize the page
        Thread.sleep(5000);
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state
        System.out.println("Re-Maximized -> Pos: " + driver.manage().window().getPosition() +
                " Size: " + driver.manage().window().getSize());

        // Make the page fullscreen
        driver.manage().window().fullscreen();


        // Close the Browser
        driver.quit();
    }
}