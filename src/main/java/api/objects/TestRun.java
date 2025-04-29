package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestRun {

    @Expose
    String name;

    @SerializedName("suite_id")
    @Expose
    int suiteId;

    @SerializedName("include_all")
    @Expose
    boolean includeAll;
}