package UI.pages;

import UI.elements.Button;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class ProjectsListPage extends HeaderPage {

    @FindBy(xpath = "//*[@class=\"summary-title text-ppp\"]/a")
    List<WebElement> listOfProjects;

    @FindBy(id = "navigation-empty-addproject")
    WebElement addFirstProjectButton;

    @FindBy(id = "navigation-empty-addexampleproject")
    WebElement addExampleProjectButton;

    @FindBy(id = "sidebar-projects-add")
    WebElement addProjectFromDashboardButton;

    public ProjectsListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method waits till project list is loaded.
     * @return
     */
    public ProjectsListPage waitProjectListIsLoaded() {
        waiter.waitForElementDisplayed(driver, "sidebarProjectsAddButton", 10);
        return this;
    }

    /**
     * This method clicks on 'Add First Project' button.
     * @return
     */
    public AddProjectModalPage clickAddFirstProjectButton() {
        new Button(driver).clickElementButton(addFirstProjectButton);
        return new AddProjectModalPage(driver);
    }

    /**
     * This method clicks on 'Add Example Project' button.
     * @return
     */
    public AddProjectModalPage clickAddExampleProjectButton() {
        new Button(driver).clickElementButton(addExampleProjectButton);
        return new AddProjectModalPage(driver);
    }

    /**
     * This method clicks on 'Add Project' button on dashboard.
     * @return
     */
    public AddProjectModalPage clickAddProjectFromDashboardButton() {
        new Button(driver).clickElementButton(addProjectFromDashboardButton);
        return new AddProjectModalPage(driver);
    }

    /**
     * This method gets list of all projects on main project list page.
     * @return
     */
    public List<WebElement> getListOfProjects() {
        clickLogo();
        return listOfProjects;
    }
}