package com.rafal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class CMSoftAsserts {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://chroma-tech-academy.mexil.it/static_page/");

        String title = driver.getTitle();
        String expectedTitle = "Chroma Tech Academy";

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://chroma-tech-academy.mexil.it/static_page/";

        WebElement actualInstructor = driver.findElement(By.xpath("/html/body/div[4]/div[1]/fieldset/table/tbody/tr[2]/td[1]"));
        String expectedInstructor = "John";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(title, expectedTitle, "Page title does not match expected value.");
        softAssert.assertEquals(currentUrl, expectedUrl, "Current URL does not match expected value.");
        softAssert.assertEquals(actualInstructor.getText(), expectedInstructor, "Actual instructor does not match expected value.");
        softAssert.assertAll();

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
