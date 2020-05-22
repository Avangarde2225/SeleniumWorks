package day7.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();

        WebElement msgBeforeClick = driver.findElement(By.cssSelector("#normal-btn-success"));
        msgBeforeClick.click();

        WebElement msgAfterClick = driver.findElement(By.cssSelector(".alert-normal-success"));
        System.out.println(msgAfterClick.getText());

        WebElement button = driver.findElement(By.cssSelector(".alert-normal-success > button"));
        button.click();

        String text = msgAfterClick.getText().replace( button.getText(), "" ).trim();



        //driver.findElement(By.xpath("//*[@class='close']")).click();

        driver.quit();
    }
}
