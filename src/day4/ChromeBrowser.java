package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
       // driver.quit();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        //WebElement element = driver.findElement(By.cssSelector("input[placeholder='Please enter your Message']"));

        WebElement element = driver.findElement(By.cssSelector("input.form-control[type=text]")); //using . for class

        element.sendKeys("Personal message");

    }
}
