package com.rafal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CM_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://chroma-tech-academy.mexil.it/static_page/");

        Actions actions = new Actions(driver);

        WebElement hoverOver = driver.findElement(By.id("mousehover"));
        actions.moveToElement(hoverOver).contextClick().perform();

        js.executeScript("arguments[0].scrollIntoView(true);", hoverOver);

        List<WebElement> links = driver.findElements(By.tagName("a"));  
        System.out.println("Number of links: " + links.size());

        for (WebElement link : links) {
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }
        
        Thread.sleep(2000);
        driver.quit();
    }
}
