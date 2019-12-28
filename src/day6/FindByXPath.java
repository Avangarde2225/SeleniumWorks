package src.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindByXPath {
    // https://www.seleniumeasy.com/test/input-form-demo.html
    // fill in the form using xpath by attribute,
    // by contains(),
    // by index,
    // also by child

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@name, 'name')]"));
        for (WebElement element:list ) {
            element.sendKeys("Name");


        }




    }
}
