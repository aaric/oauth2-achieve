package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 用户信息DAO
 *
 * @author Aaric, created on 2020-03-15T14:54.
 * @version 0.2.2-SNAPSHOT
 */
public interface RbacUserMapper extends Mapper<RbacUser>, MySqlMapper<RbacUser>/*,
        IdsMapper<RbacUser>, ConditionMapper<RbacUser>, ExampleMapper<RbacUser>*/ {
}
