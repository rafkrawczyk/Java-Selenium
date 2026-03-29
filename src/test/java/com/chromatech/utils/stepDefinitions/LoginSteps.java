package com.chromatech.utils.stepDefinitions;

import com.chromatech.utils.WebDriverUtils;
import com.chromatech.utils.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.chromatech.utils.WebDriverUtils.driver;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page of {string}")
    public void the_user_is_on_the_login_page_of(String url) {
        driver.get(url);
    }

    @When("user enters username {string} in the username text box and enters password {string} in the password text box")
    public void user_enters_username_in_the_username_text_box_and_enters_password_in_the_password_text_box(String username, String password) {
        loginPage.getUsernameTextBox().sendKeys(username);
        loginPage.getPasswordTextBox().sendKeys(password);
    }

    @When("clicks the Sign In button")
    public void clicks_the_sign_in_button() {
        loginPage.getSignInButton().click();
    }

    @Then("the user is directed to the dashboard page with url {string}")
    public void the_user_is_directed_to_the_dashboard_page_with_url(String expected) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/section/div[5]/div/div/div[1]/div/div/a/span")));
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "DASHBOARD URL IS INCORRECT");
    }
}
