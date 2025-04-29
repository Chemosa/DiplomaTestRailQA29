package UI.pages;

import UI.elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRunsAndResultsPage extends BasePage {

    @FindBy(id = "navigation-runs-add")
    WebElement addTestRunOnSidebarButton;

    public TestRunsAndResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on 'Add Test Run' button on the sidebar.
     * @return
     */
    public AddTestRunModalPage addTestRunFromSidebar() {
        new Button(driver).clickElementButton(addTestRunOnSidebarButton);
        return new AddTestRunModalPage(driver);
    }
}