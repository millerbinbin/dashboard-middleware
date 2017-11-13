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
    User getByName(@Param("username") String username);

}
