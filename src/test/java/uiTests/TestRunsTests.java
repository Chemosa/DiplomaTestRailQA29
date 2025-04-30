package uiTests;

import UI.entities.Section;
import UI.entities.TestCase;
import UI.entities.TestRun;
import org.testng.annotations.Test;
import utils.Retry;

public class TestRunsTests extends BaseTest{

    @Test(description = "Test creation of test run.", retryAnalyzer = Retry.class)
    public void createTestRunFromSidebarTest() {
        project.setProjectName("Project with test run");
        project.setAnnouncement("Announcement for project");
        Section section = Section.builder()
                .sectionName("Section")
                .build();
        TestCase testCase = TestCase.builder()
                .testcaseTitle("Test Case Title")
                .template("Test Case (Steps)")
                .type("Functional")
                .priority("High")
                .preconditions("Preconditions for test")
                .build();
        TestRun testRun = TestRun.builder()
                .testRunName("Test Run")
                .references("ID-1")
                .description("Description for test run.")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkCreatingTestCaseFromSidebar(testCase);
        testRunsAndResultsSteps
                .checkCreatingTestRun(testRun);
    }

    @Test(description = "Test changing of test case status to passed in test run.", retryAnalyzer = Retry.class)
    public void changeTestStatusTest() {
        project.setProjectName("Project with test run");
        project.setAnnouncement("Announcement for project");
        Section section = Section.builder()
                .sectionName("Section")
                .build();
        TestCase testCase1 = TestCase.builder()
                .testcaseTitle("Test Case 1")
                .build();
        TestCase testCase2 = TestCase.builder()
                .testcaseTitle("Test Case 2")
                .build();
        TestRun testRun = TestRun.builder()
                .testRunName("Test Run")
                .references("ID-1")
                .description("Description for test run.")
                .build();
        loginSteps
                .login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        projectsSteps
                .createProjectFromDashboardAndCheckCreated(project);
        testCasesSteps
                .checkCreatingSection(project, section)
                .checkCreatingCaseFromSection(testCase1, testCase2);
        testRunsAndResultsSteps
                .checkCreatingTestRun(testRun)
                .changeRunStatusOfTestCaseToPassed(testCase2)
                .checkTestStatusInRun(testCase1, "Untested")
                .checkTestStatusInRun(testCase2, "Passed");
    }
}