package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestRunResponse {

    @Expose
    int id;

    @Expose
    String name;

    @SerializedName("include_all")
    @Expose
    boolean includeAll;
}