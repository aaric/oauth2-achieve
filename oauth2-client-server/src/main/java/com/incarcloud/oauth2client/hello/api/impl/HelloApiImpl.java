package com.incarcloud.oauth2client.hello.api.impl;

import com.incarcloud.oauth2client.hello.api.HelloApi;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/oauth2client/hello")
public class HelloApiImpl implements HelloApi {

    @Override
    @GetMapping("/morning")
    @PreAuthorize("hasAuthority('oauth2client:hello:morning')")
    public String morning() {
        return "Good morning!";
    }

    @Override
    @GetMapping("/afternoon")
    @PreAuthorize("hasAuthority('oauth2client:hello:afternoon')")
    public String afternoon() {
        return "Good afternoon!";
    }

    @Override
    @GetMapping("/night")
    @PreAuthorize("hasAuthority('oauth2client:hello:night')")
    public String night() {
        return "Good night!";
    }
}
