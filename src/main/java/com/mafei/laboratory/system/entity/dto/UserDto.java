package com.mafei.laboratory.system.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author wutangsheng
 * @create 2021-02-17 17:51
 * @info
 */
@Getter
@Setter
public class UserDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String captcha;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}
