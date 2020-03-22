package com.incarcloud.oauth2.user.api.impl;

import com.incarcloud.oauth2.user.api.UserApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户API接口实现
 *
 * @author Aaric, created on 2020-03-22T15:24.
 * @version 0.4.2-SNAPSHOT
 */
@RestController
@RequestMapping("/oauth2/user")
public class UserApiImpl implements UserApi {

    @Override
    @GetMapping("/info")
    public Principal info(Principal principal) {
        return principal;
    }
}
