import object.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageScrollTest extends TestObject{

    @Test()
    public void homePageScrollTest() {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        homePage.scrollToBottom();

        homePage.getNumberOfLoadedImages();

        int numberOfLoadedImages = homePage.getNumberOfLoadedImages();
        System.out.println("The number of loaded images is: " + numberOfLoadedImages);
        Assert.assertEquals(numberOfLoadedImages, 3, "Expected number of images not loaded");

    }

}
