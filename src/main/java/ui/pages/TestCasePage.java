package ui.pages;

import ui.elements.Button;
import ui.elements.Checkbox;
import ui.elements.Input;
import ui.entities.Section;
import ui.entities.TestCase;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class TestCasePage extends BasePage {

    Actions actions = new Actions(driver);
    private static final String SECTION_NAME_ON_PAGE_XPATH = "//*[@class = \"title\" and text() = \"%s\"]";

    @FindBy(xpath = "//*[@class = \"grid-title\"]/*[@class = \"title\"]")
    List<WebElement> sectionNamesList;

    @FindBy(xpath = "//*[@class=\"icon-small-delete hidden action-hover\"]/..")
    WebElement deleteSectionButton;

    @FindBy(xpath = "//*[contains(text(), \"Yes, delete\")]/../following-sibling::input")
    WebElement deleteConfirmationCheckbox;

    @FindBy(xpath = "//*[@data-testid=\"testCaseContentHeaderTitle\"]")
    WebElement testCaseNameInTitle;

    @FindBy(xpath = "//*[contains(@id, \"inlineSectionActions\")]/*[@data-testid=\"suiteAddCaseLink\"]")
    WebElement addCaseLink;

    @FindBy(xpath = "//*[@data-testid=\"sectionCaseTitle\"]")
    List<WebElement> testCasesList;

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on 'Add Section' button.
     * @return
     */
    public AddSectionModalPage clickAddSectionButton() {
        new Button(driver).clickButton("addSectionInline");
        return new AddSectionModalPage(driver);
    }

    /**
     * This method clicks on 'Add Subsection' button.
     * @return
     */
    public AddSectionModalPage clickAddSubsectionButton() {
        new Button(driver).clickButton("addSubsectionLink");
        return new AddSectionModalPage(driver);
    }

    /**
     * This method clicks on 'Add Test Case' button.
     * @return
     */
    public AddTestCaseModalPage clickAddTestCaseButton() {
        new Button(driver).clickButton("sidebarCasesAdd");
        return new AddTestCaseModalPage(driver);
    }

    /**
     * This method clicks on 'Add Case' link.
     * @return
     */
    public TestCasePage clickAddCaseLink() {
        new Button(driver).clickElementButton(addCaseLink);
        return new TestCasePage(driver);
    }

    /**
     * This method adds few cases with filled default form.
     * @param testCasesList
     * @return
     */
    public TestCasePage addCase(TestCase... testCasesList) {
        for (TestCase testCase : testCasesList) {
            new Input(driver).writeTextToInputById("addCaseTitle", testCase.getTestcaseTitle());
            new Button(driver).clickButton("iconButtonAccept");
            waiter.waitForElementDisplayed(driver, "iconButtonAccept", 5);
        }
        return this;
    }

    /**
     * This method clicks on 'Delete' button and deletes section.
     * @param section
     * @return
     */
    public TestCasePage deleteSection(Section section) {
        actions.moveToElement(driver.findElement(By.xpath(String.format(SECTION_NAME_ON_PAGE_XPATH, section.getSectionName())))).build().perform();
        new Button(driver).clickElementButton(deleteSectionButton);
        new Checkbox(driver).selectElementCheckbox(deleteConfirmationCheckbox, true);
        new Button(driver).clickButton("caseFieldsTabDeleteDialogButtonOk");
        waiter.waitForElementDisappearing(driver, String.format(SECTION_NAME_ON_PAGE_XPATH, section.getSectionName()), 30);
        return new TestCasePage(driver);
    }

    /**
     * This method checks is section is created.
     * @param sectionName
     * @return
     */
    public boolean isSectionCreated(String sectionName) {
        waiter.waitForElementByXpathDisplayed(driver, String.format(SECTION_NAME_ON_PAGE_XPATH, sectionName), 30);
        boolean isCreated = false;
        for (WebElement section : sectionNamesList) {
            if (section.getText().equals(sectionName)) {
                isCreated = true;
            }
        }
        return isCreated;
    }

    /**
     * This method collect in list all sections names on page.
     * @return
     */
    public List<WebElement> sectionNamesList() {
        return sectionNamesList;
    }

    /**
     * This method gets name of the created test case.
     * @return
     */
    public String getTestCaseName() {
        try {
            log.info("Getting test case name.");
            return testCaseNameInTitle.getText();
        } catch (Exception noName) {
            log.error("Failed to get test case name.", noName);
            return "";
        }
    }

    /**
     * This method checks is test case is created and added to list.
     *
     * @param testCases
     * @return
     */
    public boolean isTestCaseInList(TestCase... testCases) {
        int caseShouldPresent = 0;
        int caseIsPresent = 0;
        boolean isTestCasePresent = false;
        for (TestCase testCase : testCases) {
            caseShouldPresent += 1;
            for (WebElement caseOnList : testCasesList) {
                if (caseOnList.getText().equals(testCase.getTestcaseTitle())) {
                    caseIsPresent += 1;
                    break;
                }
            }
        }
        if (caseShouldPresent == caseIsPresent) {
            isTestCasePresent = true;
        }
        return isTestCasePresent;
    }
}