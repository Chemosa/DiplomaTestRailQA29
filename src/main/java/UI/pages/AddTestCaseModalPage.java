package UI.pages;

import UI.elements.Button;
import UI.elements.Dropdown;
import UI.elements.Input;
import UI.entities.TestCase;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddTestCaseModalPage extends BasePage{

    @FindBy(id = "accept")
    WebElement confirmAddTestCaseButton;

    @FindBy(id = "custom_preconds_display")
    WebElement preconditionsArea;

    public AddTestCaseModalPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method fills form to create testcase.
     * @param testCase
     * @return
     */
    public TestCasePage fillAddTestCaseModal(TestCase testCase) {
        waiter.waitForElementDisplayed(driver, preconditionsArea, 10);
        new Input(driver).writeTextToInput("addEditCaseTitle", testCase.getTestcaseTitle());
        new Dropdown(driver, "template_id_chosen", testCase.getTemplate()).selectOption();
        new Dropdown(driver, "type_id_chosen", testCase.getType()).selectOption();
        new Dropdown(driver, "priority_id_chosen", testCase.getPriority()).selectOption();
        new Input(driver).writeTextToInput(preconditionsArea, testCase.getPreconditions());
        new Button(driver).clickElementButton(confirmAddTestCaseButton);
        waiter.waitForPageOpened(driver, TEST_CASE_PAGE_URL, 10);
        log.info("Test case '{}' was successfully created!", testCase.getTestcaseTitle());
        return new TestCasePage(driver);
    }
}