package src.day9.homework.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class XPath {
    /**
     * Open "http://the-internet.herokuapp.com/login"
     *
     * using XPath:
     *      grab username from first <em> tag and store inside a String
     *      grab password from second <em> tag and store inside a String
     *      fill in username and password inputs with above username and password
     *      find <button> with type="submit" and click it
     *      find and verify text "Welcome to the Secure Area. When you are done click logout below."
     *      find "Log out" button and click it
     *      find and verify text "You logged out of the secure area!"
     * */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");

        driver.manage().window().maximize();

        String username = driver.findElements(By.xpath("//h4[@class='subheader']/em")).get(0).getText();
        String password = driver.findElements(By.xpath("//h4[@class='subheader']/em")).get(1).getText();

        // both are giving x as the text, not the actual.

        WebElement usernameBox = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();

        Thread.sleep(4000);

//        String loggedIn = driver.findElement(By.xpath("//div[@class='flash success']")).getText();
//        System.out.println(loggedIn);
//
      String logInMessageFromDataBase = "Welcome to the Secure Area. When you are done click logout below.";

        WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        String openingMessage= welcomeMessage.getText();

        if (openingMessage.equals(logInMessageFromDataBase)) {
            System.out.println("log in message: success");
        } else {
            System.out.println("log in message: failure");
        }

        String loggedOutMessageFromDataBase = "You logged out of the secure area!";

        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        logOut.click();

        Thread.sleep(2000);

        WebElement loggedOutMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div"));

        WebElement x = driver.findElement( By.xpath("//*[@id=\"flash\"]/a"));

        String signedOut = loggedOutMessage.getText().replace(x.getText(), "").trim();


        if (loggedOutMessageFromDataBase.equals(signedOut)) {
            System.out.println("logged out message: success");
        } else {
            System.out.println("logged out message: failure");
        }

        Thread.sleep(5000);
        driver.quit();


    }
}
