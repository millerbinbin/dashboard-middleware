select stat_date, cast(max(func_value)as signed) as func_value
from T_RESULT
where func_name='在库SKU'
and warehouse='#{{warehouse}}'
and date_cycle='month'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysdate}}',INTERVAL 23 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysdate}}','%Y/%m/%d')
group by stat_date order by stat_date