package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C04 {
    public static void main(String[] args) {


        // TC - 04
        WebDriver driver = new ChromeDriver();


        // Go to the w3school URL : https://www.w3schools.com/
        driver.navigate().to("https://www.w3schools.com");

        // Print the position and size of the page.
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        System.out.println("height = " + height);
        System.out.println("width = " + width);

        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);


        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(100, 16));
        driver.manage().window().setSize(new Dimension(900, 700));
// Test that the page
    }
}