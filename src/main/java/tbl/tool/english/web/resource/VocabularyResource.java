package tbl.tool.english.web.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbl.tool.english.core.VTResponse;
import tbl.tool.english.dto.VocabularyDTO;
import tbl.tool.english.service.VocabularyService;
import tbl.tool.english.web.vm.InsertVocabularyVm;
import tbl.tool.english.web.vm.UpdateVocabularyVm;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vocabulary")
public class VocabularyResource {
    private final VocabularyService vocabularyService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<VTResponse<List<VocabularyDTO>>> findVocabulary(
            @RequestParam(name = "en", required = false) String enWord,
            @RequestParam(name = "vn", required = false) String vnWord,
            @RequestParam(name = "limit", defaultValue = "20") int limit,
            @RequestParam(name = "skip", defaultValue = "0") int skip) {
        return new ResponseEntity<>(vocabularyService.findVocabulary(enWord, vnWord, limit, skip), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<VTResponse<Void>> insertVocabulary(@RequestBody InsertVocabularyVm vm) {
        return new ResponseEntity<>(vocabularyService.insertVocabulary(vm), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<VTResponse<Void>> updateVocabularyById(
            @PathVariable(name = "id") String id,
            @RequestBody UpdateVocabularyVm vm) {
        return new ResponseEntity<>(vocabularyService.updateVocabulary(id, vm), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<VTResponse<Void>> deleteVocabularyById(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(vocabularyService.deleteVocabulary(id), HttpStatus.OK);
    }
}
