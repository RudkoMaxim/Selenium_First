package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Task3 {
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
        List<WebElement> names= driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo.sc-124al1g-4.eeXMBo"));
        List<String> namesStr = names.stream().map(x->x.getText()).toList();
        System.out.println(namesStr);
        driver.findElement(By.xpath("//*[@class = \"checkmark\"] [text()='S']")).click();
        Thread.sleep(1000);
        List<WebElement> names2= driver.findElements(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo']"));
        List<String> namesStr2 = names2.stream().map(x->x.getText()).toList();
        System.out.println(namesStr2);
        Assert.assertNotEquals(namesStr, namesStr2, "Lists are equal");
        }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
