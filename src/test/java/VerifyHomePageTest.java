import object.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class VerifyHomePageTest extends TestObject {

    @Test()
    public void homePage() {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        System.out.println("The Home Page is successfully loaded!");
    }
}