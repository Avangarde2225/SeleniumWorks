package src.day9.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementVisibility {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     *
     * click on "Remove" button
     * wait for checkbox to disappear within 5 seconds
     * if checkbox disappears print success
     * verify that <p> with id="message"  is visible and has text "It's gone!"
     *
     * click on "Add" button
     * wait for checkbox to appear within 5 seconds
     * if checkbox appears print success
     * verify that <p> with id="message"  is visible and has text "It's back!"
     *
     **/

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement remove = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        remove.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/p")));

        if (driver.findElement(By.xpath("//form[@id='checkbox-example']/p")).getText().equalsIgnoreCase("it's gone!")) {
            System.out.println("remove message: success");
        }
        else {
            System.out.println("remove message: failure");
        }

        Thread.sleep(2000);

        WebElement add = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        add.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/p")));
        if (driver.findElement(By.xpath("//form[@id='checkbox-example']/p")).getText().equalsIgnoreCase("it's back!")) {
            System.out.println("add message: success");
        }
        else {
            System.out.println("add message: failure");
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
