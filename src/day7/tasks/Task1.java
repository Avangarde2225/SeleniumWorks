package src.day7.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // write a function that takes a number, and clicks the "Add Element" button
    // given number of times, and then validate that given number of
    // "Delete" buttons is displayed
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


    }
}
