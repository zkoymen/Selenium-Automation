package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {

    public static void main(String[] args) {


        System.setProperty("chromeDriver" , "/drivers/chromedriver");

        // Initialize
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");
        //driver.manage().window().maximize();


        // css -selector
        // Find checkbox and click it
        String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";

        WebElement homeCheckBox = driver.findElement(By.cssSelector(homeCheckBoxCssValue));
        homeCheckBox.click();


        // The fields change after selecting the checkbox -you need to find it again
        homeCheckBox = driver.findElement(By.cssSelector(homeCheckBoxCssValue));

        String homeCheckBoxClassName = homeCheckBox.getAttribute("class");

        // Print class name
        System.out.println(homeCheckBoxClassName);

        // Check if box is checked
        if (homeCheckBoxClassName.equals("rct-icon rct-icon-check")) {
            System.out.println("Checkbox is checked");
        } else {
            System.out.println("Checkbox is  not checked");
        }

        // To be continued ...

    }
}
