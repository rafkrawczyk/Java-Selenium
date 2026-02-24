package com.rafal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromaMexilCheckbox {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        String url = "https://chroma-tech-academy.mexil.it/static_page/";
        
        chromeDriver.get(url);

        WebElement checkbox1 = chromeDriver.findElement(By.xpath("//input[@value='option1']"));
        checkbox1.click();
        WebElement checkbox2 = chromeDriver.findElement(By.xpath("//input[@value='option2']"));
        checkbox2.click();
        WebElement checkbox3 = chromeDriver.findElement(By.xpath("//input[@value='option3']"));
        checkbox3.click();

    try {
        Thread.sleep(1000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    chromeDriver.quit();
    }
}
