package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ClickTypes {

    public static void main(String[] args) {

        System.setProperty("chromeDriver" , "/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");

        // Double click button
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        // Actions class to perform many operations
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBtn).perform();

        // Get output text
        WebElement outputText = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(outputText.getText());

        // Right click button
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

        // ** No need for a new action object tho
        // To perform right-click a new action object
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(rightClickBtn).perform();

        // Print the message
        outputText = driver.findElement(By.id("rightClickMessage"));
        System.out.println(outputText.getText());





    }
}
