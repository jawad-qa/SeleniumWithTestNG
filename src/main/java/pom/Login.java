package pom;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class Login extends BaseClass {
    @FindBy(css="input[placeholder='Username']")
    public WebElement userName;

    @FindBy(css="input[placeholder='Password']")
    public WebElement password;

    @FindBy(css="button[type='submit']")
    public WebElement submitButton;

    @FindBy(css="a[href=\'/web/index.php/dashboard/index\'] span")
    public WebElement dashboard;

    public void loginUser(String enterUser, String enterPassword)
     {
        Utils.waitForVisibility(userName);
        userName.sendKeys(enterUser);
        password.sendKeys(enterPassword);
        submitButton.click();
        Utils.waitForVisibility(dashboard);
    }
}
