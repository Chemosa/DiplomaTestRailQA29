package api.adapters;

import api.objects.Project;
import api.objects.ProjectResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectAdapter extends BaseAdapter {

    /**
     * This method send POST request to add new project and transfer obtained response to json.
     * @param project
     * @return
     */
    public ProjectResponse addProject(Project project) {
        return new Gson().fromJson(post(ADD_PROJECT_ENDPOINT, gson.toJson(project)), ProjectResponse.class);
    }

    /**
     * This method send GET request to get project with certain ID and transfer obtained response to json.
     * @param projectId
     * @return
     */
    public ProjectResponse getProject(int projectId) {
        return new Gson().fromJson(get(String.format(GET_PROJECT_ENDPOINT, projectId)), ProjectResponse.class);
    }
}
