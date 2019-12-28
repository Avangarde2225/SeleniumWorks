package src.day3.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SimpleFormTask2 {
    // https://www.seleniumeasy.com/test/basic-first-form-demo.html
    // Fill in Two Input Fields with numbers, press the button and check result
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        Integer number1 = 123;
        Integer number2 = 456;

        WebElement inputField1 = driver.findElement( By.id( "sum1" ) );
        inputField1.sendKeys( number1.toString() );

        WebElement inputField2 = driver.findElement( By.id( "sum2" ) );
        inputField2.sendKeys( number2.toString() );


        List<WebElement> buttons = driver.findElements( By.tagName( "button" ) );
        for(WebElement button: buttons){
//            System.out.println(button.getText());
            if(button.getText().equals( "Get Total" )){
                button.click();
            }
        }
        WebElement display = driver.findElement( By.id( "displayvalue" ) );
        String text = display.getText();

        if(text.equals(String.valueOf(number1+number2))){
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

    }
}
