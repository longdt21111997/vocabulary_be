package tbl.tool.english.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document("label")
public class LabelEntity {
    @Id
    @Field("_id")
    private ObjectId id;
    private String labelCode;
    private String description;
}
