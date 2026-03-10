package com.rafal;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromaMexilDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.get("https://chroma-tech-academy.mexil.it/static_page/");

        String mainWindowHandle = chromeDriver.getWindowHandle();
        System.out.println("Main window handle: " + mainWindowHandle);
        
        WebElement dropdown1 = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("dropdown-class-example")
            )
        );
        Select select = new Select(dropdown1);
        select.selectByVisibleText("Option1");
        select.selectByIndex(2);
        select.selectByValue("option3");

        Actions actions = new Actions(chromeDriver);
        WebElement hoverOver = chromeDriver.findElement(By.id("mousehover"));
        actions.moveToElement(hoverOver).contextClick().perform();

        WebElement alertTextBox = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input#name")
            )
        );
        alertTextBox.sendKeys("Rafal");
        WebElement alertButton = chromeDriver.findElement(By.id("alertbtn"));
        alertButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        WebElement bootstrapDropDown = chromeDriver.findElement(By.xpath("/html/body/div[1]/div[1]/fieldset/div/button"));
        bootstrapDropDown.click();

        WebElement bootstrapOption2 = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[1]/fieldset/div/div/label[2]")
            )
        );
        bootstrapOption2.click();

        List<WebElement> dropDownOptions = chromeDriver.findElements(By.xpath("/html/body/div[1]/div[1]/fieldset/div/div/label"));
        for (WebElement option : dropDownOptions) {
            if(option.getText().equals("Option 3")) {
                option.click();
                break;
            }
        }

        WebElement openTabButton = chromeDriver.findElement(By.id("opentab"));
        openTabButton.click();

        Set<String> windowHandles = chromeDriver.getWindowHandles();
        for (String nextWindow : windowHandles) {
            chromeDriver.switchTo().window(nextWindow);
        }

        WebElement testAutomation = wait.until(
            ExpectedConditions.elementToBeClickable (By.xpath("/html/body/header/div/div[2]/div[1]/div/nav[1]/ul/li[2]/a")));
        testAutomation.click();

        chromeDriver.switchTo().window(mainWindowHandle);
        
        WebElement bootstrapDropDown3 = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[1]/fieldset/div/button")
            )
        );
        bootstrapDropDown3.click();

        chromeDriver.get("https://mdbootstrap.com/docs/standard/extended/multiselect");

        // Handle cookies
        WebElement cookieBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("accept_cookies_btn"))
        );
        cookieBtn.click();
        Thread.sleep(1000);

        // Find the FIRST multiselect dropdown on the page
        WebElement dropdownInput = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.select-wrapper input.select-input")
            )
        );

        // Scroll into view and click
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdownInput);
        Thread.sleep(500);
        dropdownInput.click();

        // Select options
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Two']")
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Five']")
            )
        ).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='One']")
            )
        ).click();

        //WebElement firstSelectedOption = select.getFirstSelectedOption();
        //System.out.println("First selected option: " + firstSelectedOption.getText());

        Thread.sleep(2000);
        chromeDriver.quit();
    }
}
