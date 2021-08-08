package StepDefinitions;

import Pages.loginPage;
import Utils.Driver;
import Utils.dataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class login_Step_definitions extends loginPage {
    @Given("user is on Login page")
    public void user_is_on_Login_page() {
        String url=dataReader.get("Url");
        Driver.get().get(url);
    }

    @When("user enters credentials and clicks on Sign In button")
    public void user_enters_credentials_and_clicks_on_button() {
        username.sendKeys(dataReader.get("Username"));
        password.sendKeys(dataReader.get("Password"));
        signIn.click();
    }

    @Then("the system should navigate to Subscription page")
    public void the_system_should_navigate_to_Subscription_page() throws InterruptedException {
        Thread.sleep(4000);
        String actualUrl=Driver.get().getCurrentUrl();
        String expectedUrl="https://spa-dev.etpmarkets.com:3000/app/subscription";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @When("user enters invalid username")
    public void user_enters_following_credentials() {
        username.sendKeys("abctest");

    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);

    }

    @When("clicks on Sign In button")
    public void clicks_on_Sign_In_button() {
        signIn.click();
    }

    @Then("the system should display the invalid email error message")
    public void the_system_should_display_the_email_error_message() {
        Assert.assertTrue(invalidEmailError.isDisplayed());
    }

    @Then("the system should display the error message for entered {string}")
    public void the_system_should_display_the_error_message(String Password) throws InterruptedException {
        Thread.sleep(2000);
        if (Password.length() < 8) {
            Assert.assertTrue(passwordError.isDisplayed());
        } else {
            Assert.assertTrue(LoginError.isDisplayed());
        }
    }
}
