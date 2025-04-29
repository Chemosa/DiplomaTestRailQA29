package UI.pages;

import UI.elements.Button;
import UI.elements.Checkbox;
import UI.elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddProjectModalPage extends BasePage {

    public AddProjectModalPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method fill 'Add Project' form.
     * @param projectName
     * @param announcement
     * @return
     */
    public ProjectPage fillNewProjectForm(String projectName, String announcement) {
        new Input(driver).writeTextToInput("addProjectNameInput", projectName);
        new Input(driver).writeTextToInput("addEditProjectAnnouncement", announcement);
        new Checkbox(driver).selectCheckbox("addEditProjectShowAnnouncement", true);
        new Button(driver).clickButton("addEditProjectAddButton");
        waiter.waitForElementDisplayed(driver, "testCaseContentHeaderTitle", 10);
        log.info("Project '{}' is created.", projectName);
        return new ProjectPage(driver);
    }

    /**
     * This method fill 'Add Project' form for example project which will create automatically.
     * @param projectName
     * @return
     */
    public ProjectPage fillAddExampleProjectForm(String projectName) {
        new Input(driver).writeTextToInput("addExampleProjectDialogName", projectName);
        new Button(driver).clickButton("addExampleProjectDialogSubmit");
        waiter.waitForPageOpened(driver, PROJECT_PAGE_URL, 60);
        log.info("Example project '{}' is created.", projectName);
        return new ProjectPage(driver);
    }
}
