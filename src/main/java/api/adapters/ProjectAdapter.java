package api.adapters;

import api.objects.Project;
import api.objects.ProjectResponse;
import com.google.gson.Gson;

public class ProjectAdapter extends BaseAdapter{

    public ProjectResponse addProject(Project project) {
        return new Gson().fromJson(post(ADD_PROJECT_ENDPOINT, gson.toJson(project)), ProjectResponse.class);
    }
}
