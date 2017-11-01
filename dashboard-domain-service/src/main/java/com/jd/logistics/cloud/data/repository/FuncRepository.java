package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.Function;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 9:22
 */
@Mapper
public interface FuncRepository {

    @Select("SELECT id, func_name as funcName, func_type_id as funcType, seq FROM T_FUNCTION where func_type_id=#{type} order by seq")
    List<Function> getByType(@Param("type") int type);

    @Select("SELECT id, func_name as funcName, func_type_id as funcType, seq FROM T_FUNCTION order by seq")
    List<Function> getAll();

    @Update("UPDATE T_FUNCTION SET func_type_id=#{func.funcType}, seq=#{func.seq} WHERE func_name=#{func.funcName}")
    void update(@Param("func") Function func);
}
