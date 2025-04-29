package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCaseResponse {

    @Expose
    int id;

    @Expose
    String title;

    @SerializedName("section_id")
    @Expose
    String sectionId;
}