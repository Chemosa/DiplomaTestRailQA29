package UI.steps;

import UI.entities.Project;
import UI.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProjectsSteps extends BaseSteps {
    ProjectsListPage projectsListPage;
    AddProjectModalPage addProjectModalPage;
    ProjectPage projectPage;
    HeaderPage headerPage;
    AdminPage adminPage;

    public ProjectsSteps(WebDriver driver) {
        super(driver);
        this.projectsListPage = new ProjectsListPage(driver);
        this.addProjectModalPage = new AddProjectModalPage(driver);
        this.projectPage = new ProjectPage(driver);
        this.headerPage = new HeaderPage(driver);
        this.adminPage = new AdminPage(driver);
    }

    @Step("Create first project {project} from the main project list page.")
    public ProjectsSteps createFirstProject(Project project) {
        if (!projectsListPage.getListOfProjects().isEmpty()) {
            headerPage
                    .clickNavigationAdminButton()
                    .clickOnProjectsSidebarItem()
                    .deleteAllProject();
        }
        projectsListPage
                .clickLogo()
                .waitProjectListIsLoaded()
                .clickAddFirstProjectButton()
                .fillNewProjectForm(project.getProjectName(), project.getAnnouncement());
        return this;
    }

    @Step("Create example project automatically from the main project list page.")
    public ProjectsSteps createExampleProject(String projectName) {
        if (!projectsListPage.getListOfProjects().isEmpty()) {
            headerPage
                    .clickNavigationAdminButton()
                    .clickOnProjectsSidebarItem()
                    .deleteAllProject();
        }
        projectsListPage
                .clickLogo()
                .waitProjectListIsLoaded()
                .clickAddExampleProjectButton()
                .fillAddExampleProjectForm(projectName);
        return this;
    }

    @Step("Create project by click on 'Add Project' button on dashboard from the main project list page.")
    public ProjectsSteps createProjectFromDashboard(Project project) {
        projectsListPage
                .clickLogo()
                .waitProjectListIsLoaded();
        if (projectsListPage.getListOfProjects().isEmpty()) {
            projectsListPage
                    .clickAddProjectFromDashboardButton()
                    .fillNewProjectForm(project.getProjectName(), project.getAnnouncement());
            checkFirstProjectNameAndInfoMessageTitle(project);
        } else {
            projectsListPage
                    .clickAddProjectFromDashboardButton()
                    .fillNewProjectForm(project.getProjectName(), project.getAnnouncement());
            Assert.assertTrue(adminPage.checkProjectIsAdded(project.getProjectName()));
        }
        return this;
    }

    @Step("Check name of the first project and text of appeared info message.")
    public ProjectsSteps checkFirstProjectNameAndInfoMessageTitle(Project project) {
        softAssert.assertEquals(projectPage.getProjectName(), project.getProjectName());
        softAssert.assertEquals(projectPage.getTitleFromInfoMessage(), "Congratulations! You have created your first project");
        softAssert.assertAll();
        return this;
    }

    @Step("Check name of the example project and that chart is presented.")
    public ProjectsSteps checkExampleProjectNameAndChart(Project project) {
        softAssert.assertEquals(projectPage.getProjectName(), project.getProjectName());
        softAssert.assertTrue(projectPage.projectChartIsDisplayed());
        softAssert.assertAll();
        return this;
    }

    @Step("Delete {project}.")
    public ProjectsSteps deleteProject(Project project) {
        headerPage
                .clickNavigationAdminButton()
                .clickOnProjectsSidebarItem()
                .deleteProject(project.getProjectName());
        return this;
    }

    @Step("Delete all projects if the are presented.")
    public void deleteProjectAfterTest() {
        if (!pageIsLoaded(LOGIN_PAGE_URL)
                && !pageIsLoaded("https://secure.testrail.com/customers/testrail/trial/")
                && !projectsListPage.getListOfProjects().isEmpty()) {
            adminPage
                    .clickNavigationAdminButton()
                    .clickOnProjectsSidebarItem()
                    .deleteAllProject();
        }
    }
}