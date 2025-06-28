package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormCheckBoxTest {

    public static void main(String[] args) {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        // Fill out all form -exercise

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));


        firstName.sendKeys("Assad");
        lastName.sendKeys("Bashar");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("dethroned.king.of.syria@gmail.com");

        WebElement gender = driver.findElement(By.cssSelector("label[for=\"gender-radio-1\"]"));
        gender.click();

        WebElement phoneNo = driver.findElement(By.id("userNumber"));
        WebElement birthDate = driver.findElement(By.id("dateOfBirthInput"));

        phoneNo.sendKeys("0555699484800");

        // Problematic for now DYNAMIC ELEMENTS


        // birthDate.clear();
        // birthDate.sendKeys("11 Sep 1965");


        //WebElement subjects = driver.findElement(By.id(""))





        // Get 1st checkbox
//        WebElement sportCheckBox = driver.findElement(By.id("hobbies-checkbox-1"));
//        boolean isEnabled = sportCheckBox.isEnabled();
//        System.out.println(isEnabled);
//
//
//        if (isEnabled) {
//            try {
//                sportCheckBox.click();
//
//            } catch (ElementClickInterceptedException e) {
//
//                // If could not alternative is click on the label
//                WebElement hobbyLabel = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
//                hobbyLabel.click();
//                System.out.println("Inside the catch block");
//
//            }
//        }
//
//        boolean isSelected = sportCheckBox.isSelected();
//        System.out.println(isSelected);


    }
}
