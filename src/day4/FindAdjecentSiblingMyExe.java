package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAdjecentSiblingMyExe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://automationpractice.com/index.php?controller=authentication&back=my-account" );
        WebElement firstElement = driver.findElement( By.cssSelector( ".form-group" ) );

        System.out.println(firstElement.getAttribute( "outerHTML" ));
        System.out.println("---------------------------------------");
        WebElement siblingElement = driver.findElement( By.cssSelector( ".form-group + p" ) );

        System.out.println(siblingElement.getAttribute( "outerHTML" ));
        driver.quit();
    }
}
