package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    @Expose
    String name;

    @Expose
    String announcement;

    @SerializedName("show_announcement")
    @Expose
    boolean showAnnouncement;

    @SerializedName("suite_mode")
    @Expose
    int suiteMode;
}