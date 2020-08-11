package com.wsl.flight.common.response;

import lombok.AllArgsConstructor;

/**
 * @author JefferyChang
 * @date 2019/12/2
 */
@AllArgsConstructor
public enum EnumResultCode {

    OK("1000", "请求成功"),
    FAIL("5000", "请求服务器异常"),
    ERROR_VALIDATE_PARAMETER("5009", "参数校验异常"),
    ERROR_DIV_EXCEPTION("5004", "div by zero"),
    ERROR_TASK_ORDER_NUM("5006", "子订单数量大于认购数量，下单失败！");

    private String code;

    private String resultMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
