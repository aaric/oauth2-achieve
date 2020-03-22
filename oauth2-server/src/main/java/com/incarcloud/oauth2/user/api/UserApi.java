package com.incarcloud.oauth2.user.api;

import java.security.Principal;

/**
 * 用户API接口
 *
 * @author Aaric, created on 2020-03-22T15:22.
 * @version 0.4.2-SNAPSHOT
 */
public interface UserApi {

    Principal info(Principal principal);
}
