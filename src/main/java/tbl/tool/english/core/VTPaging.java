package tbl.tool.english.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VTPaging<T> {
    private int limit;
    private int skip;
    private T requestBody;
}
