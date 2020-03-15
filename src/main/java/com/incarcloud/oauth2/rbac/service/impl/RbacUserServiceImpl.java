package com.incarcloud.oauth2.rbac.service.impl;

import com.incarcloud.oauth2.pojo.RbacUser;
import com.incarcloud.oauth2.rbac.mapper.RbacUserMapper;
import com.incarcloud.oauth2.rbac.service.RbacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户信息服务接口实现
 *
 * @author Aaric, created on 2020-03-15T15:35.
 * @version 0.2.2-SNAPSHOT
 */
@Service
public class RbacUserServiceImpl implements RbacUserService {

    @Autowired
    private RbacUserMapper rbacUserMapper;

    @Override
    public RbacUser getByUsername(String username) {
        Example example = new Example(RbacUser.class);
        example.createCriteria().andEqualTo("username", username);
        return rbacUserMapper.selectByPrimaryKey(1L);
    }
}
