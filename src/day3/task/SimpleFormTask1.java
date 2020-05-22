package day3.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SimpleFormTask1 {
    // https://www.seleniumeasy.com/test/basic-first-form-demo.html
    // Fill in Single Input Field with text, press the button and check result
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        Thread.sleep(3000);
        WebElement popUp= driver.findElement(By.linkText("No, thanks!"));
        popUp.click();

        WebElement msg = driver.findElement(By.id("user-message"));
        msg.sendKeys("This is a personal message");

//        WebElement showMessage = driver.findElement(By.tagName("button"));
//
//        System.out.println(showMessage.getText());
//        showMessage.click();

        List<WebElement> buttons = driver.findElements( By.tagName( "button" ) );
        for(WebElement button: buttons){
//            System.out.println(button.getText());
            if(button.getText().equals( "Show Message" )){
                button.click();
            }
        }


    }
}
