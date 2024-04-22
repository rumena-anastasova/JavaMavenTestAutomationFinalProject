package object;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    public static final String REGISTRATION_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void registrationLink() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.xpath("//form//p//a[text()='Register']"))));
        registrationLink.click();
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REGISTRATION_URL));
    }

    public String verifySignUpText() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement signUpText = wait.until(ExpectedConditions.visibilityOf(
                webDriver.findElement(By.xpath("//h4[@class='text-center mb-4']"))));
        return signUpText.getText();
    }

    public void fillInUsername() {
        String username = generateRandomUser(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        WebElement usernameTextField = wait.until(ExpectedConditions.visibilityOf(
                webDriver.findElement(By.xpath("//*[@name='username']"))));
        usernameTextField.sendKeys(username);
    }

    public void fillInEmail() {
        String email = generateRandomEmail(10, 15); // Генерирайте случайен email
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        WebElement emailTextField = wait.until(ExpectedConditions.visibilityOf(
                webDriver.findElement(By.xpath("//*[@type='email']"))));
        emailTextField.sendKeys(email);
    }

    String password = generateRandomAlphabeticString(10, 15);

    public void fillInPassword() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        WebElement passwordTextField = wait.until(ExpectedConditions.visibilityOf(
                webDriver.findElement(By.id("defaultRegisterFormPassword"))));
        passwordTextField.sendKeys(password);
    }

    public void fillInConfirmPassword() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        WebElement confirmPasswordTextField = wait.until(ExpectedConditions.visibilityOf(
                webDriver.findElement(By.id("defaultRegisterPhonePassword"))));
        confirmPasswordTextField.sendKeys(password);
    }

    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                webDriver.findElement(By.id("sign-in-button"))));
        signInButton.click();
    }

    private String generateRandomUser(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

    private String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

}

