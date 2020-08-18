-- mock data for vendors
insert into vendors (id, username) values (1,'admin'), (2,'user');

-- mock data for customers
insert into customers(customer_name, vendor_id)
select 'customer_' || seq,
  floor(random() * (2-1+1) + 1)::int
  FROM GENERATE_SERIES(1, 500) seq;

-- mock data for orders
insert into orders(customer_id, order_description,order_date,vendor_id)
WITH expanded AS (
  SELECT RANDOM(), seq, c.id AS customer_id
  FROM GENERATE_SERIES(1, 2000) seq, customers c
), shuffled AS (
  SELECT e.*
  FROM expanded e
  INNER JOIN (
    SELECT ei.seq, MIN(ei.random) FROM expanded ei GROUP BY ei.seq
  ) em ON (e.seq = em.seq AND e.random = em.min)
  ORDER BY e.seq
)
SELECT
  s.customer_id,
   'order_' || s.seq,
  (NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days')::date,
  floor(random() * (2-1+1) + 1)::int
FROM shuffled s;