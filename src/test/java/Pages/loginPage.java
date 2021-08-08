package Pages;

import Utils.Driver;
import Utils.dataReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(name = "email")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signIn;

    @FindBy (xpath = "//div[contains(text(),'Login error')]")
    public WebElement LoginError;

    @FindBy(xpath = "//div[contains(text(),'At least 8 character')]")
    public WebElement passwordError;

    @FindBy(xpath = "//div[contains(text(),'Email invalid')]")
    public WebElement invalidEmailError;

    public void Login(){
        Driver.get().get(dataReader.get("Url"));
        username.sendKeys(dataReader.get("Username"));
        password.sendKeys(dataReader.get("Password"));
        signIn.click();
    }

}
