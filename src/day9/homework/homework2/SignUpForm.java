package src.day9.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpForm {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suler/IdeaProjects/selenium3/src/day9/homework/homework1/SignUpForm.html");

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("avangard2225");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@placeholder='Confirm Password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@placeholder='Enter Address']")).sendKeys("600 Getty Ave, Clifton, New Jersey");
        driver.findElement(By.id("option2")).click();
        driver.findElement(By.id("radio2")).click();
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).submit();


        String currentUrl = driver.getCurrentUrl();
        System.out.println( currentUrl );
    }
}
