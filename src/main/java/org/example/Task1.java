package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task1 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void assertEquals() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/main/div/div[1]/button")).click();
        WebElement actualTitle = driver.findElement(By.xpath("//*[@class=\"sc-124al1g-4 eeXMBo\"][1]"));
        WebElement expectedTitle = driver.findElement(By.xpath("//*[@class=\"sc-11uohgb-2 elbkhN\"]"));
        Assert.assertEquals(actualTitle.getText(), expectedTitle.getText());
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}