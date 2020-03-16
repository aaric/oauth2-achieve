package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 权限信息DAO
 *
 * @author Aaric, created on 2020-03-15T16:16.
 * @version 0.2.2-SNAPSHOT
 */
public interface RbacPermissionMapper extends Mapper<RbacPermission>, MySqlMapper<RbacPermission> {

    /**
     * 根据用户ID获得权限列表
     *
     * @param userId 用户ID
     * @return
     */
    List<RbacPermission> selectByUserId(@Param("userId") Long userId);
}
