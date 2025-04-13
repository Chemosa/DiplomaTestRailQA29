package UITests;

import org.testng.annotations.Test;

public class ProjectListTests extends BaseTest {

    @Test
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

    @Test
    public void createExampleProjectTest() {
        project.setProjectName("My Example Project");
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createExampleProject(project.getProjectName())
                .checkExampleProjectNameAndChart(project);
    }

    @Test
    public void createProjectFromDashboardTest() {
        project.setProjectName("Project 1");
        project.setAnnouncement("Announcement for Project 1");
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboard(project);
    }
}
