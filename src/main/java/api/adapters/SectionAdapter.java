package api.adapters;

import api.objects.Section;
import api.objects.SectionResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SectionAdapter extends BaseAdapter {

    /**
     * This method send POST request to add new section to project and transfer obtained response to json.
     * @param section
     * @param projectId
     * @return
     */
    public SectionResponse addSection(Section section, int projectId) {
        return new Gson().fromJson(post(String.format(ADD_SECTION_ENDPOINT, projectId), gson.toJson(section)), SectionResponse.class);
    }
}

