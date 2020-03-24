package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacAuthority;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * RbacPermissionMapperTests
 *
 * @author Aaric, created on 2020-03-24T16:26.
 * @version 0.8.0-SNAPSHOT
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RbacAuthorityMapperTests {

    @Autowired
    private RbacAuthorityMapper rbacAuthorityMapper;

    @Test
    @Ignore
    public void testSelectByUserId() {
        List<RbacAuthority> list = rbacAuthorityMapper.selectByUserId(1L);
        list.forEach(object -> System.out.println(object));
        Assert.assertNotEquals(0, list.size());
    }
}
