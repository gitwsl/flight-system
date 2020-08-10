package com.wsl.flight.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;

/**
 * @author amos
 */
@Data
@NoArgsConstructor
public class ResultDataEntity implements Serializable {

    protected boolean status = true;
    protected String msg;
    protected Integer code;
    @JsonInclude(ALWAYS)
    private Object data;

    public ResultDataEntity(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResultDataEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDataEntity(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}
