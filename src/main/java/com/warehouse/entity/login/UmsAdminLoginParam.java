package com.warehouse.entity.login;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {
    @NotEmpty
    //ModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    //ModelProperty(value = "密码",required = true)
    private String password;
}
