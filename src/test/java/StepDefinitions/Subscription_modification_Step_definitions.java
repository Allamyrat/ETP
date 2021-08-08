package StepDefinitions;

import Pages.SubscriptionPage;
import Utils.Basics;
import Utils.Driver;
import Utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

import static org.junit.Assert.*;

public class Subscription_modification_Step_definitions extends SubscriptionPage {
    Actions actions=new Actions(Driver.get());

    @Then("navigate to Subscription Page")
    public void navigate_to_Subscription_Page() throws InterruptedException {
        Driver.get().navigate().to("https://spa-dev.etpmarkets.com:3000/app/subscription");
        Thread.sleep(3000);
    }
    @When("user selects a paid subscription on Subscription page")
    public void user_selects_a_paid_subscription_on_Subscription_page() throws InterruptedException {
        Basics basics=new Basics();
        basics.selectPaidSubscriptions();
    }


    @Then("user clicks on delete icon")
    public void user_clicks_on_delete_icon() {
        Waits.waitForVisibility(DeleteIcon,4000);
        DeleteIcon.click();
    }

    @And("clicks on Confirm button")
    public void clicks_on_Confirm_button() throws InterruptedException {
        ConfirmButton.click();
        Thread.sleep(2000);
    }
    @Then("the system should display the pop-up window")
    public void the_system_should_display_the_pop_up_window() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(DeleteConfirmMessage.isDisplayed());
    }

    @When("user clicks on Confirm button on the delete confirmation window")
    public void user_clicks_on_Confirm_button_on_the_delete_confirmation_window() throws InterruptedException {
        actions.moveToElement(DeleteConfirm).click().perform();
        Thread.sleep(3000);
    }

    @Then("the system should delete the Subscription")
    public void the_system_should_delete_the_Subscription() {
        assertTrue(DeletionCompleteMessage.isDisplayed());
    }

    @When("user clicks on plus sign on Sessions once")
    public void user_clicks_on_plus_sign_on_Sessions_once() throws InterruptedException {
        Thread.sleep(2000);
        //Waits.waitForVisibility(plusSign,3000);
        actions.moveToElement(plusSign).click().perform();
    }

    @Then("the number of sessions should be one more of {int}")
    public void the_number_of_sessions_should_be_one_more_of_amount(int amount) throws InterruptedException {
        Thread.sleep(1000);
     int increasedAmount=amount+1;
     String newAmount=Integer.toString(increasedAmount);
        assertTrue(Sessions.getText().contains(newAmount));
    }

    @Then("calculated Current Payment should be same with on Pay button")
    public void calculated_Current_Payment_should_be_same_with_on_Pay_button() throws InterruptedException {
        Thread.sleep(1000);

        assertTrue(ConfirmPaymentButton.getText().contains(CurrentPaymentValue.getText()));
    }
    @Then("user adds another Exchange with followings")
    public void user_adds_another_Exchange_with_followings(Map<String, String> options) throws InterruptedException {
        Thread.sleep(3000);
        String protocolType=options.get("ProtocolType");
        int sessionAmount=Integer.parseInt(String.valueOf(options.get("SessionAmount")));
        Basics basics=new Basics();
        basics.AddExchange(protocolType,sessionAmount);
        Waits.waitForVisibility(TopCheckBox,3000);
        actions.moveToElement(TopCheckBox).click().perform();
        ConfirmPaymentButton.click();
        Thread.sleep(2000);
    }
    @When("user adds Exchange with followings")
    public void user_adds_Exchange_with_followings(Map<String,String> options) {
        Waits.waitForVisibility(AddExchangeButton,2000);
        AddExchangeButton.click();
        int amount=Integer.parseInt(String.valueOf(options.get("SessionAmount")));
        actions.moveToElement(ProtocolTypeMenu).click().perform();
        actions.moveToElement(Driver.get().findElement(By.xpath("//div[@class='sc-LzLtM kjUByV' and text()="+"\""+options.get("ProtocolType")+"\""+"]"))).click().perform();
        for (int i = 0; i < amount; i++) {
            actions.moveToElement(plusSign).click().perform();
        }
    }
    @Then("Add button should be disabled")
    public void add_button_should_be_disabled() {
        actions.moveToElement(AddButton).perform();
        Assert.assertFalse(AddButton.isEnabled());
    }


}
