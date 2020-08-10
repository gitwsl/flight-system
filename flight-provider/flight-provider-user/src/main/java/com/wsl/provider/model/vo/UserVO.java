package com.wsl.provider.model.vo;

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
public class UserVO{
//    @NotBlank(message = "用户名不能为空")
    private String name;

//    @Max(value = 30, message = "年龄不能超过30岁")
    private Integer age;

}
