package src.day9.homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * open SignUpForm.html
 * store values that you will use inside some Strings
 * fill in your data inside the all input elements using Strings above
 * submit the form
 * get URL
 * parse values that was submitted
 * validate parsed values with stored values above
 */

public class SignUpFormSubmissionValidation {
    /**
     * open SignUpForm.html
     * store values that you will use inside some Strings
     * fill in your data inside the all input elements using Strings above
     * submit the form
     * get URL
     * parse values that was submitted
     * validate parsed values with stored values above
     */

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suler/IdeaProjects/selenium3/src/day9/homework/homework1/SignUpForm.html");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//*[@type='text']"));
        String myUserName = "avangard2225";
        userName.sendKeys(myUserName);

        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        String myPassword = "123456789";
        password.sendKeys(myPassword);

        WebElement confirmPassword = driver.findElement(By.xpath("//*[@name='Confirm Password']"));
        confirmPassword.sendKeys("123456789");

        WebElement address = driver.findElement(By.name("Address"));
        String myAddress = "600 Getty Ave, Clifton, NJ";
        address.sendKeys(myAddress);

        WebElement dropdown = driver.findElement(By.id("option2"));
        dropdown.click();

        WebElement radioButton = driver.findElement(By.id("female"));
        radioButton.click();

        WebElement checkbox = driver.findElement(By.name("checkbox"));
        checkbox.click();

        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.submit();

        String url = driver.getCurrentUrl();
        parseUrl(driver, url);

        if (url.contains(myUserName)) {
            System.out.println("username: success");
        }
        if (url.contains(myPassword)) {
            System.out.println("password: success");
        }
        if (url.contains(myAddress.substring(0, 3))) {
            System.out.println("address: success");
        } else
            System.out.println("fail!");

        Thread.sleep(2000);
        driver.quit();
    }

    private static void parseUrl(WebDriver driver, String url) throws MalformedURLException {
        URL myUrl = new URL(url);
        String sentKeys = myUrl.getQuery();
        for (String str : sentKeys.split("&")) {
            System.out.println(str);
        }
    }
}

