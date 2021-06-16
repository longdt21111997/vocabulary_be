package tbl.tool.english.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagingMetaData {
    private int limit;
    private int  skip;
    private Long totalRecords;
}
