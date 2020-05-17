package day3.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsideGoogleSearch {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("techno study");

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));

        System.out.println("The number of techno study search results ==> " + list.size());

        for (int i = 0; i <list.size() ; i++) {
            System.out.println("Techno Study search results printed : " + list.get(i).getText());
            if(list.get(i).getText().contains("techno study")) {
                list.get(i).click();
            }
        }

        driver.quit();
    }
}
