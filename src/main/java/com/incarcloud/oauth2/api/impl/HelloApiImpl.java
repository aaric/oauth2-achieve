package com.incarcloud.oauth2.api.impl;

import com.incarcloud.oauth2.api.HelloApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问候API接口实现
 *
 * @author Aaric, created on 2020-02-28T11:24.
 * @version 0.0.1-SNAPSHOT
 */
@RestController
public class HelloApiImpl implements HelloApi {

    @Override
    @GetMapping("/oauth2/hello/sayHi")
    public String sayHi() {
        return "Good morning";
    }
}
