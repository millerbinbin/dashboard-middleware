select stat_date, cast(max(func_value)as signed) as func_value
from T_RESULT
where func_name='发出订单量'
and warehouse='#{{warehouse}}'
and date_cycle='day'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysdate}}',INTERVAL 13 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysdate}}','%Y/%m/%d')
group by stat_date order by stat_date