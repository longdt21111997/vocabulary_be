package tbl.tool.english.exceptions;

import tbl.tool.english.enums.EResponseStatus;

public class VocabularyNotFoundException extends RuntimeException {
    public VocabularyNotFoundException() {
        super(EResponseStatus.VOCABULARY_NOT_FOUND.getMessage());
    }
}

