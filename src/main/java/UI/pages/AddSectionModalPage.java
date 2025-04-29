package UI.pages;

import UI.elements.Button;
import UI.elements.Input;
import UI.entities.Section;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddSectionModalPage extends BasePage {

    public AddSectionModalPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method fills form to create section or subsection in project.
     * @param sectionOrSubsection
     * @return
     */
    public TestCasePage fillAddSectionModal(Section sectionOrSubsection) {
        new Input(driver).slowTypeToInput("editSectionName", sectionOrSubsection.getSectionName());
        new Button(driver).clickButton("editSectionSubmit");
        log.info("Section '{}' is created.", sectionOrSubsection.getSectionName());
        return new TestCasePage(driver);
    }
}
