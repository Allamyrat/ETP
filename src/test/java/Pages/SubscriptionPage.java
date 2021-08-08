package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubscriptionPage {

    public SubscriptionPage(){PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//span[text()=\"test\"]")
    public WebElement testButton;

    @FindBy(xpath = "(//a[text()='Subscription'])[1]")
    public WebElement SubscriptionButton;

    @FindBy(xpath = "//button[text()='Add Exchange']")
    public WebElement AddExchangeButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[4]/div[1]/div[2]/input[1]")
    public WebElement ProtocolTypeMenu;
/*
    @FindBy(xpath = "//div[contains(text(),'FIX')]")
    public List<WebElement> ProtocolType;
*/
    @FindBy(xpath = "//*[name()='svg']//*[name()='line' and @x1='12']")
    public WebElement plusSign;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement AddButton;

    @FindBy(xpath = "(//p[contains(text(),'FIX 4.4')])[1]")
    public WebElement ProtTypeListed;

    @FindBy(xpath = "//span[contains(text(),'Unpaid')]")
    public WebElement UnpaidPaymentStatus;

    @FindBy(xpath = "//button[contains(text(),'Pay')]")
    public WebElement ConfirmPaymentButton;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement ConfirmButton;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement Checkbox;

    @FindBy(xpath = "//span[@class='cb-button__text']")
    public WebElement ProceedToCheckout;

    @FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
    public WebElement AccountEdit;

    @FindBy(xpath = "(//div[contains(text(),'Edit')])[2]")
    public WebElement PaymentEdit;

    @FindBy(name = "given-name")
    public WebElement FirstName;

    @FindBy(name = "family-name")
    public WebElement LastName;

    @FindBy(name = "cc-given-name")
    public WebElement CCFirstName;

    @FindBy(name = "cc-family-name")
    public WebElement CCLastName;

    @FindBy(name = "cc-number")
    public WebElement CCNumber;

    @FindBy(xpath = "//div[contains(text(),'Valid Card')]")
    public WebElement ValidCard;

    @FindBy(xpath = "//div[contains(text(),'Verification Error Card')]")
    public WebElement VerificationErrorCard;

    @FindBy(xpath = "//div[contains(text(),'Transaction Error Card')]")
    public WebElement transactionErrorCard;

    @FindBy(xpath = "//label[contains(text(),'Expiry')]")
    public WebElement CCExpiry;

    @FindBy(xpath = "//label[contains(text(),'CVV')]")
    public WebElement CCCVV;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    public WebElement UpdateButton;

    @FindBy(id = "tos_agreed")
    public WebElement AgreeCheckBox;

    @FindBy(xpath = "//span[@class='cb-button__text']")
    public WebElement PayButton;

    @FindBy(id = "cb-header-title")
    public WebElement OrderHeaderTitle;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeSession;

    @FindBy(xpath = "//*[local-name()='svg'and @data-tip='Delete selected subscriptions']")
    public WebElement DeleteIcon;

    @FindBy(xpath = "//div[contains(text(),\"You don't have any active subscriptions\")]")
    public WebElement DeletionCompleteMessage;

    @FindBy (xpath = " //button[@class='sc-AykKE guaEXt']")
    public WebElement DeleteConfirmMessage;

    @FindBy(xpath = "(//button[text()='Confirm'])[2]")
    public WebElement DeleteConfirm;

    @FindBy(xpath = "//p[contains(text(),'Sessions:')]")
    public WebElement Sessions;

    @FindBy(xpath = "(//div[@class='sc-LzLvg iyuslm']//p)[2]")
    public WebElement CurrentPaymentValue;

    @FindBy(xpath = "(//span[@class='sc-fzXfQm cEJTuv'])[5]")
    public WebElement rightSubscriptionCurrentPay;

    @FindBy(xpath = "//div[@class='sc-LzLvh iyCOPv']//p)[2]")
    public WebElement leftSubscriptionCurrentPay;

    @FindBy(xpath = "//div[@class='cb-content']")
    public WebElement AccountInfoDisplayed;

    @FindBy(xpath = "//span[@class='cb-content__text']")
    public WebElement ccInfoDisplayed;

    @FindBy(xpath = "//div[@class='sc-LzLva ixvMMk subscription-right-section']")
    public WebElement MonthlySubscriptionColumn;

    @FindBy(xpath = "//div[@class='sc-LzLva ixvMMk subscription-right-section']//p[2]")
    public WebElement SubscriptionBasePrice;

    @FindBy(xpath = "(//div[@class='sc-LzLva ixvMMk subscription-right-section']//p[2])[2]")
    public WebElement SessionPrice;

    @FindBy(xpath = "(//div[@class='sc-LzLva ixvMMk subscription-right-section']//span[@class='sc-fzXfQm cEJTuv'])[2]")
    public WebElement MonthlySubscriptionTotalPrice;

    @FindBy(xpath = "//h1")
    public WebElement SubscriptionHeader;

    @FindBy(xpath ="(//label//input[@type='checkbox'])[1]")
    public WebElement TopCheckBox;

}
