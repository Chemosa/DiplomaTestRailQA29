package api.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestResultResponse {

    @SerializedName("status_id")
    @Expose
    int statusId;

    @SerializedName("test_id")
    @Expose
    int testId;

    @Expose
    int id;

    @Expose
    String comment;
}