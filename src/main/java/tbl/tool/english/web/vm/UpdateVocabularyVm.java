package tbl.tool.english.web.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateVocabularyVm {
    @JsonProperty("update_vm")
    private List<UpdateProperty> updateVm;

    @Getter
    @Setter
    public static class UpdateProperty{
        @JsonProperty("field")
        private String field;
        @JsonProperty("value")
        private String value;
    }
}
