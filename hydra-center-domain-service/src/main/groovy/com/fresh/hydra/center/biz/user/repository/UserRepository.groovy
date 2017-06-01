package com.fresh.hydra.center.biz.user.repository

import com.fresh.commons.data.page.PageRequest
import com.fresh.hydra.center.biz.user.domain.User
import com.fresh.hydra.center.biz.user.domain.UserQuery
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

/**
 * Created by yanhua on 2017/2/3.
 */
@Mapper
public interface UserRepository {

    @Insert("INSERT into T_USER (name,age,addr) VALUES(#{name}, #{age}, #{addr})")
    void add(User user);

    @Select("SELECT * FROM T_USER WHERE id = #{id}")
    User getById(@Param("id") Long id);

    @Select("""<script>SELECT * FROM T_USER WHERE 1=1
                    <if test="query.name != null"> AND name like #{query.name}</if>
                    <if test="query.addr != null"> AND addr = #{query.addr}</if>
                    <if test="query.age != null"> AND age = #{query.age}</if>
                    limit #{page.offset} , #{page.pageSize}
               </script>
            """)
    List<User> findUserList(@Param("query") UserQuery query, @Param("page") PageRequest pageRequest);

    @Select("""<script>SELECT COUNT(id) FROM T_USER  WHERE 1=1
                    <if test="query.name != null"> AND name like #{query.name}</if>
                    <if test="query.addr != null"> AND addr = #{query.addr}</if>
                    <if test="query.age != null"> AND age = #{query.age}</if>
                </script>
      """)
    long count(@Param("query")  UserQuery query);

    @Select("SELECT * FROM T_USER WHERE name = #{name}")
    User getByName(@Param("name") String name)


    @Update("UPDATE T_USER SET name=#{user.name}, age=#{user.age}, addr=#{user.addr} WHERE id=#{user.id}")
    void update(@Param("user") User user);

    @Delete("DELETE FROM T_USER WHERE id =#{id}")
    void delete(@Param("id") Long id);
}
