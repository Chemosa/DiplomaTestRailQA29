package ui.pages;

import ui.elements.Button;
import ui.elements.Checkbox;
import ui.elements.Input;
import ui.entities.TestRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTestRunModalPage extends BasePage {

    @FindBy(id = "accept")
    WebElement addTestRunButton;

    public AddTestRunModalPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method fills form to create test run with all testcases.
     * @param testRun
     * @return
     */
    public TestRunPage fillAddTestRunModal(TestRun testRun) {
        waiter.waitForElementDisplayed(driver, "editSectionDescription", 10);
        new Input(driver)
                .deleteTextFromInput("addRunFormName")
                .slowTypeToInput("addRunFormName", testRun.getTestRunName());
        new Input(driver).writeTextToInput("addRunFormRefs", testRun.getReferences());
        new Input(driver).writeTextToInput("editSectionDescription", testRun.getDescription());
        new Checkbox(driver).selectCheckboxById("includeAll", true);
        new Button(driver).clickElementButton(addTestRunButton);
        waiter.waitForPageOpened(driver, TEST_RUN_PAGE_URL, 10);
        return new TestRunPage(driver);
    }
}