package src.day7.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Delete" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        clickAndValidateButtons(driver, 100);

        deleteAndQuit(driver, 100);

        driver.quit();
    }



    private static void clickAndValidateButtons(WebDriver driver, int num) {
        WebElement btn = driver.findElement( By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < num; i++) {
            btn.click();
        }
        List<WebElement> list = driver.findElements(By.className("added-manually"));
        if (list.size() == num) {
            System.out.println("success!");
        }
        else
            System.out.println("fail!");
    }

    private static void deleteAndQuit(WebDriver driver, int num) {
        WebElement deleteBtn = driver.findElement( By.xpath("//*[@onclick='deleteElement()']"));
        for (int i = num; i > 0; i--) {
            deleteBtn.click();
        }
        List<WebElement> list = driver.findElements(By.className("added-manually"));
        if (list.size() == num) {
            System.out.println("success!");
        }
        else
            System.out.println("fail!");

    }

}

