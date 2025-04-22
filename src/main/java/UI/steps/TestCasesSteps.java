package UI.steps;

import UI.entities.Project;
import UI.entities.Section;
import UI.entities.TestCase;
import UI.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesSteps extends BaseSteps {
    ProjectsListPage projectsListPage;
    AddProjectModalPage addProjectModalPage;
    ProjectPage projectPage;
    HeaderPage headerPage;
    AdminPage adminPage;
    TestCasePage testCasePage;
    AddSectionModalPage addSectionModalPage;

    public TestCasesSteps(WebDriver driver) {
        super(driver);
        this.projectsListPage = new ProjectsListPage(driver);
        this.addProjectModalPage = new AddProjectModalPage(driver);
        this.projectPage = new ProjectPage(driver);
        this.headerPage = new HeaderPage(driver);
        this.adminPage = new AdminPage(driver);
        this.testCasePage = new TestCasePage(driver);
    }

    @Step("Creates section in project.")
    public TestCasesSteps createSection(Project project, Section section) {
        projectPage
                .clickOnTestCasesSidebarItem(project.getProjectName())
                .clickAddSectionButton()
                .fillAddSectionModal(section);
        Assert.assertTrue(testCasePage.isSectionCreated(section.getSectionName()));
        return this;
    }

    @Step("Creates subsection in section.")
    public TestCasesSteps createSubsection(Section subsection) {
        testCasePage
                .clickAddSubsectionButton()
                .fillAddSectionModal(subsection);
        Assert.assertTrue(testCasePage.isSectionCreated(subsection.getSectionName()));
        return this;
    }

    @Step("Deletes specified section.")
    public TestCasesSteps deleteSection(Section section) {
        testCasePage
                .deleteSection(section);
        Assert.assertTrue(testCasePage.sectionNamesList().isEmpty());
        return this;
    }

    @Step("Creates new test case with button on sidebar.")
    public TestCasesSteps createTestCaseFromSidebar(TestCase testcase) {
        testCasePage.clickAddTestCaseButton()
                .fillAddTestCaseModal(testcase);
        Assert.assertEquals(testCasePage.getTestCaseName(), testcase.getTestcaseTitle());
        return this;
    }

    @Step("Creates some cases with default parameters in section.")
    public TestCasesSteps createCaseFromSection(TestCase... testCases) {
        testCasePage
                .clickAddCaseLink()
                .addCase(testCases);
        Assert.assertTrue(testCasePage.isTestCaseInList(testCases));
        return this;
    }
}