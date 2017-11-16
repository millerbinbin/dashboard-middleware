package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 9:22
 */
@Mapper
public interface UserRepository {
    @Select("SELECT * FROM T_USER WHERE id = #{id}")
    User getById(@Param("id") Long id);

    @Select("SELECT * FROM T_USER WHERE username = #{username}")
    User getByUsername(@Param("username") String username);

    @Select("select GROUP_CONCAT(ROLE)as roles from T_USER_ROLE ur " +
            "INNER JOIN T_USER u on ur.USER_ID = u.ID " +
            "INNER JOIN T_ROLE r on ur.ROLE_ID = r.ID " +
            "where username=#{username}"
    )
    String getRolesByUsername(@Param("username") String username);
}
