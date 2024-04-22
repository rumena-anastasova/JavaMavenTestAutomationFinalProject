package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver webDriver;
    public Header(WebDriver driver){
        this.webDriver = driver;
    }
    public void clickLogin(){
        WebElement loginLink = this.webDriver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }
    public void clickProfile(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(40));
        WebElement profilePageLink = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.id("nav-link-profile"))));
        profilePageLink.click();
    }

    public void clickNewPost(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(40));
        WebElement logoutPageLink = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.id("nav-link-new-post"))));
        logoutPageLink.click();
    }

    public void clickLogout(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(40));
        WebElement logoutPageLink = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.xpath("//div[@id='navbarColor01']//i[@class='fas fa-sign-out-alt fa-lg']"))));
        logoutPageLink.click();
    }

}