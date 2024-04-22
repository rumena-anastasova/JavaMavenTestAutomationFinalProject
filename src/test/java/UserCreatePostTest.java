import object.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class UserCreatePostTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        File postPicture = new File("src\\test\\resources\\upload\\name_1.jpg");
        String caption = "Testing upload file";
        return new Object[][]{
                {"rumi","123456", "5499", postPicture, caption},
        };
    }
    @Test(dataProvider = "getUser")
    public void testCreatePost(String username, String password, String userId, File postPicture, String caption){
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        loginPage.navigateTo();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUsername(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");
        loginPage.clickSignInButton();

        header.clickProfile();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");

        header.clickNewPost();
        Assert.assertTrue(postPage.isNewPostLoaded(), "The new post form is not loaded");

        postPage.uploadPicture(postPicture);
        String actualImageText = postPage.uploadedImageText();
        Assert.assertTrue(postPage.isImageUploaded("name_1.jpg"), "Image is not uploaded");
        Assert.assertEquals(actualImageText, "name_1.jpg", "Incorrect image is uploaded");

        postPage.typePostCaption(caption);
        postPage.clickCreatePost();

        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");
    }
}
