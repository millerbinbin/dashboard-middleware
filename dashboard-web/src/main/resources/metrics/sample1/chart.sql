select stat_date, cast(max(func_value)as signed) as func_value
from T_RESULT
where func_name='在库SKU'
and warehouse_name='#{{warehouse}}'
and date_cycle='#{{dateCycle}}'
and stat_date between DATE_FORMAT(DATE_SUB('#{{sysDate}}',INTERVAL 13 DAY),'%Y/%m/%d') and DATE_FORMAT('#{{sysDate}}','%Y/%m/%d')
group by stat_date order by stat_date