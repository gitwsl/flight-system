package com.wsl.flight.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author JefferyChang
 * @date 2019/12/2
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject<T> implements Serializable {

    /**
     * 执行是否成功
     */
    private String status;
    /**
     * 执行提示信息
     */
    private String msg;
    /**
     * 服务器当前时间戳
     */
    //private Long ts = System.currentTimeMillis();
    /**
     * 返回的code
     */
    private String code;
    /**
     * 返回的数据
     */
    private T data;

    public static ResponseObject ofSuccess() {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.SUCCESS;
        result.code = EnumResultCode.OK.getCode();
        result.msg = EnumResultCode.OK.getResultMsg();
        return result;
    }

    public static ResponseObject ofSuccess(EnumResultCode resultCode) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.SUCCESS;
        result.code = resultCode.getCode();
        result.msg = resultCode.getResultMsg();
        return result;
    }

    public static ResponseObject ofSuccess(Object data) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.SUCCESS;
        result.code = EnumResultCode.OK.getCode();
        result.msg = EnumResultCode.OK.getResultMsg();
        result.setData(data);
        return result;
    }

    public static ResponseObject ofFail(String code, String msg) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.FAIL;
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static ResponseObject ofFail(String code, String msg, Object data) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.FAIL;
        result.code = code;
        result.msg = msg;
        result.setData(data);
        return result;
    }

    public static ResponseObject ofFail(EnumResultCode resultEnum) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.FAIL;
        result.code = resultEnum.getCode();
        result.msg = resultEnum.getResultMsg();
        return result;
    }

    public static ResponseObject ofFail(EnumResultCode resultEnum, Object data) {
        ResponseObject result = new ResponseObject();
        result.status = ResultConsts.FAIL;
        result.code = resultEnum.getCode();
        result.msg = resultEnum.getResultMsg();
        result.data = data;
        return result;
    }


}
