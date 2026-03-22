package com.chromatech.utils.stepDefinitions;

import com.chromatech.utils.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {
    @Given("the user is on the login page of {string}")
    public void the_user_is_on_the_login_page_of(String url) {
        WebDriverUtils.driver.get(url);
    }

    @When("user enters username {string} in the username text box and enters password {string} in the password text box")
    public void user_enters_username_in_the_username_text_box_and_enters_password_in_the_password_text_box(String username, String password) {
        WebDriverUtils.driver.findElement(By.id("form-username")).sendKeys(username);
        WebDriverUtils.driver.findElement(By.id("form-password")).sendKeys(password);
    }

    @When("clicks the Sign In button")
    public void clicks_the_sign_in_button() {
        WebDriverUtils.driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/form/button")).click();
    }

    @Then("the user is directed to the dashboard page with url {string}")
    public void the_user_is_directed_to_the_dashboard_page_with_url(String expected) {
        String actual = WebDriverUtils.driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "DASHBOARD URL IS INCORRECT");
    }
}
