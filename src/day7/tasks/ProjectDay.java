package day7.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProjectDay {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/en");

        List<WebElement> list = driver.findElements(By.cssSelector("[class='dropdown-menu dropdown-menu-right show'] a"));
        for (WebElement element : list) {
            element.click();
        }

    }

    }
