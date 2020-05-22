package src.day9.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SignUpFormSubmissionParsing {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     * submit the form
     * get URL
     * parse values that was submitted and print them out
     * hint: https://examples.javacodegeeks.com/core-java/net/url/parse-url-example/
     * like nameOfTheInput = valueOfTheInput
     */
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suler/IdeaProjects/selenium3/src/day9/homework/homework1/SignUpForm.html");

        WebElement text = driver.findElement(By.xpath("//*[@type='text']"));
        text.sendKeys("avangard2225");

        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("123456789");

        WebElement confirmPassword = driver.findElement(By.xpath("//*[@name='Confirm Password']"));
        confirmPassword.sendKeys("123456789");

        WebElement address = driver.findElement(By.name("Address"));
        address.sendKeys("600 Getty Ave, Clifton, New Jersey");

        WebElement dropdown = driver.findElement(By.id("option2"));
        dropdown.click();

        WebElement radioButton = driver.findElement(By.id("female"));
        radioButton.click();

        WebElement checkbox = driver.findElement(By.name("checkbox"));
        checkbox.click();

        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.submit();

//        String value1 = text.getAttribute( "value" );
//        String value2 = password.getAttribute( "value" );
//        String value3 = confirmPassword.getAttribute( "value" );
//        String value4 = address.getAttribute( "value" );
//        String value5 = dropdown.getAttribute( "value" );
//        String value6 = radioButton.getAttribute( "value" );
//        String value7 = checkbox.getAttribute( "value" );
//        String value8 = submitButton.getAttribute( "value" );
//
//        System.out.println( value1 );
//        System.out.println( value2 );
//        System.out.println( value3 );
//        System.out.println( value4 );
//        System.out.println( value5 );
//        System.out.println( value6 );
//        System.out.println( value7 );
//        System.out.println( value8 );

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        parseUrl(driver, currentUrl);
    }

    public static void parseUrl(WebDriver driver, String currentUrl) throws MalformedURLException {
        URL myUrl = new URL(currentUrl);
        String sentKeys = myUrl.getQuery();
        for (String str : sentKeys.split("&")) {
            System.out.println(str);
        }
    }
}
