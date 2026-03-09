# Write your MySQL query statement below
(select u.name as results from Users u join MovieRating r on u.user_id = r.user_id group by u.user_id , u.name order by COUNT(*) desc , u.name limit 1 )
union all
(select m.title as results from Movies m join MovieRating r on m.movie_id = r.movie_id where r.created_at between '2020-02-01' and '2020-02-29' group by m.movie_id , m.title order by AVG(r.rating) desc, m.title limit 1 );