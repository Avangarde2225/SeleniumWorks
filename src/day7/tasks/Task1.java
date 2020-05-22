package day7.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // write a function that takes a number, and clicks the "Add Element" button
    // given number of times, and then validate that given number of
    // "Delete" buttons is displayed
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        clickToValidate(driver,100);
    }

        public static void clickToValidate (WebDriver driver,int num){
            WebElement element = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

            for (int i = 0; i < num; i++) {
                element.click();
            }

            List<WebElement> list = driver.findElements(By.xpath("//button[@class='added-manually']"));
            if (list.size() == num) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }

        }


    }

