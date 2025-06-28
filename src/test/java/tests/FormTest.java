package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {

    public static void main(String[] args) {

        // Identify driver
        System.setProperty("chromeDriver", "/drivers/chromedriver");

        // Create the driver
        WebDriver driver = new ChromeDriver();


        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();




        //Scroll down the page because adds intercept input form areas
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView()", submitBtn);


        // Find username
        // Warning: Inside the quotation marks
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();

        // Write on the user name form
        fullName.sendKeys("Abdulcebbar Abuzeddin");

        // Email Address
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys("abuzedinn1234@gmail.com");

        // Address
        // Get by CSS-selector
        WebElement currentAddress = driver.findElement(By.cssSelector("textarea.form-control[placeholder='Current Address'"));
        currentAddress.click();
        currentAddress.sendKeys("Mumbai, India");

        // Permanent address
        WebElement permAddress = driver.findElement(By.cssSelector("textarea.form-control[id='permanentAddress'"));
        permAddress.click();
        permAddress.sendKeys("Yakutistan, Russia");


        // Finally need is to click Submit button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();


        // Read texts -name and email
        WebElement nameText = driver.findElement(By.xpath("//div/p[@id='name']"));
        String name =nameText.getText();
        System.out.println(name);


        WebElement emailText = driver.findElement(By.xpath("//div/p[@id='email']"));
        String emailFetched = emailText.getText();
        System.out.println(emailFetched);





        // Implement scrolling to find elements
    }
}
