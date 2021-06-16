package tbl.tool.english.mappers;

import org.springframework.stereotype.Service;
import tbl.tool.english.dto.VocabularyDTO;
import tbl.tool.english.entities.VocabularyEntity;
import tbl.tool.english.web.vm.InsertVocabularyVm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocabularyMapper {
    public List<VocabularyDTO> transferToListVocabularyDTOFromListEntity(List<VocabularyEntity> listEntity) {
        if (null == listEntity || listEntity.size() == 0) {
            return new ArrayList<>();
        }
        return listEntity.stream().map(
                entity -> VocabularyDTO
                        .builder()
                        .id(entity.getId().toHexString())
                        .en(entity.getEn())
                        .vn(entity.getVn())
                        .labelCode(entity.getLabelCode())
                        .build()
        ).collect(Collectors.toList());
    }

    public VocabularyEntity transferToVocabularyEntityFromInsertVm(InsertVocabularyVm insertVm) {
        return VocabularyEntity
                .builder()
                .en(insertVm.getEn())
                .vn(insertVm.getVn())
                .labelCode(insertVm.getLabelCode())
                .build();
    }
}
