package com.wsl.provider.model.vo;

import com.wsl.flight.common.model.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseVO extends BaseVO {

    /***
     * 习题名称
     */
    private String name;

}
