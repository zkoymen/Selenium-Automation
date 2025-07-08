package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowTabTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

        WebElement tabBtn = driver.findElement(By.id("tabButton"));
        tabBtn.click();

        WebElement windowBtn = driver.findElement(By.id("windowButton"));
        windowBtn.click();

        // Window handles
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());


        System.out.println(tabs.size());

        // Switch to newly opened tab
        driver.switchTo().window(tabs.get(1));


        //System.out.println((tabs.stream().toList()));


        System.out.println(driver.getCurrentUrl());

        // Wait a bit before closing the tab
        Thread.sleep(Duration.ofSeconds(2));

        // Close the tab or window --> not the driver
        // quit deletes the driver
        // !! --> it closes the latest opened one
        driver.close();




    }
}
