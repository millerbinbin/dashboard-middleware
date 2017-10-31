package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 9:22
 */
@Mapper
public interface FuncRepository {

    @Select("SELECT id, name as funcName, type as funcType, seq FROM T_FUNCTION where type=#{type}order by seq")
    List<Function> getByType(@Param("type") int type);

    @Select("SELECT id, name as funcName, type as funcType, seq FROM T_FUNCTION order by seq")
    List<Function> getAll();

    @Update("UPDATE T_FUNCTION SET type=#{func.funcType}, seq=#{func.seq} WHERE name=#{func.funcName}")
    void update(@Param("func") Function func);
}
