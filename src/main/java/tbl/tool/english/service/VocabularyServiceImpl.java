package tbl.tool.english.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tbl.tool.english.core.PagingMetaData;
import tbl.tool.english.core.VTResponse;
import tbl.tool.english.dao.VocabularyDAO;
import tbl.tool.english.dto.VocabularyDTO;
import tbl.tool.english.entities.VocabularyEntity;
import tbl.tool.english.enums.EResponseStatus;
import tbl.tool.english.exceptions.PropertyOfCollectionNotFoundException;
import tbl.tool.english.exceptions.VocabularyNotFoundException;
import tbl.tool.english.mappers.VocabularyMapper;
import tbl.tool.english.repositories.VocabularyRepository;
import tbl.tool.english.web.vm.InsertVocabularyVm;
import tbl.tool.english.web.vm.UpdateVocabularyVm;

import java.util.List;

@Service
@Log4j2
public class VocabularyServiceImpl implements VocabularyService {
    private final VocabularyDAO vocabularyDAO;
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyMapper vocabularyMapper;
    private static final String EN_FIELD = "en";
    private static final String VN_FIELD = "vn";
    private static final String LABEL_CODE = "label_code";

    public VocabularyServiceImpl(VocabularyDAO vocabularyDAO, VocabularyRepository vocabularyRepository, VocabularyMapper vocabularyMapper) {
        this.vocabularyDAO = vocabularyDAO;
        this.vocabularyRepository = vocabularyRepository;
        this.vocabularyMapper = vocabularyMapper;
    }


    @Override
    public VTResponse<List<VocabularyDTO>> findVocabulary(String enWord, String vnWord, int limit, int skip) {
        List<VocabularyEntity> vocabularyEntityList = vocabularyDAO.findVocabulary(enWord, vnWord, limit, skip);
        List<VocabularyDTO> vocabularyDTOList = vocabularyMapper.transferToListVocabularyDTOFromListEntity(vocabularyEntityList);
        long totalRecord = vocabularyDAO.getTotalRecord(enWord, vnWord);
        PagingMetaData pagingMetaData = new PagingMetaData(limit, skip, totalRecord);
        return new VTResponse<>(vocabularyDTOList, pagingMetaData);
    }

    @Override
    public VTResponse<Void> insertVocabulary(InsertVocabularyVm vm) {
        try {
            VocabularyEntity entity = vocabularyMapper.transferToVocabularyEntityFromInsertVm(vm);
            vocabularyRepository.save(entity);
            return new VTResponse<>(true, EResponseStatus.INSERT_VOCABULARY_SUCCESS);
        } catch (Exception e) {
            log.error(e);
            return new VTResponse<>(false, EResponseStatus.INSERT_VOCABULARY_FAILURE);
        }
    }

    @Override
    public VTResponse<Void> updateVocabulary(String id, UpdateVocabularyVm vm) {
        try {
            VocabularyEntity entity = vocabularyRepository.findById(id).orElseThrow(VocabularyNotFoundException::new);
            List<UpdateVocabularyVm.UpdateProperty> updateVm = vm.getUpdateVm();
            updateVm.forEach(updateProperty -> {
                switch (updateProperty.getField()) {
                    case EN_FIELD:
                        entity.setEn(updateProperty.getValue());
                        break;
                    case VN_FIELD:
                        entity.setVn(updateProperty.getValue());
                        break;
                    case LABEL_CODE:
                        entity.setLabelCode(updateProperty.getValue());
                        break;
                    default:
                        throw new PropertyOfCollectionNotFoundException();
                }
            });
            vocabularyRepository.save(entity);
            return new VTResponse<>(true,EResponseStatus.UPDATE_VOCABULARY_SUCCESS);
        } catch (VocabularyNotFoundException vocabularyNotFoundException) {
            return new VTResponse<>(false, EResponseStatus.VOCABULARY_NOT_FOUND);
        } catch (Exception e) {
            log.error(e);
            return new VTResponse<>(false, EResponseStatus.UPDATE_VOCABULARY_FAILURE);
        }
    }

    @Override
    public VTResponse<Void> deleteVocabulary(String id) {
        try{
            VocabularyEntity entity = vocabularyRepository.findById(id).orElseThrow(VocabularyNotFoundException::new);
            vocabularyRepository.delete(entity);
            return new VTResponse<>(true,EResponseStatus.DELETE_VOCABULARY_SUCCESS);
        }catch (Exception exception){
            return new VTResponse<>(false,EResponseStatus.DELETE_VOCABULARY_FAILURE);
        }
    }
}
