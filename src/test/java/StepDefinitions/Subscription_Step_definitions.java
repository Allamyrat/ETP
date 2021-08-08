package StepDefinitions;

import Pages.SubscriptionPage;
import Pages.loginPage;
import Utils.Driver;
import Utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Subscription_Step_definitions extends SubscriptionPage {
    Actions actions=new Actions(Driver.get());
    @And("user logs into the system")
    public void user_logs_into_the_system() {
        loginPage loginPage=new loginPage();
        loginPage.Login();
    }

    @When("user hovers over on test")
    public void user_hovers_over_on_test() throws InterruptedException {
        Waits.waitForVisibility(testButton,4000);
        actions.moveToElement(testButton).perform();
    }

    @When("clicks on Subscription")
    public void clicks_on_Subscription() {
        SubscriptionButton.click();
    }

    @Then("user should be able to navigate to Subscription page")
    public void user_should_be_able_to_navigate_to_Subscription_page() {
        //System.out.println(Driver.get().getTitle());
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Subscription";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user clicks on AddExchange button")
    public void user_clicks_on_AddExchange_button() throws InterruptedException {
        Waits.waitForVisibility(AddExchangeButton,2000);
        AddExchangeButton.click();
        Thread.sleep(3000);
    }

    @Then("user selects a {string}")
    public void user_selects_a(String ProtocolType) {
        actions.moveToElement(ProtocolTypeMenu).click().perform();
        actions.moveToElement(Driver.get().findElement(By.xpath("//div[@class='sc-LzLtM kjUByV' and text()="+"\""+ProtocolType+"\""+"]"))).click().perform();

    }
    @Then("user selects session {int}")
    public void user_selects_session_amount(int amount) {
            for (int i = 0; i < amount; i++) {
                actions.moveToElement(plusSign).click().perform();
            }
        }
    @Then("verify that exchange can be added for selected session {int}")
    public void verify_that_exchange_can_be_added_for_selected_session(int amount) {
                actions.moveToElement(AddButton).perform();
                Assert.assertTrue(AddButton.isEnabled());
            }

    @Then("clicks on Add button")
    public void clicks_on_Add_button() {
        actions.moveToElement(AddButton).click().perform();
    }

    @Then("header should be {string}")
    public void header_should_be(String string) {
        Assert.assertEquals("Subscription",SubscriptionHeader);
    }
    @Then("left Subscription bar should match right Subscription bar for selected {string} and {int}")
    public void left_Subscription_bar_should_match_right_Subscription_bar(String ProtocolType, int amount) {

        String SessionsTotalPrice=SessionPrice.getText();

        String BasePrice=SubscriptionBasePrice.getText();

        String MonthlyTotalPrice=MonthlySubscriptionTotalPrice.getText();

        int MonthTotPr=Integer.parseInt(String.valueOf(MonthlyTotalPrice).substring(1,MonthlyTotalPrice.indexOf(".")));

        int SessionPr=Integer.parseInt(String.valueOf(SessionsTotalPrice).substring(1,SessionsTotalPrice.indexOf(".")));

        int BasePr=Integer.parseInt(String.valueOf(BasePrice).substring(1,BasePrice.indexOf(".")));

        int expectedTotalPrice=SessionPr+BasePr;

        int actualTotalPrice=MonthTotPr;

        Assert.assertTrue(MonthlySubscriptionColumn.getText().contains(ProtocolType));
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
        Assert.assertEquals(rightSubscriptionCurrentPay.getText(),leftSubscriptionCurrentPay.getText());
    }
/*
    @Then("{string} and price should be displayed correct with respect to {int} on Subscription Page")
    public void protocol_Type_and_price_should_be_displayed_correct_with_respect_to_amaount_on_Subscription_page(String ProtocolType,int amount) throws InterruptedException {
        Thread.sleep(2000);

        String SessionsTotalPrice=SessionPrice.getText();

        String BasePrice=SubscriptionBasePrice.getText();

        String MonthlyTotalPrice=MonthlySubscriptionTotalPrice.getText();

        int MonthTotPr=Integer.parseInt(String.valueOf(MonthlyTotalPrice).substring(1,MonthlyTotalPrice.indexOf(".")));

        int SessionPr=Integer.parseInt(String.valueOf(SessionsTotalPrice).substring(1,SessionsTotalPrice.indexOf(".")));

        int BasePr=Integer.parseInt(String.valueOf(BasePrice).substring(1,BasePrice.indexOf(".")));

        int expectedTotalPrice=SessionPr+BasePr;

        int actualTotalPrice=MonthTotPr;


        Assert.assertTrue(MonthlySubscriptionColumn.getText().contains(ProtocolType));
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
    }

 */

    @Then("payment status should be Unpaid")
    public void payment_status_should_be_Unpaid() {

        Assert.assertTrue(UnpaidPaymentStatus.isDisplayed());
    }

}
