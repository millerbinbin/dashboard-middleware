package com.jd.logistics.cloud.data.repository;

import com.jd.logistics.cloud.data.domain.DimQuery;
import com.jd.logistics.cloud.data.domain.GenericRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 17:41
 */
@Mapper
public interface StatRepository {
    @Select("<script>" +
            "SELECT FUNC_NAME as funcName, MAX(FUNC_VALUE) as funcValue, STAT_DATE as statDate, " +
            " '日环比' as idxName1," +
            " MAX(CASE WHEN IDX_NAME='日环比' then IDX_VALUE else NULL END) as idxValue1," +
            " '周同比' as idxName2," +
            " MAX(CASE WHEN IDX_NAME='周同比' then IDX_VALUE else NULL END) as idxValue2," +
            " '上周同日' as idxName3," +
            " MAX(CASE WHEN IDX_NAME='上周同日' then IDX_VALUE else NULL END) as idxValue3," +
            " '昨日全天' as idxName4," +
            " MAX(CASE WHEN IDX_NAME='昨日全天' then IDX_VALUE else NULL END) as idxValue4," +
            " '整周数据' as idxName5," +
            " MAX(CASE WHEN IDX_NAME='整周数据' then IDX_VALUE else NULL END) as idxValue5," +
            " '去年同周' as idxName6," +
            " MAX(CASE WHEN IDX_NAME='去年同周' then IDX_VALUE else NULL END) as idxValue6," +
            " '周环比' as idxName7," +
            " MAX(CASE WHEN IDX_NAME='周环比' then IDX_VALUE else NULL END) as idxValue7," +
            " '年同比' as idxName8," +
            " MAX(CASE WHEN IDX_NAME='年同比' then IDX_VALUE else NULL END) as idxValue8," +
            " '去年同月' as idxName9," +
            " MAX(CASE WHEN IDX_NAME='去年同月' then IDX_VALUE else NULL END) as idxValue9," +
            " '整月数据' as idxName10," +
            " MAX(CASE WHEN IDX_NAME='整月数据' then IDX_VALUE else NULL END) as idxValue10," +
            " '月环比' as idxName11," +
            " MAX(CASE WHEN IDX_NAME='月环比' then IDX_VALUE else NULL END) as idxValue11" +
            " FROM T_RESULT where 1=1" +
            "<if test='query.warehouse != null'> AND WAREHOUSE_NAME=#{query.warehouse}</if>" +
            "<if test='query.funcName != null'> AND FUNC_NAME=#{query.funcName}</if>" +
            "<if test='query.dateCycle != null'> AND DATE_CYCLE=#{query.dateCycle}</if>" +
            "<if test='query.statDate != null'> AND STAT_DATE=#{query.statDate}</if>" +
            " GROUP BY FUNC_NAME, STAT_DATE" +
            "</script>"
    )
    GenericRes getOneRes(@Param("query") DimQuery query); // one row result (warehouse, funcName, statDate)

    @Select("<script>" +
            "SELECT FUNC_NAME as funcName, MAX(FUNC_VALUE) as funcValue, STAT_DATE as statDate " +
            " FROM T_RESULT where 1=1" +
            "<if test='query.warehouse != null'> AND WAREHOUSE_NAME=#{query.warehouse}</if>" +
            "<if test='query.funcName != null'> AND FUNC_NAME=#{query.funcName}</if>" +
            "<if test='query.dateCycle != null'> AND DATE_CYCLE=#{query.dateCycle}</if>" +
            "<if test='query.dateStart != null and query.dateEnd != null'> AND STAT_DATE between #{query.dateStart} and #{query.dateEnd}</if>" +
            " GROUP BY FUNC_NAME, STAT_DATE ORDER BY STAT_DATE" +
            "</script>"
    )
    List<GenericRes> getResList(@Param("query") DimQuery query); // mutiple row results (warehouse, funcName, statDate)
}
