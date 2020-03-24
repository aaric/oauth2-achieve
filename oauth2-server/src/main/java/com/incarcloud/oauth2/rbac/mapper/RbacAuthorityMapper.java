package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacAuthority;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 权限信息DAO
 *
 * @author Aaric, created on 2020-03-24T16:16.
 * @version 0.8.0-SNAPSHOT
 */
public interface RbacAuthorityMapper extends Mapper<RbacAuthority>, MySqlMapper<RbacAuthority> {

    /**
     * 根据用户ID获得权限列表
     *
     * @param userId 用户ID
     * @return
     */
    List<RbacAuthority> selectByUserId(@Param("userId") Long userId);
}
