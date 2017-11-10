select stat_date, cast(max(func_value)as signed) as func_value
from T_RESULT
where func_name='在库SKU' and warehouse_name='全部仓库' and date_cycle='日维度'
group by stat_date order by stat_date