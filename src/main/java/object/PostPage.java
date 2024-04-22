package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PostPage {
    private final WebDriver webDriver;

    public PostPage(WebDriver driver){
        this.webDriver = driver;
    }

    public boolean isNewPostLoaded(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement newPostTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[text()='Post a picture to share with your awesome followers']")));
        return newPostTitle.isDisplayed();
    }

    public void uploadPicture(File file){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement uploadFile = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='form-group']//div/input[@type='file']")));
        uploadFile.sendKeys(file.getAbsolutePath());
    }

       public boolean isImageUploaded(String fileName) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement uploadPictureText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@class='form-control input-lg'][@type='text']")));
        String actualText = uploadPictureText.getAttribute("placeholder");
        return actualText.equals(fileName);
    }

    public String uploadedImageText() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement uploadPictureText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@class='form-control input-lg'][@type='text']")));
        return uploadPictureText.getAttribute("placeholder");
    }

    public void typePostCaption(String text){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement postCaption = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("caption")));
        postCaption.sendKeys(text);
    }

    public void clickCreatePost() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement createPostButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("create-post")));
        createPostButton.click();
    }
}