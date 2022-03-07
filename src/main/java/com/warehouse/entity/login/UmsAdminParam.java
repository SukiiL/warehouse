package com.warehouse.entity.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户注册参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class  UmsAdminParam {
    @NotEmpty
    //ModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    //ModelProperty(value = "密码", required = true)
    private String password;
    //ModelProperty(value = "用户头像")
    private String icon;
    @Email
    //ModelProperty(value = "邮箱")
    private String email;
    //ModelProperty(value = "用户昵称")
    private String nickName;
    //ModelProperty(value = "备注")
    private String note;
}
