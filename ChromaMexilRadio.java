package com.rafal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromaMexilRadio {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        String url = "https://chroma-tech-academy.mexil.it/static_page/";
        
        chromeDriver.get(url);

        WebElement radio1 = chromeDriver.findElement(By.xpath("/html/body/div[2]/div[1]/fieldset/label[1]/input"));
        radio1.click();
        WebElement radio2 = chromeDriver.findElement(By.xpath("/html/body/div[2]/div[1]/fieldset/label[2]/input"));
        radio2.click();
        WebElement radio3 = chromeDriver.findElement(By.xpath("/html/body/div[2]/div[1]/fieldset/label[3]/input"));
        radio3.click();

    try {
        Thread.sleep(1000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    chromeDriver.quit();
    }
}
