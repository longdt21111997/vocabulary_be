package tbl.tool.english.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tbl.tool.english.entities.VocabularyEntity;

import java.util.Optional;

public interface VocabularyRepository extends MongoRepository<VocabularyEntity, ObjectId> {
    @Query(value = "{'_id': ?0 }")
    Optional<VocabularyEntity> findById(String id);
}
