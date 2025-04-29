package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestResult {

    @SerializedName("status_id")
    @Expose
    int statusId;

    @Expose
    String comment;
}