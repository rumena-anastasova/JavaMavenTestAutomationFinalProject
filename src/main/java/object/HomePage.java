package object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public static final String HOME_URL = "http://training.skillo-bg.com:4200/posts/all";
    private final WebDriver webDriver;

    public HomePage(WebDriver driver){
        this.webDriver = driver;
    }

    public void navigateTo(){
        this.webDriver.get(HOME_URL);
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.urlToBe(HOME_URL));
    }

    public void scrollToBottom() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement lastImageElement = webDriver.findElement(By.xpath("(//*[@class='post-feed-img'])[last()]"));
        wait.until(ExpectedConditions.visibilityOf(lastImageElement));

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, 2750)");
    }

    public int getNumberOfLoadedImages() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        List<WebElement> numberOfImages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='post-feed-img']")));

        return numberOfImages.size();
    }

}