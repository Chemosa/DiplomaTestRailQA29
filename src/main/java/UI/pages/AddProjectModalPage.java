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
        new Input(driver, "addProjectNameInput").writeTextToInput(projectName);
        new Input(driver, "addEditProjectAnnouncement").writeTextToInput(announcement);
        new Checkbox(driver).selectCheckbox("addEditProjectShowAnnouncement", true);
        new Button(driver).clickButton("addEditProjectAddButton");
        log.info("Project '{}' is created.", projectName);
        return new ProjectPage(driver);
    }

    /**
     * This method fill 'Add Project' form for example project which will create automatically.
     * @param projectName
     * @return
     */
    public ProjectPage fillAddExampleProjectForm(String projectName) {
        new Input(driver, "addExampleProjectDialogName").writeTextToInput(projectName);
        new Button(driver).clickButton("addExampleProjectDialogSubmit");
        waiter.waitForPageOpened(driver, PROJECT_PAGE_URL, 60);
        log.info("Example project '{}' is created.", projectName);
        return new ProjectPage(driver);
    }
}
