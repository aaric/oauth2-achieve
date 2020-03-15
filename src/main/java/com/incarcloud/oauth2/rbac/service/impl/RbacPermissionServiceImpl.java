package com.incarcloud.oauth2.rbac.service.impl;

import com.incarcloud.oauth2.pojo.RbacPermission;
import com.incarcloud.oauth2.rbac.mapper.RbacPermissionMapper;
import com.incarcloud.oauth2.rbac.service.RbacPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限信息服务接口实现
 *
 * @author Aaric, created on 2020-03-15T16:32.
 * @version 0.2.2-SNAPSHOT
 */
@Service
public class RbacPermissionServiceImpl implements RbacPermissionService {

    @Autowired
    private RbacPermissionMapper rbacPermissionMapper;

    @Override
    public List<RbacPermission> getByUserId(Long userId) {
        return rbacPermissionMapper.selectByUserId(userId);
    }
}
