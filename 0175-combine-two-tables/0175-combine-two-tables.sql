# Write your MySQL query statement below
select firstName, lastName, (case when city is Null then Null else city end) as city,
(case when state is Null then Null else state end) as state
from person as p
left join address as a on p.personId=a.personId
