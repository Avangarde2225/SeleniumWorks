package src.day9;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalWindowClickProblem {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "http://the-internet.herokuapp.com/entry_ad" );
        Thread.sleep( 2000 );
        WebElement click = driver.findElement( By.id( "restart-ad" ) );
        click.click();

        try {
            click.click();
        } catch(ElementClickInterceptedException e){
            WebElement element = driver.findElement( By.cssSelector( ".modal-footer" ) ) ;
            element.click();
        }
        Thread.sleep(2000);
        click.click();
        click = driver.findElement( By.id( "restart-ad" ) ) ;
        click.click();

//        driver.findElement( By.id( "restart-ad" ) ).click();
//        driver.findElement( By.id( "restart-ad" ) ).click();

//        driver.quit();
    }
}
