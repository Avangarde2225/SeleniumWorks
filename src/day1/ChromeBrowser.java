package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.techno.study/" );
        Thread.sleep(5000);
    }
}
