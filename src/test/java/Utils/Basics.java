package Utils;

import Pages.SubscriptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Basics extends SubscriptionPage {
    Actions actions=new Actions(Driver.get());
    public void AddExchange(String Type, int amount){
        Waits.waitForVisibility(AddExchangeButton,2000);
        AddExchangeButton.click();
        actions.moveToElement(ProtocolTypeMenu).click().perform();
        actions.moveToElement(Driver.get().findElement(By.xpath("//div[@class='sc-LzLtM kjUByV' and text()="+"\""+Type+"\""+"]"))).click().perform();
        for (int i = 0; i < amount; i++) {
            actions.moveToElement(plusSign).click().perform();
        }
        actions.moveToElement(AddButton).click().perform();
    }

    public void selectPaidSubscriptions() throws InterruptedException {
        AddExchange("FIX 4.4",2);
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
        ConfirmPaymentButton.click();
        Thread.sleep(2000);
        actions.moveToElement(ProceedToCheckout).click().perform();
        Thread.sleep(2000);
        actions.moveToElement(AgreeCheckBox).click().perform();
        actions.moveToElement(PayButton).click().perform();
        Thread.sleep(7000);
        Driver.get().navigate().to("https://spa-dev.etpmarkets.com:3000/app/subscription");
        Waits.waitForVisibility(Checkbox,3000);
        actions.moveToElement(Checkbox).click().perform();
    }

    public String getUrl(){
        String currentUrl=Driver.get().getCurrentUrl();

        return currentUrl;
    }

}
