package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.lang.reflect.Field;

public class DownloadTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");

        WebElement downloadBtn = driver.findElement(By.id("downloadButton"));
        downloadBtn.click();

        // Check if it is downloaded or not
        String path = "C:\\Users\\zeyne\\Downloads";
        String fileName = "sampleFile.jpeg";

        // wait a bit --> system does not recognize newly downloaded file
        Thread.sleep(5000);

        isFileDownloaded(path, fileName);

    }

    public static boolean isFileDownloaded(String path, String fileName) {

        File file = new File(path);

        // I filtered and have only taken jpeg --> otherwise, it is too heavy
        // use lambda for filter func
        File[] files = file.listFiles(((dir, name) -> {
            return name.endsWith(".jpeg");
        }));

        for (int i = 0; i < files.length; i ++) {
            // find the file
            if (files[i].getName().equals(fileName)) {

                // delete to test repeatedly
                files[i].delete();
                System.out.println("Downloaded file!");
                return true;
            }
            System.out.println("inside the loop");
        }
        System.out.println("File is not downloaded or cannot be found :(");
        return false;

    }
}
