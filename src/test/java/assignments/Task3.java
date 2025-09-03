package assignments;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Go to the Amazon URL
        driver.get("https://www.amazon.com/");

        // Print the position and Size of the page
        System.out.println("Pos: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Adjust the position and Size of the page as desired
        Point newPos = new Point(200, 150);
        Dimension newSize = new Dimension(1024, 600);
        driver.manage().window().setPosition(newPos);
        driver.manage().window().setSize(newSize);

        // Test that the Page is in the position and Size uoy want
        if (driver.manage().window().getPosition().equals(newPos) &&
                driver.manage().window().getSize().equals(newSize)) {
            System.out.println("Passed");
        } else {
            System.out.println(" Failed");
        }
        //Close the page
        driver.quit();
    }

}
