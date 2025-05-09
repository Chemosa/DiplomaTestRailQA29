package ui.pages;

import ui.elements.Button;
import ui.elements.Checkbox;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class AdminPage extends HeaderPage {

    private static final String SIDEBAR_ITEM_XPATH = "//*[@data-testid=\"%s\"]";
    private static final String DELETE_PROJECT_BY_NAME_XPATH = "//*[text() = \"%s\"]/ancestor::tr//div[@data-testid=\"projectDeleteButton\"]";
    private static final String PROJECT_NAME_XPATH = "//*[text() = \"%s\"]";

    @FindBy(xpath = "//*[contains(text(), \"Yes, delete\")]/../following-sibling::input")
    WebElement deleteConfirmationCheckbox;

    @FindBy(xpath = "//div[contains(text(), 'Successfully added the new project.')]")
    WebElement successfulAddedProjectMessage;

    @FindBy(xpath = "//div[@data-testid=\"projectDeleteButton\"]")
    WebElement deleteProjectButton;

    @FindBy(xpath = "//span[@class = \"hidden hoverAction\"]/../a")
    List<WebElement> projectsOnPageList;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on Projects button on sidebar.
     * @return
     */
    public AdminPage clickOnProjectsSidebarItem() {
        waiter.waitForElementDisplayed(driver, "administrationSidebarProjects", 10);
        driver.findElement(By.xpath(String.format(SIDEBAR_ITEM_XPATH, "administrationSidebarProjects"))).click();
        return new AdminPage(driver);
    }

    /**
     * This method deletes project from Projects page opened from Admin menu by specified name.
     * @param projectName
     * @return
     */
    public AdminPage deleteProject(String projectName) {
        driver.findElement(By.xpath(String.format(DELETE_PROJECT_BY_NAME_XPATH, projectName))).click();
        new Checkbox(driver).selectElementCheckbox(deleteConfirmationCheckbox, true);
        new Button(driver).clickButton("caseFieldsTabDeleteDialogButtonOk");
        waiter.waitForElementDisplayed(driver, "messageSuccessDivBox", 10);
        waiter.waitForElementDisappearing(driver, String.format(PROJECT_NAME_XPATH, projectName), 10);
        log.info("Project '{}' is deleted.", projectName);
        return new AdminPage(driver);
    }

    /**
     * This method deletes all projects from Projects page opened from Admin menu.
     * @return
     */
    @SneakyThrows
    public AdminPage deleteAllProject() {
        while (true) {
            if (projectsOnPageList.isEmpty()) {
                log.info("All projects are deleted.");
                break;
            }
            for (int i = 0; i < projectsOnPageList.size(); i++) {
                deleteProjectButton.click();
                new Checkbox(driver).selectElementCheckbox(deleteConfirmationCheckbox, true);
                new Button(driver).clickButton("caseFieldsTabDeleteDialogButtonOk");
                driver.navigate().refresh();
            }
        }
        return new AdminPage(driver);
    }

    /**
     * This method checks is project is created and added to list on Projects page opened from Admin menu
     * @param projectName
     * @return
     */
    public boolean checkProjectIsAdded(String projectName) {
        boolean isAdded = false;
        for (WebElement project : projectsOnPageList) {
            if (project.getText().equals(projectName) & successfulAddedProjectMessage.isDisplayed()) {
                isAdded = true;
            }
        }
        return isAdded;
    }
}