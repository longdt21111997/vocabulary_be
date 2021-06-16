package tbl.tool.english.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import tbl.tool.english.entities.VocabularyEntity;

import java.util.List;

@Repository
public class VocabularyDAO {
    private final MongoTemplate mongoTemplate;

    public VocabularyDAO(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Query buildBaseQueryForFindVocabulary(String enWord, String vnWord){
        Query query = new Query();
        if (null != enWord && !enWord.isEmpty()) {
            query.addCriteria(Criteria.where("en").regex(enWord, "i"));
        }
        if (null != vnWord && !vnWord.isEmpty()) {
            query.addCriteria(Criteria.where("vn").regex(vnWord, "i"));
        }
        return query;
    }

    public Long getTotalRecord(String enWord, String vnWord){
        Query query = buildBaseQueryForFindVocabulary(enWord,vnWord);
        return mongoTemplate.count(query,VocabularyEntity.class);
    }

    public List<VocabularyEntity> findVocabulary(String enWord, String vnWord, int limit, int skip) {
        Query query = buildBaseQueryForFindVocabulary(enWord,vnWord);
        return mongoTemplate.find(query.with(Sort.by(Sort.Direction.ASC,"en")).limit(limit).skip(skip),VocabularyEntity.class);
    }
}
