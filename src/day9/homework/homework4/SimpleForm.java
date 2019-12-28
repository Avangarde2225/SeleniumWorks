package src.day9.homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class SimpleForm {
    /**
     * open "https://ultimateqa.com/filling-out-forms/"
     * fill in et_pb_contact_form_0 with some random data
     * click on submit button of this form
     * check that text "Form filled out successfully" is displayed
     **/
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();

        List<WebElement> name = driver.findElements(By.xpath("//input[@placeholder='Name']"));
        List<WebElement> message = driver.findElements(By.xpath("//textarea[@placeholder='Message']"));

        String randomName = getRandomString(driver, 5);
        String randomMessage = getRandomString(driver, 80);

        for (int i = 0; i < name.size(); i++) {
            name.get(i).sendKeys(randomName);
            message.get(i).sendKeys(randomMessage);
        }

        Thread.sleep(3000);

        List<WebElement> submitButtons = driver.findElements(By.xpath("//button[@type='submit']"));
        submitButtons.get(0).click();

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//*[@id='et_pb_contact_form_0']/div/p"));
        String expected = "Form filled out successfully";

        if (expected.equals(text.getText().trim())) {
            System.out.println("text: success");
        } else {
            System.out.println("text: failure");
        }

        Thread.sleep(3000);
        driver.quit();
    }

    private static String getRandomString(WebDriver driver, int i) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomStr = new StringBuilder();

        for (int j = 0; j < i; j++) {
            int random = new Random().nextInt(letters.length());
            randomStr.append(letters.charAt(random));
        }
        return randomStr.toString();



    }
}
