select stat_date, max(func_value) as func_value
from T_RESULT
where func_name='成本效率' and warehouse_name='全部仓库' and date_cycle='日维度'
group by stat_date order by stat_date