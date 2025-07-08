package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.stream.events.StartDocument;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindowTabTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");


        // Capture main window for future operations
        String mainHandle = driver.getWindowHandle();

        WebElement tabBtn = driver.findElement(By.id("tabButton"));
        tabBtn.click();

        WebElement windowBtn = driver.findElement(By.id("windowButton"));
        windowBtn.click();


        // this is a set and not guaranteed to be ordered like --> main, tab, window
        // thus --> remove main and close them in an order
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        System.out.println(tabs.size());
        tabs.remove(mainHandle);



        for(String handle : tabs) {
            driver.switchTo().window(handle);
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(Duration.ofSeconds(2));        // or use(2_000) as 2 seconds
            driver.close();
        }

        // Get to main handle
        driver.switchTo().window(mainHandle);

    }
}
