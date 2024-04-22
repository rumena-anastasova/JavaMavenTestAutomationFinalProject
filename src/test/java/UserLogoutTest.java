import object.Header;
import object.HomePage;
import object.LoginPage;
import object.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserLogoutTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{
                {"rumi","123456", "5499"},
        };
    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password, String userId){
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUsername(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignInButton();

        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogout();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        System.out.println("The user is successfully logout!");
    }
}