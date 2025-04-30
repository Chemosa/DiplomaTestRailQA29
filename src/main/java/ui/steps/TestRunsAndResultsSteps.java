package ui.steps;

import ui.entities.TestCase;
import ui.entities.TestRun;
import ui.pages.AddTestRunModalPage;
import ui.pages.ProjectPage;
import ui.pages.TestRunPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRunsAndResultsSteps extends BaseSteps {
    ProjectPage projectPage;
    AddTestRunModalPage addTestRunModalPage;
    TestRunPage testRunPage;

    public TestRunsAndResultsSteps(WebDriver driver) {
        super(driver);
        this.addTestRunModalPage = new AddTestRunModalPage(driver);
        this.testRunPage = new TestRunPage(driver);
        this.projectPage = new ProjectPage(driver);
    }

    @Step("Creates new test run.")
    public TestRunsAndResultsSteps checkCreatingTestRun(TestRun testRun) {
        projectPage
                .clickOnTestRunsSidebarItem()
                .addTestRunFromSidebar()
                .fillAddTestRunModal(testRun);
        softAssert.assertEquals(testRunPage.getTestRunName(), testRun.getTestRunName());
        softAssert.assertEquals(testRunPage.getTextFromInfoMessage(), "Successfully added the new test run.");
        softAssert.assertAll();
        return this;
    }

    @Step("Opens run option of specified test case and change status to \"Passed\".")
    public TestRunsAndResultsSteps changeRunStatusOfTestCaseToPassed(TestCase testCase) {
        testRunPage
                .openTestOptionsMenu(testCase)
                .clickPassAndNextButton();
        return this;
    }

    @Step("Check status of test case in test run.")
    public TestRunsAndResultsSteps checkTestStatusInRun(TestCase testCase, String status) {
        Assert.assertEquals(testRunPage.getTestCaseStatus(testCase), status);
        return this;
    }
}