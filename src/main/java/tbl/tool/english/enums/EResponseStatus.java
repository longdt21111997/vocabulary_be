package tbl.tool.english.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EResponseStatus {
    REQUEST_SUCCESS(1,"request success"),
    REQUEST_FAIL(-1,"request failure"),
    INSERT_VOCABULARY_SUCCESS(2, "insert vocabulary success"),
    INSERT_VOCABULARY_FAILURE(-2, "insert vocabulary failure"),
    VOCABULARY_NOT_FOUND(-3, "vocabulary not found"),
    PROPERTY_COLLECTION_NOT_FOUND(-4, "field not found"),
    UPDATE_VOCABULARY_SUCCESS(5, "update vocabulary success"),
    UPDATE_VOCABULARY_FAILURE(-5, "update vocabulary failure"),
    DELETE_VOCABULARY_SUCCESS(6, "delete vocabulary success"),
    DELETE_VOCABULARY_FAILURE(-6, "delete vocabulary failure"),
    ;
    private final int numberCode;
    private final String message;
}
