package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 9:22
 */
@Mapper
public interface UserRepository {
    @Insert("INSERT into T_USER (name,age,addr) VALUES(#{name}, #{age}, #{addr})")
    void add(User user);

    @Select("SELECT * FROM T_USER WHERE id = #{id}")
    User getById(@Param("id") Long id);

    @Select("SELECT * FROM T_USER WHERE name = #{name}")
    User getByName(@Param("name") String name);

    @Update("UPDATE T_USER SET name=#{user.name}, age=#{user.age}, addr=#{user.addr} WHERE id=#{user.id}")
    void update(@Param("user") User user);

    @Delete("DELETE FROM T_USER WHERE id =#{id}")
    void delete(@Param("id") Long id);
}
