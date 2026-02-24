package com.rafal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromaMexilLogin {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        //WebDriver firefoxDriver = new FirefoxDriver();
        //WebDriver edgeDriver = new EdgeDriver();
        
        String url = "https://chroma.mexil.it/site/login";
        
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();
        chromeDriver.get(url);
        
        WebElement forgotPasswordLink = chromeDriver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        WebElement emailField = chromeDriver.findElement(By.xpath("//*[@id='form-username']"));
        emailField.sendKeys("general@teacher.com");
        
        WebElement adminLogin = chromeDriver.findElement(By.partialLinkText("Admin Log"));
        adminLogin.click();
        
        WebElement userField = chromeDriver.findElement(By.id("form-username"));
        userField.sendKeys("general@teacher.com");
        
        //WebElement passwordField = chromeDriver.findElement(By.name("password"));
        //WebElement passwordField = chromeDriver.findElement(By.cssSelector("#form-password"));
        
        WebElement passwordField = chromeDriver.findElement(By.cssSelector("[class='form-password form-control']"));
        passwordField.sendKeys("123456");        
        
        WebElement loginButton = chromeDriver.findElement(By.className("btn"));
        loginButton.click();
        
        String title = chromeDriver.getTitle();
        System.out.println("Page title is: " + title);
        
        chromeDriver.quit();
        
        /*firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().deleteAllCookies();        
        firefoxDriver.get(url);
        firefoxDriver.quit();
        
        edgeDriver.manage().window().maximize();
        edgeDriver.manage().deleteAllCookies();
        edgeDriver.get(url);
        edgeDriver.quit();*/
    }    
}
