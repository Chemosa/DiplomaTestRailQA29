package UI.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    String testcaseTitle;
    String template;
    String type;
    String priority;
    String preconditions;
    String steps;
    String expectedResult;
}
