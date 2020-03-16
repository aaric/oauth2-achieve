package com.incarcloud.oauth2.hello.api.impl;

import com.incarcloud.oauth2.hello.api.HelloApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问候API接口实现
 *
 * @author Aaric, created on 2020-02-28T11:24.
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/oauth2/hello")
public class HelloApiImpl implements HelloApi {

    @Override
    @GetMapping("/sayHi")
    public String sayHi() {
        return "Good morning";
    }
}
