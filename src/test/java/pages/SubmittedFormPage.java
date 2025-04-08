package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmittedFormPage {

    private final WebDriver driver;

    // Locator
    private final By formSubmittedHeader= By.cssSelector("h1");
    private final By submittedFormMessage = By.id("message");

    public SubmittedFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // methods to get page contents below
    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getFormHeader(){
        return driver.findElement(formSubmittedHeader).getText();
    }

    public String getFormMessage(){
        return driver.findElement(submittedFormMessage).getText();
    }

    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(submittedFormMessage)).isDisplayed();
    }

}
