import base.BaseClass;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Admin;
import pom.HomePage;
import pom.Login;
import org.openqa.selenium.support.ui.Select;

public class TestClass extends BaseClass {

    @Test  (priority = 1)
    public void test() throws InterruptedException {
        HomePage homePage = new HomePage();
        Login login  = new Login();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        login.loginUser("Admin", "admin123");
        String text = login.dashboard.getText();
        String eText = "Dashboard";
        Assert.assertEquals(text,eText);
    }

    @Test (priority = 2)
    public void searchAdminUser() throws InterruptedException {

        Admin admin  = new Admin();
        admin.adminMenuButton.click();
        admin.validateAdminHeading();
        admin.addNewUser();
        admin.searchNewUser();
        admin.deleteNewUser();
    }
}
