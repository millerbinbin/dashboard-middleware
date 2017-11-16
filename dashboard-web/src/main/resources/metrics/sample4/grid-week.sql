select WAREHOUSE_NAME AS '仓库名称', MAX(FUNC_VALUE) AS '在库SKU',
MAX((CASE WHEN IDX_NAME = '周环比' THEN CONCAT(IDX_VALUE,'%') ELSE NULL END)) AS '周环比',
MAX((CASE WHEN IDX_NAME = '年同比' THEN CONCAT(IDX_VALUE,'%') ELSE NULL END)) AS '年同比',
MAX((CASE WHEN IDX_NAME = '整周数据' THEN IDX_VALUE ELSE NULL END)) AS '整周数据',
MAX((CASE WHEN IDX_NAME = '去年同周' THEN IDX_VALUE ELSE NULL END)) AS '去年同周'
from T_RESULT R join T_WAREHOUSE W on R.WAREHOUSE = W.ID
where func_name='发出订单量'
and date_cycle='week'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysdate}}',INTERVAL 13 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysdate}}','%Y/%m/%d')
group by warehouse_name, warehouse order by warehouse