package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.DateCycle;
import com.jd.logistics.cloud.data.domain.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 9:22
 */
@Mapper
public interface DimRepository {
    @Select("SELECT id, warehouse_name as warehouseName FROM T_WAREHOUSE")
    List<Warehouse> getWarehouses();

    @Select("SELECT id, date_cycle as dateCycle FROM T_DATE_CYCLE")
    List<DateCycle> getDateCycles();

}
