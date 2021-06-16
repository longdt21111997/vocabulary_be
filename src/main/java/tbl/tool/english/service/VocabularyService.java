package tbl.tool.english.service;

import tbl.tool.english.core.VTResponse;
import tbl.tool.english.dto.VocabularyDTO;
import tbl.tool.english.web.vm.InsertVocabularyVm;
import tbl.tool.english.web.vm.UpdateVocabularyVm;

import java.util.List;

public interface VocabularyService {
    VTResponse<List<VocabularyDTO>> findVocabulary(String enWord, String vnWord, int limit, int skip);

    VTResponse<Void> insertVocabulary(InsertVocabularyVm vm);

    VTResponse<Void> updateVocabulary(String id,UpdateVocabularyVm vm);

    VTResponse<Void> deleteVocabulary(String id);
}
