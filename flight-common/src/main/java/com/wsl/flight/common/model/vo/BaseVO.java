package com.wsl.flight.common.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Data
public class BaseVO {
    private Integer id;

    private Date updatedTime;

    private Date createdTime;

    private Integer deletedFlag;

}
