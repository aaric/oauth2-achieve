package com.incarcloud.oauth2client.hello.api.impl;

import com.incarcloud.oauth2client.hello.api.HelloApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问候API接口实现
 *
 * @author Aaric, created on 2020-03-15T22:56.
 * @version 0.3.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/oauth2client/hello")
public class HelloApiImpl implements HelloApi {

    @Override
    @GetMapping("/sayHi")
    public String sayHi() {
        return "Good night";
    }
}
