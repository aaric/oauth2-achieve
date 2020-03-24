package com.incarcloud.oauth2.rbac.service;

import com.incarcloud.oauth2.pojo.RbacAuthority;

import java.util.List;

/**
 * 权限信息服务接口
 *
 * @author Aaric, created on 2020-03-24T16:31.
 * @version 0.8.0-SNAPSHOT
 */
public interface RbacAuthorityService {

    /**
     * 根据用户ID获得权限列表
     *
     * @param userId 用户ID
     * @return
     */
    List<RbacAuthority> getByUserId(Long userId);
}
