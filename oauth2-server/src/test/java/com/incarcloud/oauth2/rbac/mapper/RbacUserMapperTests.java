package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacUser;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RbacUserMapperTests
 *
 * @author Aaric, created on 2020-03-15T15:02.
 * @version 0.2.2-SNAPSHOT
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RbacUserMapperTests {

    @Autowired
    private RbacUserMapper rbacUserMapper;

    @Test
    @Ignore
    public void testGet() {
        RbacUser user = rbacUserMapper.selectByPrimaryKey(1L);
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}
