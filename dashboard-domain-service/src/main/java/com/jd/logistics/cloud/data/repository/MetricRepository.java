package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.Metric;
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
public interface MetricRepository {

    @Select("SELECT concat('sample',id) as id, func_name as metricName, func_type_id as metricType, seq FROM T_FUNCTION where func_type_id=#{type} order by seq")
    List<Metric> getByType(@Param("type") int type);

    @Select("SELECT concat('sample',id) as id, func_name as metricName, func_type_id as metricType, seq FROM T_FUNCTION order by seq")
    List<Metric> getAll();

    @Update("UPDATE T_FUNCTION SET func_type_id=#{metric.metricType}, seq=#{metric.seq} WHERE concat('sample',id)=#{metric.id}")
    void update(@Param("metric") Metric metric);

    @Select("SELECT func_name as metricName FROM T_FUNCTION where concat('sample',id)=#{metricId}")
    String getMetricNameById(@Param("metricId") String metricId);
}
