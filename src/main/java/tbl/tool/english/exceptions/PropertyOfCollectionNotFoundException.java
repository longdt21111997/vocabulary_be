package tbl.tool.english.exceptions;

import tbl.tool.english.enums.EResponseStatus;

public class PropertyOfCollectionNotFoundException extends RuntimeException {
    public PropertyOfCollectionNotFoundException() {
        super(EResponseStatus.PROPERTY_COLLECTION_NOT_FOUND.getMessage());
    }
}
