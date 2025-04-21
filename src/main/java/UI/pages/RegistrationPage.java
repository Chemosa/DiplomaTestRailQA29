package UI.pages;

import UI.elements.Button;
import UI.elements.Checkbox;
import UI.elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class RegistrationPage extends BasePage{

    private static final String DROPDOWN_OPTIONS_REGISTRATION_XPATH = "//option[text() = \"%s\"]";

    @FindBy(xpath = "//button[@type = \"submit\"]")
    WebElement createAccountButton;

    @FindBy(xpath = "//p[@class=\"form-error\"]")
    List<WebElement> errorMessagesList;

    @FindBy(xpath = "//*[@class=\"addressCountry form-control\"]")
    WebElement dropdownRegistrationCountry;

    @FindBy(id = "users")
    WebElement dropdownRegistrationUsers;

    @FindBy(id = "email-confirm")
    WebElement emailConfirmationMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method opens registration page.
     * @param url
     * @return
     */
    public RegistrationPage openRegistrationPage(String url) {
        driver.get(url);
        waiter.waitForPageOpened(driver, url, 15);
        return new RegistrationPage(driver);
    }

    /**
     * This method fills registration form with some valid data.
     * @return
     */
    public RegistrationPage fillRegistrationPage() {
        new Input(driver).writeTextToInputById("first_name", faker.name().firstName());
        new Input(driver).writeTextToInputById("last_name", faker.name().lastName());
        new Input(driver).writeTextToInputById("email", faker.internet().emailAddress());
        new Input(driver).writeTextToInputById("organization", faker.company().name());
        dropdownRegistrationCountry.click();
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTIONS_REGISTRATION_XPATH, "Armenia"))).click();
        dropdownRegistrationUsers.click();
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTIONS_REGISTRATION_XPATH, "10"))).click();
        new Input(driver).writeTextToInputById("hostname", String.format(faker.name().firstName() + faker.name().lastName()).toLowerCase());
        new Checkbox(driver).selectCheckboxById("tos", true);
        return this;
    }

    /**
     * This method clicks on submit button to create new account.
     * @return
     */
    public RegistrationPage clickCreateAccountButton() {
        new Button(driver).clickElementButton(createAccountButton);
        return new RegistrationPage(driver);
    }

    /**
     * This method gets confirmation messages.
     * @return
     */
    public String getConfirmationMessage() {
        try {
            log.info("Getting message text.");
            return emailConfirmationMessage.getText();
        } catch (Exception noText) {
            log.error("Failed to get message.", noText);
            return "";
        }
    }

    /**
     * This method checks if error message displayed.
     * @param errorMessage
     * @return
     */
    public boolean isErrorMessagePresent(String errorMessage) {
        boolean isPresent = false;
        for(WebElement message : errorMessagesList) {
            if(message.getText().equals(errorMessage)) {
                isPresent = true;
                log.info("Error message '{}' is founded", errorMessage);
            }
        }
        return isPresent;
    }
}