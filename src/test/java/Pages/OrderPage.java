package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    public OrderPage(){ PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (xpath = "(//h2[@class='cb-item__name  cb-item__sub-group--left'])[2]")
    public WebElement OrderProtocolType;

    @FindBy(xpath = "(//h2[@class='cb-item__name  cb-item__sub-group--left'])[3]")
    public WebElement OrderSession;

    @FindBy(xpath = "(//div[@class='cb-bar__aside'])[1]")
    public WebElement payNowValue;

    @FindBy(xpath = "(//div[@class='cb-bar__aside'])[2]")
    public WebElement nextChargeValue;


}
