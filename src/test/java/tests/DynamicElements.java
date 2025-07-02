package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicElements {

    public static void main(String[] args) {


        System.setProperty("chromeDriver", "/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement textEle = driver.findElement(By.xpath("//div/p[contains(text(), \"This text has random Id\")]"));
        System.out.println(textEle.getText());


        // Wait for 5 seconds for the btn to be clickable
        WebElement waitBtn = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(waitBtn));
        waitBtn.click();


        // Color changing button
        WebElement colorChangingBtn = driver.findElement(By.id("colorChange"));

        // Get class attribute to see if it is changes
        String className  = colorChangingBtn.getAttribute("class");
        System.out.println("Before changing color " + className);

        // This duration is the max waiting. If action occurs before that it will be executed auto
        // So if 15 sec is written but action occurs at 5 sec, it will take 5 sec and then close off
        WebDriverWait waitColor = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitColor.until(ExpectedConditions.attributeToBe(colorChangingBtn, "class", "mt-4 text-danger btn btn-primary"));
        colorChangingBtn.click();

        className  = colorChangingBtn.getAttribute("class");
        System.out.println("After changing color " + className);






        // Visible after 5 seconds button
        // You need to add wait stmt beforehand

        WebDriverWait waitVisible = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitVisible.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        WebElement visibleBtn = driver.findElement(By.id("visibleAfter"));

        visibleBtn.click();



    }
}
