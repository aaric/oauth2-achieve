package com.incarcloud.oauth2.rbac.service;

import com.incarcloud.oauth2.pojo.RbacUser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RbacUserServiceTests
 *
 * @author Aaric, created on 2020-03-15T15:38.
 * @version 0.2.2-SNAPSHOT
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RbacUserServiceTests {

    @Autowired
    private RbacUserService rbacUserService;

    @Test
    @Ignore
    public void testGetByUsername() {
        RbacUser user = rbacUserService.getByUsername("admin");
        System.out.println(user);
    }
}
