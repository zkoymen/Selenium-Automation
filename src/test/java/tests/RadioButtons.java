package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
    public static void main(String[] args) {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        // open the page
        driver.get("https://demoqa.com/radio-button");


        // Can also use label[for="yesRadio"]
        // Label is intercepting the button so they are added separately --> isSelected reads from the input, not label
        WebElement yesRadioBtnLabel = driver.findElement(By.cssSelector("label.custom-control-label[for=\"yesRadio\"]"));
        boolean isEnabled  = yesRadioBtnLabel.isEnabled();

        if (isEnabled) {
            System.out.println("Inside the if-statement");
            yesRadioBtnLabel.click();
        }

        WebElement yesRadioBtn = driver.findElement(By.id("yesRadio"));
        boolean isSelected = yesRadioBtn.isSelected();


        if (isSelected) {
            // Printing message
            WebElement output = driver.findElement(By.cssSelector("p.mt-3"));
            System.out.println(output.getText());
        }




    }
}
