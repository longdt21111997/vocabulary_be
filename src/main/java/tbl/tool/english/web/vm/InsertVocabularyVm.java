package tbl.tool.english.web.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertVocabularyVm {
    private String en;
    private String vn;
    @JsonProperty("label_code")
    private String labelCode;
}
