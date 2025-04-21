package apiTests;

import api.adapters.ProjectAdapter;
import api.objects.Project;
import api.objects.ProjectResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRailTest {

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .name("Project1")
                .announcement("Announcement test")
                .showAnnouncement(true)
                .build();
        ProjectResponse projectResponse = new ProjectAdapter().addProject(project);
        Assert.assertEquals(projectResponse.getName(), project.getName());
    }
}
