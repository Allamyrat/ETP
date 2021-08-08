package StepDefinitions;

import Pages.OrderPage;
import Pages.SubscriptionPage;
import Utils.Basics;
import Utils.Driver;
import Utils.Waits;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class YourOrder_Step_definitions extends SubscriptionPage {
        Actions actions=new Actions(Driver.get());
        OrderPage orderPage=new OrderPage();
    @When("user is on Order window with selected {string} and {int}")
    public void user_is_on_Order_window_with_selected_and(String ProtocolType, Integer amount) throws InterruptedException {
        Basics basics=new Basics();
        basics.AddExchange(ProtocolType,amount);
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
        ConfirmPaymentButton.click();
    }

    @Then("Order window should include selected {string} and {int}")
    public void order_window_should_include_selected(String ProtocolType, Integer amount) throws InterruptedException {
        Thread.sleep(4000);

        actions.moveToElement(orderPage.OrderProtocolType).click().perform();
        Assert.assertTrue(orderPage.OrderProtocolType.getText().contains(ProtocolType));
        actions.moveToElement(orderPage.OrderSession).click().perform();
        Assert.assertTrue(orderPage.OrderSession.getText().contains(Integer.toString(amount)));
    }

    @Then("Pay Now price should be equal to Pay button price on Subscription page")
    public void pay_Now_price_should_be_equal_to_Pay_button_price_on_Subscription_page() {
        Assert.assertTrue(ConfirmButton.getText().contains(orderPage.payNowValue.getText()));

    }

    @Then("Next charge price should be equal to Monthly Subscription price on Subscription page")
    public void next_charge_price_should_be_equal_to_Monthly_Subscription_price_on_Subscription_page() {
        Assert.assertTrue(MonthlySubscriptionTotalPrice.getText().contains(orderPage.nextChargeValue.getText()));
    }

}
