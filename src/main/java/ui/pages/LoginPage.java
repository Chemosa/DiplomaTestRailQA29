package ui.pages;

import ui.elements.Button;
import ui.elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    private static final String ERRORS_UNDER_FIELDS_XPATH = "//*[contains(text(), '%s')]";

    @FindBy(xpath = "//*[@class = 'loginpage-message-title ']")
    WebElement topErrorMessageOnLoginPage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method opens login page.
     * @param url
     * @return
     */
    public LoginPage openLoginPage(String url) {
        driver.get(url);
        waiter.waitForPageOpened(driver, url, 15);
        return this;
    }

    /**
     * This method fill fields on Login page with credentials written in config.properties.
     * @param username
     * @param password
     * @return
     */
    public ProjectsListPage fillLoginFields(String username, String password) {
        new Input(driver).writeTextToInput("loginIdName", username);
        new Input(driver).writeTextToInput("loginPasswordFormDialog", password);
        new Button(driver).clickButton("loginButtonPrimary");
        if (driver.getCurrentUrl().contains(PROJECTS_LIST_PAGE_URL)) {
            log.info("User '{}' is successfully login", username);
        }
        return new ProjectsListPage(driver);
    }

    /**
     * This method gets text from error message.
     * @return
     */
    public String getErrorMessage() {
        try {
            log.info("Getting error message.");
            return topErrorMessageOnLoginPage.getText();
        } catch (Exception noMessage) {
            log.error("Failed to get error message.", noMessage);
            return "";
        }
    }

    /**
     * This method gets text from error under the field.
     * @param errorUnderField
     * @return
     */
    public boolean checkErrorMessageUnderFieldsIsDisplayed(String errorUnderField) {
        return driver.findElement(By.xpath(String.format(ERRORS_UNDER_FIELDS_XPATH, errorUnderField))).isDisplayed();
    }
}