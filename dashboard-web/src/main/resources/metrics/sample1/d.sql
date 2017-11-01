SELECT strftime('%Y/%m/%d',fact.date) AS r_date,
       sum(metrics2) AS metrics_2,
       sum(metrics3) AS metrics_3
FROM fact
inner JOIN a ON a.id=fact.dim1
where strftime('%Y/%m/%d',fact.date) between '2017/07/01' and '2017/07/14'
GROUP BY 
         strftime('%Y/%m/%d',fact.date) 
ORDER BY r_date