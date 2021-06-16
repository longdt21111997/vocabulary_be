package tbl.tool.english.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tbl.tool.english.enums.EResponseStatus;

@Getter
@Setter
public class VTResponse<T> {
    @JsonProperty("result")
    private boolean result;
    @JsonProperty("number_code")
    private int numberCode;
    @JsonProperty("message")
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("meta_data")
    private Object metaData;

    public VTResponse() {
        this.result = true;
        this.numberCode = EResponseStatus.REQUEST_SUCCESS.getNumberCode();
        this.message = EResponseStatus.REQUEST_SUCCESS.getMessage();
    }

    public VTResponse(EResponseStatus eResponseStatus) {
        this.result = true;
        this.numberCode = eResponseStatus.getNumberCode();
        this.message = eResponseStatus.getMessage();
    }

    public VTResponse(boolean result, int numberCode, String message, T data, Object metaData) {
        this.result = result;
        this.numberCode = numberCode;
        this.message = message;
        this.data = data;
        this.metaData = metaData;
    }

    public VTResponse(boolean result, int numberCode, String message, Object metaData) {
        this.result = result;
        this.numberCode = numberCode;
        this.message = message;
        this.data = null;
        this.metaData = metaData;
    }

    public VTResponse(boolean result, EResponseStatus responseStatus, T data, Object metaData) {
        this.result = result;
        this.numberCode = responseStatus.getNumberCode();
        this.message = responseStatus.getMessage();
        this.data = data;
        this.metaData = metaData;
    }

    public VTResponse(T data) {
        this.result = true;
        this.numberCode = EResponseStatus.REQUEST_SUCCESS.getNumberCode();
        this.message = EResponseStatus.REQUEST_SUCCESS.getMessage();
        this.data = data;
    }

    public VTResponse(boolean result, EResponseStatus responseStatus) {
        this.result = result;
        this.numberCode = responseStatus.getNumberCode();
        this.message = responseStatus.getMessage();
    }

    public VTResponse(T data, Object metaData) {
        this.result = true;
        this.numberCode = EResponseStatus.REQUEST_SUCCESS.getNumberCode();
        this.message = EResponseStatus.REQUEST_SUCCESS.getMessage();
        this.data = data;
        this.metaData = metaData;
    }
}
