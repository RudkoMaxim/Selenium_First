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


public class Task4 {
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
        WebElement firstElement = driver.findElement(By.xpath("//*[@class = \"sc-ebmerl-4 iliWeY\"]"));
        String firstText = firstElement.getText();
        System.out.println(firstText);
        String[] stringsArray = firstText.split(" ");
        System.out.println(stringsArray[0]);
        driver.findElement(By.xpath("//*[@class = \"checkmark\"] [text()='S']")).click();
        Thread.sleep(1000);
        String secondText = firstElement.getText();
        System.out.println(secondText);
        String[] stringsArray2 = secondText.split(" ");
        System.out.println(stringsArray2[0]);
        Assert.assertTrue(stringsArray[0] != stringsArray2[0], "Lists not equal");
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}



