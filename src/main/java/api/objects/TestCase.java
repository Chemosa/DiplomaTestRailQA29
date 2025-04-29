package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    @SerializedName("section_id")
    @Expose
    int sectionId;

    @Expose
    String title;
}