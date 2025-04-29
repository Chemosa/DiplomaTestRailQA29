package apiTests;

import api.adapters.*;
import api.objects.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FullCycleApiTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "This test checks if correct project, section, test case, test run are created and ability to change test status with API requests.")
    public void fullCycleTillTestResultTest() {
        Project project = Project.builder()
                .name("Project1")
                .announcement("Announcement test")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();
        Section section = Section.builder()
                .name("Section Test")
                .description("Description for test")
                .build();
        TestCase testCase = TestCase.builder()
                .title("Test case title")
                .build();
        TestRun testRun = TestRun.builder()
                .name("New TestRun")
                .includeAll(true)
                .build();
        TestResult testResult = TestResult.builder()
                .statusId(4)
                .comment("Change status of test to \"Retest\".")
                .build();
        ProjectResponse projectResponse = new ProjectAdapter().addProject(project);
        SectionResponse sectionResponse = new SectionAdapter().addSection(section, projectResponse.getId());
        TestCaseResponse testCaseResponse  = new TestCaseAdapter().addTestCase(testCase, sectionResponse.getId());
        TestRunResponse testRunResponse = new TestRunAdapter().addTestRun(testRun, projectResponse.getId());
        TestResultResponse testResultResponse = new TestResultAdapter().addTestCaseResult(testResult, testRunResponse.getId(), testCaseResponse.getId());
        softAssert.assertEquals(projectResponse.getName(), project.getName());
        softAssert.assertEquals(sectionResponse.getName(), section.getName());
        softAssert.assertEquals(testCaseResponse.getTitle(), testCase.getTitle());
        softAssert.assertEquals(testRunResponse.getName(), testRun.getName());
        softAssert.assertEquals(testResultResponse.getStatusId(), testResult.getStatusId());
        softAssert.assertAll();
    }
}
