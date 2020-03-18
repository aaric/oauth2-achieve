package com.incarcloud.oauth2.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限信息
 *
 * @author Aaric, created on 2020-03-15T16:14.
 * @version 0.2.2-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Table
public class RbacPermission {

    @Id
    private Long id;
    private Long parentId;
    private String name;
    private String enname;
    private String url;
    private String description;
}
