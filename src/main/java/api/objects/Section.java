package api.objects;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {

    @Expose
    String name;

    @Expose
    String description;
}
