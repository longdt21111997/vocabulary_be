package tbl.tool.english.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tbl.tool.english.entities.LabelEntity;

public interface LabelRepository extends MongoRepository<LabelEntity, ObjectId> {
}
