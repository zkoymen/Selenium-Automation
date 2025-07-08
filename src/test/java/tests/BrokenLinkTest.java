package tests;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class BrokenLinkTest {

    public static void main(String[] args) throws IOException {

        System.setProperty("chromeDriver", "/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");


        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl = brokenImage.getAttribute("src");


        WebElement brokenLink = driver.findElement(By.xpath("//div/a[contains(text(), \"Broken\")]"));
        String brokenLinkUrl  =brokenLink.getAttribute("href");

        // Create a client
        HttpClient client = HttpClientBuilder.create().build();

        // Create a GET request to that broken image source link
        HttpGet getRequest = new HttpGet(brokenImageUrl);
        HttpResponse response = client.execute(getRequest);

        // Get the status code from the response
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        System.out.println(brokenImageUrl);

        // for the broken link this time --> not the image
        getRequest = new HttpGet(brokenLinkUrl);
        response = client.execute(getRequest);

        statusCode = response.getStatusLine().getStatusCode();

        // Will give internal error code --> 500
        System.out.println(statusCode);



    }
}
