package uiTests;

import UI.entities.Section;
import UI.entities.TestCase;
import org.testng.annotations.Test;
import utils.Retry;

public class TestCasesTests extends BaseTest {

    @Test(description = "Test adding of the section to the project.")
    public void addSectionInProject() {
        project.setProjectName("New Test Project");
        project.setAnnouncement("New Test Announcement");
        Section section = Section.builder()
                .sectionName("Section Test")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkDeletingSection(section);
    }

    @Test(description = "Test adding of the subsection to the section.")
    public void addSubsectionInProject() {
        project.setProjectName("Test Project");
        project.setAnnouncement("Test Announcement");
        Section section = Section.builder()
                .sectionName("Section")
                .build();
        Section subsection = Section.builder()
                .sectionName("Subsection")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkCreatingSubsection(subsection);
    }

    @Test(description = "Test adding of the test case from the sidebar.", retryAnalyzer = Retry.class)
    public void addTestCaseFromSidebar() {
        project.setProjectName("TMS Project");
        project.setAnnouncement("Announcement for project");
        Section section = Section.builder()
                .sectionName("Section 1")
                .build();
        TestCase testCase = TestCase.builder()
                .testcaseTitle("Test Title")
                .template("Test Case (Steps)")
                .type("Functional")
                .priority("High")
                .preconditions("Preconditions for test")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkCreatingTestCaseFromSidebar(testCase);
    }

    @Test(description = "Test adding of the few default test cases.")
    public void addFewTestCasesWithDefaultSettings() {
        project.setProjectName("Project for few cases");
        project.setAnnouncement("Announcement for project");
        Section section = Section.builder()
                .sectionName("Section 2")
                .build();
        TestCase testCase1 = TestCase.builder()
                .testcaseTitle("Test1")
                .build();
        TestCase testCase2 = TestCase.builder()
                .testcaseTitle("Test2")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkCreatingCaseFromSection(testCase1, testCase2);
    }
}