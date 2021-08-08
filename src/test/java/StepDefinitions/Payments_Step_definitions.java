package StepDefinitions;

import Pages.PaymentsForSubscription;
import Pages.SubscriptionPage;
import Utils.Basics;
import Utils.Driver;
import Utils.Subscriptions;
import Utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Payments_Step_definitions extends SubscriptionPage {
        Actions actions=new Actions(Driver.get());
    String firstname="Jason";
    String lastname="Jones";
    @Given("user adds exchange with {string} and {int} of sessions")
    public void user_adds_exchange_with_and_amount_of_sessions(String ProtocolType,int amount) {
        Waits.waitForVisibility(AddExchangeButton,2000);
        AddExchangeButton.click();
       // Thread.sleep(3000);
        actions.moveToElement(ProtocolTypeMenu).click().perform();
        actions.moveToElement(Driver.get().findElement(By.xpath("//div[@class='sc-LzLtM kjUByV' and text()="+"\""+ProtocolType+"\""+"]"))).click().perform();
        for (int i = 0; i < amount; i++) {
            actions.moveToElement(plusSign).click().perform();
        }
        actions.moveToElement(AddButton).click().perform();
    }

    @When("user selects exchange subscription")
    public void user_selects_exchange_subscription() {
        Waits.waitForVisibility(Checkbox,5000);
       actions.moveToElement(Checkbox).click().perform();
        assertTrue(Checkbox.isSelected());
    }

    @And("user clicks on ConfirmPay button")
    public void clicks_on_ConfirmPay_button() throws InterruptedException {
        ConfirmPaymentButton.click();
        Thread.sleep(2000);
    }

    @Then("System should display Order window")
    public void system_should_display_Order_window() throws InterruptedException {
        Thread.sleep(3000);
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Chargebee Checkout";
        assertEquals(expectedTitle,actualTitle);

        Driver.get().navigate().back();
        actions.moveToElement(removeSession).click().perform();
        Thread.sleep(3000);
    }

    @When("user confirms an exchange subscription for payment")
    public void user_confirms_an_exchange_subscription_for_payment() throws InterruptedException {
        Basics basics=new Basics();
        basics.AddExchange("FIX 4.2",1);
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
        ConfirmPaymentButton.click();
        Thread.sleep(2000);
    }
   /* @When("user confirms an exchange subscription for payment with following options")
    public void user_confirms_an_exchange_subscription_for_payment_with_following_options(io.cucumber.datatable.DataTable dataTable) {
        List<Subscriptions> subscriptionsList=dataTable.asList(Subscriptions.class);
        for (Subscriptions subscriptions : subscriptionsList) {
            Basics basics=new Basics();
            basics.AddExchange(subscriptions.getProtocolType());
        }

    }

    */

    @When("user confirms an exchange subscription for payment with following options")
    public void user_confirms_an_exchange_subscription_for_payment_with_following_options(Map<String,String> options) throws InterruptedException {
        String protocolType=options.get("ProtocolType");
        int sessionAmount=Integer.parseInt(String.valueOf(options.get("SessionAmount")));
        Basics basics=new Basics();
        basics.AddExchange(protocolType,sessionAmount);
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
        ConfirmPaymentButton.click();
        Thread.sleep(2000);

    }

    @When("user clicks on Proceed to Checkout on the Order window")
    public void user_clicks_on_Proceed_to_Checkout_on_Order_window() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(ProceedToCheckout).click().perform();

    }
    @Then("System should display Complete order window")
    public void system_should_display_Complete_order_window() throws InterruptedException {
        Thread.sleep(2000);
        Basics basics=new Basics();
        Assert.assertTrue(basics.getUrl().contains("checkout/review"));
    }

    @When("user is on Complete Order window")
    public void user_is_on_Complete_Order_window() throws InterruptedException {
        Basics basics=new Basics();
        basics.AddExchange("FIX 4.2",1);
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
        ConfirmPaymentButton.click();
        Thread.sleep(3000);
        actions.moveToElement(ProceedToCheckout).click().perform();

    }

    @When("user clicks on edit Account")
    public void user_clicks_on_edit_Account() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(AccountEdit).click().perform();
    }


    @Then("user enters account informaton")
    public void user_enters_account_informaton() throws InterruptedException {
        actions.moveToElement(FirstName).click();
        FirstName.clear();
        Thread.sleep(1000);
        actions.moveToElement(FirstName).click().sendKeys("Jason").build().perform();
        Thread.sleep(1000);
        actions.moveToElement(LastName).click();
        LastName.clear();
        Thread.sleep(1000);
        actions.moveToElement(LastName).click().sendKeys("Jones").perform();

    }
    @Then("clicks on Update button")
    public void clicks_on_Update_button() {
        actions.moveToElement(UpdateButton).click().perform();
    }

    @Then("entered account info should be displayed on Order window")
    public void entered_account_info_should_be_displayed_on_Order_window() {
        Waits.waitForVisibility(AccountInfoDisplayed,2000);
        assertTrue(AccountInfoDisplayed.getText().contains(firstname));
        assertTrue(AccountInfoDisplayed.getText().contains(lastname));
    }

    @Then("entered credit card info should be displayed on Order window")
    public void entered_credit_card_info_should_be_displayed_on_Order_window() {
        Waits.waitForVisibility(ccInfoDisplayed,2000);
        assertTrue(ccInfoDisplayed.getText().contains("ending 1111"));
    }

    @When("user clicks on edit Payment")
    public void user_clicks_on_edit_Payment() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(PaymentEdit).click().perform();
    }

    @Then("user enters credit card information")
    public void user_enters_credit_card_information() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(CCFirstName).click().sendKeys(firstname).perform();
        actions.moveToElement(CCLastName).click().sendKeys(lastname).perform();
        actions.moveToElement(CCNumber).click().moveToElement(ValidCard).click().build().perform();
    }
    @Then("the system should display Complete Order window")
    public void the_system_should_display_Complete_Order_window() {
       assertTrue(Driver.get().getCurrentUrl().contains("checkout/review"));

        Driver.get().navigate().to("https://spa-dev.etpmarkets.com:3000/app/subscription");
        actions.moveToElement(removeSession).click().perform();
    }


    @Then("user checks the Agreement checkbox")
    public void user_checks_the_Agreement_checkbox() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(AgreeCheckBox).click().perform();
        assertTrue(AgreeCheckBox.isSelected());
    }

    @Then("clicks on Pay button")
    public void clicks_on_Pay_button() throws InterruptedException {
        actions.moveToElement(PayButton).perform();
        Assert.assertTrue(PayButton.isEnabled());
        actions.moveToElement(PayButton).click().perform();
        Thread.sleep(3000);
    }

    @Then("System should successfully open Subscription")
    public void system_should_successfully_open_Subscription() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(Driver.get().getCurrentUrl().contains("Success"));
    }
}
