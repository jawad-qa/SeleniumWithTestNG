package pom;
import base.BaseClass;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Utils;
import org.openqa.selenium.support.ui.Select;

public class Admin extends BaseClass{
    @FindBy(css="a[href='/web/index.php/admin/viewAdminModule'] span")
    public WebElement adminMenuButton;

    @FindBy(css="span h6:first-of-type")
    public WebElement adminHeading;

    @FindBy(css="div[class=\"orangehrm-header-container\"] button i")
    public WebElement addButton;

    @FindBy(css="div[class='orangehrm-card-container'] h6")
    public WebElement addUserText;

    @FindBy(css ="#app > div:first-of-type > div:nth-of-type(2) > div:nth-of-type(2) > div > div > form > div:first-of-type > div > div:first-of-type > div > div:nth-of-type(2) > div > div > div:first-of-type")
    public WebElement selectUserRole;

    @FindBy(xpath ="//*[@role='listbox']//*[text()='Admin']")
    public WebElement adminRole;

    @FindBy(css="input[placeholder='Type for hints...']")
    public WebElement employeeName;

    @FindBy(xpath ="//*[@role='listbox']//*[text()='Paul twiggs Collings']")
    public WebElement selectEmployee;

    @FindBy(xpath ="//*[@id=\"app\"]//div[3]/div/div[2]/div/div/div[1]")
    public WebElement selectStatus;

    @FindBy(xpath ="//*[@role='listbox']//*[text()='Enabled']")
    public WebElement enabledStatus;

    @FindBy(xpath ="//*[@id=\"app\"]//div[4]/div/div[2]/input")
    public WebElement enterUserName;

    @FindBy(xpath ="//*[@id=\"app\"]//div[1]/div/div[2]/input")
    public WebElement enterPassword;

    @FindBy(xpath ="//*[@id=\"app\"]//div[2]/div/div[2]/input")
    public WebElement enterConfirmPassword;

    @FindBy(css ="button[type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[text()='System Users']")
    public WebElement systemUsersHeading;

    @FindBy(xpath = "//div/div[2]/input")
    public WebElement searchUsername;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement searchbutton;

    @FindBy(xpath = "//*[@class='oxd-table-body']//*[text()='jaahmed']")
    public WebElement searchUsernameRecord;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    public WebElement deleteUser;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
    public WebElement confirmDelete;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    public WebElement recordFound;

    public void validateAdminHeading() {
        Utils.waitForVisibility(adminHeading);
        String aText = adminHeading.getText();
        String eText =  "Admin";
        Assert.assertEquals(aText,eText);
    }
    public void addNewUser() throws InterruptedException {
        Utils.waitForVisibility(addButton);
        addButton.click();
        Utils.waitForVisibility(addUserText);
        String aText =  "Add User";
        String eText = addUserText.getText();
        Assert.assertEquals(aText,eText);
        selectUserRole.click();
        adminRole.click();
        Thread.sleep(3000);
        employeeName.click();
        employeeName.sendKeys("Paul twiggs Collings");
        Utils.waitForVisibility(selectEmployee);
        selectEmployee.click();
        selectStatus.click();
        enabledStatus.click();
        enterUserName.click();
        enterUserName.sendKeys("jaahmed");
        enterPassword.click();
        enterPassword.sendKeys("j12345678");
        enterConfirmPassword.click();
        enterConfirmPassword.sendKeys("j12345678");
        saveButton.click();
        Utils.waitForVisibility(systemUsersHeading);
        Assert.assertEquals(systemUsersHeading.getText(), "System Users");

    }
    public void searchNewUser() throws InterruptedException {
        Utils.waitForVisibility(searchUsername);
        searchUsername.click();
        searchUsername.sendKeys("jaahmed");
        searchbutton.click();
        Utils.waitForVisibility(searchUsernameRecord);
        Assert.assertEquals(searchUsernameRecord.getText(),"jaahmed");
    }
    public void deleteNewUser() throws InterruptedException {
    //    Thread.sleep(2000);
        Utils.waitForVisibility(deleteUser);
        deleteUser.click();
       // Thread.sleep(2000);
        Utils.waitForVisibility(confirmDelete);
        confirmDelete.click();
        Utils.waitForVisibility(recordFound);
        Assert.assertEquals(recordFound.getText(),"No Records Found");

    }

}
