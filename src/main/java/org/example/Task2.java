package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class Task2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void assertEquals() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(1000);
        List<WebElement> btnList = driver.findElements(By.xpath("//*[text()='Add to cart']"));
        for (WebElement element1 : btnList) {
            Thread.sleep(100);
            driver.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']")).click();
            Thread.sleep(100);
            element1.click();
        }
        List<WebElement> names= driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo.sc-124al1g-4.eeXMBo"));
        List<String> namesStr = names.stream().map(x->x.getText()).toList();
        System.out.println(namesStr);
        List<WebElement> names2= driver.findElements(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN']"));
        List<String> namesStr2 = names2.stream().map(x->x.getText()).toList();
        System.out.println(namesStr2);
        Assert.assertEquals(namesStr, namesStr2, "Names are not equal");
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
