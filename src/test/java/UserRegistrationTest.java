import object.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserRegistrationTest extends TestObject{

    @Test
    public void registrationTest(){
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        registrationPage.registrationLink();
        Assert.assertTrue(registrationPage.isUrlLoaded(), "Current page is not Registration");

        String signUpText = registrationPage.verifySignUpText();
        Assert.assertEquals(signUpText, "Sign up", "The actual text doesn't match the expected text");

        registrationPage.fillInUsername();
        registrationPage.fillInEmail();
        registrationPage.fillInPassword();
        registrationPage.fillInConfirmPassword();

        registrationPage.clickSignInButton();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        System.out.println("The user is successfully register!");
    }
}