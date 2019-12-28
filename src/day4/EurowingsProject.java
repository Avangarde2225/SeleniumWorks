package src.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EurowingsProject {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();

        driver.get("https://wingsavail.eurowings.com/#/login");

        driver.findElement(By.id("mat-input-0")).sendKeys("serdar.celebi@dlh.de");
        driver.findElement(By.id("mat-input-1")).sendKeys("istemi2225");

        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("button[role=menuitem]")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("mat-checkbox-1-input")).click();


    }
}
