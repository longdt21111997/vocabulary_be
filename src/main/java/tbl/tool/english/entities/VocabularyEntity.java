package tbl.tool.english.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@Document("vocabulary")
public class VocabularyEntity {
    @Id
    @Field("_id")
    private ObjectId id;
    private String en;
    private String vn;
    private String labelCode;
}
