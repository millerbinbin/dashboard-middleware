package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.Dim;
import com.jd.logistics.cloud.data.domain.DimQuery;
import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.domain.GenericRes;
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
public interface DimRepository {
    @Select("SELECT * FROM T_WAREHOUSE")
    List<Dim> getWarehouses();

    @Select("SELECT * FROM T_DATECYCLE")
    List<Dim> getDateCycles();

}
