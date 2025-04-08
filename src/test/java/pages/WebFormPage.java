package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class WebFormPage {

    private WebDriver driver;

    // Locator
    private By textInputFiled = By.id("my-text-id");
    private By passwordTextField = By.cssSelector("input[name='my-password']");
    private By textAreaTextField = By.cssSelector("textArea[name='my-textarea']");
    private By disabledInput = By.cssSelector("input[name='my-disabled']");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By checkedRadio = By.id("my-radio-1");
    private By defaultRadio = By.id("my-radio-2");
    private By fileUpload = By.cssSelector("input[name='my-file']");
    private By selectDropDown = By.cssSelector("select[name='my-select']");
    private By dataListDropDown = By.cssSelector("input[name='my-datalist']");

    // constructor
    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // methods to interact with page below
    public void enterTextInput(String text) {
        driver.findElement(textInputFiled).sendKeys(text);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void textArea(String text) {
        driver.findElement(textAreaTextField).sendKeys(text);
    }

    public boolean isDisabledInputEnabled() {
        WebElement inputFieldElem = driver.findElement(disabledInput);
        return inputFieldElem != null && inputFieldElem.isEnabled();
    }

    public void submitForm(){
        driver.findElement(submitButton).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
    public String isCheckedRadioSelected(){
        return driver.findElement(checkedRadio).getAttribute("checked");
    }
    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textInputFiled)).isDisplayed();
    }

    public void uploadFile(){
        WebElement fileInput = driver.findElement(fileUpload);
        String fileRelativePath = "src/test/resources/utils/file.txt";
        // Convert the relative path to an absolute path
        Path path = Paths.get(fileRelativePath);
        Path fileAbsolutePath = path.toAbsolutePath();

        fileInput.sendKeys(fileAbsolutePath.toString());
    }

    public void selectByText(String value, By elementLocator) {
        WebElement dropdown = driver.findElement(selectDropDown);
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void selectByIndex(int index) {
        WebElement dropdown = driver.findElement(selectDropDown);
        Select select = new Select(dropdown);
        try {
            select.selectByIndex(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void selectDropDownOption(String value) {
       selectByText(value,selectDropDown);
    }

    public void dataListSelectDropDown(String searchText, String value) {
        WebElement dropdownTextField = driver.findElement(dataListDropDown);
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownTextField).click().sendKeys("n").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
    }

    public void selectDate(String dateString){
        WebElement datePicker = driver.findElement(By.cssSelector("input[name='my-date']"));
        datePicker.sendKeys(dateString);
    }

}
