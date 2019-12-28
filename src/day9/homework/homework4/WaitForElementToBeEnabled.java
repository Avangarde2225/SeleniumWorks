package src.day9.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementToBeEnabled {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     *
     * click on "Enable" button
     * wait for <input> of type="text" to be enabled within 5 seconds
     * if <input> of type="text" is enabled print success
     * verify that <p> with id="message"  is visible and has text "It's enabled!"
     *
     * click on "Disable" button
     * wait for <input> of type="text" to be disabled within 5 seconds
     * if <input> of type="text" is disabled print success
     * verify that <p> with id="message"  is visible and has text "It's disabled!"
     *
     **/
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement enable = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enable.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        if (driver.findElement(By.xpath("//p[@id='message']")).getText().contains("enabled")) {
            System.out.println("enable: success");
        }
        else {
            System.out.println("enable: failure");
        }

        Thread.sleep(2000);

        WebElement disable = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        disable.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        if (driver.findElement(By.xpath("//p[@id='message']")).getText().contains("disabled")) {
            System.out.println("disable: success");
        }
        else {
            System.out.println("disable: failure");
        }

        Thread.sleep(3000);

        driver.quit();


    }
}
