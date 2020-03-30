package com.incarcloud.oauth2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author Aaric, created on 2020-03-15T14:59.
 * @version 0.2.2-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@TableName
public class RbacUser {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String passwordSalt;
}
