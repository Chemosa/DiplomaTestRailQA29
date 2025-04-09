package UI.pages;

import UI.elements.Button;
import UI.elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_ERROR_MESSAGE_XPATH = "//*[@class = 'loginpage-message-title ']";
    private static final String ERRORS_UNDER_FIELDS_XPATH = "//*[contains(text(), '%s')]";
    private final WebElement LOGIN_BUTTON = driver.findElement(By.id("button_primary"));

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
        new Input(driver, "name").writeCredentialsToLogin(username);
        new Input(driver, "password").writeCredentialsToLogin(password);
        new Button(driver).clickButton(LOGIN_BUTTON);
        if(driver.getCurrentUrl().contains(PROJECTS_PAGE_URL)){
            log.info("User '{}' is successfully login", username);
        }
        return new ProjectsListPage(driver);
    }

    /**
     * This method gets text from error message.
     * @return
     */
    public String getErrorMessage() {
        return driver.findElement(By.xpath(LOGIN_PAGE_ERROR_MESSAGE_XPATH)).getText();
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
