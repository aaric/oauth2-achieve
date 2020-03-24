package com.incarcloud.oauth2.security.service.impl;

import com.incarcloud.oauth2.pojo.RbacAuthority;
import com.incarcloud.oauth2.pojo.RbacUser;
import com.incarcloud.oauth2.rbac.service.RbacAuthorityService;
import com.incarcloud.oauth2.rbac.service.RbacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户详情服务实现
 *
 * @author Aaric, created on 2020-03-15T16:40.
 * @version 0.2.2-SNAPSHOT
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RbacUserService rbacUserService;

    @Autowired
    private RbacAuthorityService rbacPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        RbacUser user = rbacUserService.getByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (null != user) {
            // 查询用户权限列表
            List<RbacAuthority> permissionList = rbacPermissionService.getByUserId(user.getId());

            // 设置用户权限字符串
            permissionList.forEach(object -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(object.getCode());
                grantedAuthorityList.add(grantedAuthority);
            });
        }

        // 由认证框架完成鉴权
        return new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
    }
}
