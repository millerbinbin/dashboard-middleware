select stat_date, max(func_value) as func_value
from T_RESULT
where func_name='成本效率'
and warehouse='#{{warehouse}}'
and date_cycle='week'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysdate}}',INTERVAL 15 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysdate}}','%Y/%m/%d')
group by stat_date order by stat_date