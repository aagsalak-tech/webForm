package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WebFormPage;
import pages.SubmittedFormPage;


public class WebFormPageSteps {

    WebDriver driver = Hooks.driver;
    WebFormPage webForm = new WebFormPage(driver);
    SubmittedFormPage submittedFormPage;

    @Given("I open the Selenium web form page")
    public void i_open_the_selenium_web_form_page() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @When("I enter Text input text")
    public void i_enter_text_input_text() {
       webForm.enterTextInput("this text");
    }
    @When("I enter Password text")
    public void i_enter_password_text() {
       webForm.enterPassword("password");
    }
    @When("I enter Text Area text")
    public void i_enter_text_area_text() {
        webForm.textArea("text area text");
    }
    @When("I submit form")
    public void i_submit_form() {
        webForm.submitForm();
    }

    @Then("Form is submitted")
    public void form_should_be_submitted() {
        submittedFormPage = new SubmittedFormPage(driver);
        submittedFormPage.waitForPageToLoad();
        String title = submittedFormPage.getPageTitle();
        String header = submittedFormPage.getFormHeader();
        String message = submittedFormPage.getFormMessage();

        Assert.assertEquals("Invalid Page Title", "Web form - target page", title);
        Assert.assertEquals("Invalid Page Header", "Form submitted", header);
        Assert.assertEquals("Invalid Message", "Received!", message);

    }

    @When("I upload a file")
    public void upload_a_file() {
        webForm.uploadFile();
    }

    @Given("Page title is Valid")
    public void page_title_is_valid() {
        Assert.assertEquals("Invalid Page Title","Web form", webForm.getPageTitle());
    }
    @Given("Disabled input is disabled")
    public void disabled_input_is_disabled() {
        boolean elementStatus = webForm.isDisabledInputEnabled();
        Assert.assertFalse("Disabled Input should be disabled", elementStatus);
    }
    @Given("Check radio is selected")
    public void check_radio_is_selected() {
       Assert.assertEquals("checked radio not selected", "true", webForm.isCheckedRadioSelected());
    }
    @When("I navigate back")
    public void i_navigate_back() {
       driver.navigate().back();
       webForm.waitForPageToLoad();
    }

    @When("I select drop down")
    public void i_select_drop_down() {
        webForm.selectDropDownOption("One");
    }

    @When("I select option from datalist")
    public void i_select_option_from_data_list() {
        webForm.dataListSelectDropDown("new", "New York");
    }

    @When("I select {string}")
    public void i_select_date(String date) {
        webForm.selectDate(date);
    }

}
