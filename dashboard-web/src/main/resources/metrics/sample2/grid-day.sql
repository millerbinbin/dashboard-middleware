select WAREHOUSE_NAME AS '仓库名称', MAX(FUNC_VALUE) AS '在库SKU',
MAX((CASE WHEN IDX_NAME = '日环比' THEN CONCAT(IDX_VALUE,'%') ELSE NULL END)) AS '日环比',
MAX((CASE WHEN IDX_NAME = '周同比' THEN CONCAT(IDX_VALUE,'%') ELSE NULL END)) AS '周同比',
MAX((CASE WHEN IDX_NAME = '昨日全天' THEN IDX_VALUE ELSE NULL END)) AS '昨日全天',
MAX((CASE WHEN IDX_NAME = '上周同日' THEN IDX_VALUE ELSE NULL END)) AS '上周同日'
from T_RESULT R join T_WAREHOUSE W on R.WAREHOUSE = W.ID
where func_name='接收订单量'
and date_cycle='day'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysdate}}',INTERVAL 13 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysdate}}','%Y/%m/%d')
group by warehouse_name, warehouse order by warehouse