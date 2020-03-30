package com.incarcloud.oauth2.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.incarcloud.oauth2.pojo.RbacAuthority;
import com.incarcloud.oauth2.rbac.mapper.RbacAuthorityMapper;
import com.incarcloud.oauth2.rbac.service.RbacAuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限信息服务接口实现
 *
 * @author Aaric, created on 2020-03-24T16:32.
 * @version 0.8.0-SNAPSHOT
 */
@Service
public class RbacAuthorityServiceImpl extends ServiceImpl<RbacAuthorityMapper, RbacAuthority> implements RbacAuthorityService {

    @Override
    public List<RbacAuthority> getByUserId(Long userId) {
        return getBaseMapper().selectByUserId(userId);
    }
}
