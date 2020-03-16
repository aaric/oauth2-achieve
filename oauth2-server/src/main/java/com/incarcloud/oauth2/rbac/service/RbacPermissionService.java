package com.incarcloud.oauth2.rbac.service;

import com.incarcloud.oauth2.pojo.RbacPermission;

import java.util.List;

/**
 * 权限信息服务接口
 *
 * @author Aaric, created on 2020-03-15T16:31.
 * @version 0.2.2-SNAPSHOT
 */
public interface RbacPermissionService {

    /**
     * 根据用户ID获得权限列表
     *
     * @param userId 用户ID
     * @return
     */
    List<RbacPermission> getByUserId(Long userId);
}
