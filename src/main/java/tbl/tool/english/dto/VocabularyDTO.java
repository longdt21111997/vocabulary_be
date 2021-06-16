package tbl.tool.english.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VocabularyDTO {
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String en;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String vn;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("label_code")
    private String labelCode;
}
