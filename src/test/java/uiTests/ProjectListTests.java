package uiTests;

import org.testng.annotations.Test;
import utils.Retry;

public class ProjectListTests extends BaseTest {

    @Test(description = "Test that the first project can be created from main page and then deleted.")
    public void createFirstProjectTest() {
        project.setProjectName("My First Project");
        project.setAnnouncement("Test Announcement");
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createFirstProject(project)
                .checkFirstProjectNameAndInfoMessageTitle(project)
                .deleteProject(project);
    }

    @Test(description = "Test that example test can be created from main page.", retryAnalyzer = Retry.class)
    public void createExampleProjectTest() {
        project.setProjectName("My Example Project");
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createExampleProject(project.getProjectName())
                .checkExampleProjectNameAndChart(project);
    }

    @Test(description = "Test that project can be created with button from dashboard.")
    public void createProjectFromDashboardTest() {
        project.setProjectName("Project 1");
        project.setAnnouncement("Announcement for Project 1");
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
    }
}