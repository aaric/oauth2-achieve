package com.incarcloud.oauth2.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 *
 * @author Aaric, created on 2020-03-15T14:59.
 * @version 0.2.2-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Table
public class RbacUser {

    @Id
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
}
