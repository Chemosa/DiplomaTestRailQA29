package UI.pages;

import UI.elements.Button;
import UI.entities.TestCase;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

@Log4j2
public class TestRunPage extends BasePage {

    private static final String TEST_STATUS_OPTIONS_XPATH = "//*[contains(text(), \"%s\")]/ancestor::tr//td[@data-testid=\"runTestAction\"]";
    private static final String TEST_TITLE_IN_OPTIONS_XPATH = "//*[@data-testid=\"testCaseViewTitle\"]/*[text() = \"%s\"]";
    private static final String TEST_STATUS_XPATH = "//*[contains(text(), \"%s\")]/ancestor::tr//td[@class=\"js-status\"]/*[@class = \"dropdownLink status hidden-xs\"]";

    @FindBy(xpath = "//*[@data-testid=\"messageSuccessDivBox\"]")
    WebElement successfulMessage;

    @FindBy(xpath = "//*[@data-testid=\"testCaseContentHeaderTitle\"]")
    WebElement testRunNameInTitle;

    @FindBy(xpath = "//*[@data-testid=\"testCaseViewTitle\"]")
    WebElement testCaseNameInTitle;

    @FindBy(id = "addResultAndNext")
    WebElement passAndNextButton;

    public TestRunPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method gets text from informational message.
     * @return
     */
    public String getTextFromInfoMessage() {
        try {
            log.info("Getting informational message.");
            return successfulMessage.getText();
        } catch (Exception noMessage) {
            log.error("Failed to get message.", noMessage);
            return "";
        }
    }

    /**
     * This method gets name of test run.
     * @return
     */
    public String getTestRunName() {
        try {
            log.info("Getting project name.");
            return testRunNameInTitle.getText();
        } catch (Exception noName) {
            log.error("Failed to get name of test run", noName);
            return "";
        }
    }

    /**
     * This method opens options menu for certain testcase in test run.
     * @param testCase
     * @return
     */
    public TestRunPage openTestOptionsMenu(TestCase testCase) {
        new Button(driver).clickElementButton(driver.findElement(By.xpath(String.format(TEST_STATUS_OPTIONS_XPATH, testCase.getTestcaseTitle()))));
        log.info("Options for test '{}' are opened", testCase.getTestcaseTitle());
        return this;
    }

    /**
     * This method clicks on 'Pass & Next' button.
     * @return
     */
    @SneakyThrows
    public TestRunPage clickPassAndNextButton() {
        sleep(2000);
        new Button(driver).clickElementButton(passAndNextButton);
        sleep(2000);
        return new TestRunPage(driver);
    }

    /**
     * This method gets status of test case.
     * @param testCase
     * @return
     */
    public String getTestCaseStatus(TestCase testCase) {
        try {
            log.info("Getting status of '{}' test case.", testCase.getTestcaseTitle());
            return driver.findElement(By.xpath(String.format(TEST_STATUS_XPATH, testCase.getTestcaseTitle()))).getText();
        } catch (Exception noMessage) {
            log.error("Failed to get status.", noMessage);
            return "";
        }
    }
}