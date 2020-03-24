package com.incarcloud.oauth2.rbac.service.impl;

import com.incarcloud.oauth2.pojo.RbacAuthority;
import com.incarcloud.oauth2.rbac.mapper.RbacAuthorityMapper;
import com.incarcloud.oauth2.rbac.service.RbacAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限信息服务接口实现
 *
 * @author Aaric, created on 2020-03-24T16:32.
 * @version 0.8.0-SNAPSHOT
 */
@Service
public class RbacAuthorityServiceImpl implements RbacAuthorityService {

    @Autowired
    private RbacAuthorityMapper rbacAuthorityMapper;

    @Override
    public List<RbacAuthority> getByUserId(Long userId) {
        return rbacAuthorityMapper.selectByUserId(userId);
    }
}
