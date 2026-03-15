package com.rafal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CM_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://chroma-tech-academy.mexil.it/static_page/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Chroma Tech Academy";

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chroma-tech-academy.mexil.it/static_page/";

        WebElement actualInstructor = driver.findElement(By.xpath("/html/body/div[4]/div[1]/fieldset/table/tbody/tr[2]/td[1]"));
        String expectedInstructor = "John";

        try {
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }   
        
        try {
            Assert.assertEquals(currentUrl, expectedUrl, "Current URL does not match expected value.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Assert.assertEquals(actualInstructor.getText(), expectedInstructor, "Actual instructor does not match expected value.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
