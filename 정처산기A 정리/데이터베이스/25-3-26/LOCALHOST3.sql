-- join - ���� join
--�� ���̺��� ��� ������ ��ȯ�Ѵ�. ���� ������ ����, ����� �� ���̺��� �� ���� ���� ��ŭ
--���� �����Ѵ�

--��� ȸ���� ��� ��ǰ ���� ��ȸ(���̺� �� ��� ����)
select u.name, b.prodname
from usertbl u
cross join buytbl b;

--join - self join
--�ϳ��� ���̺��� �ڱ� �ڽŰ� �����ϴ� ����̴�. �ַ� ������ ������ ������ ǥ���� �� ���

--usertbl ������ ����⵵�� ���� ȸ������ ¦ �����(�ڱ��ڽ� ����)
select a.name, b.name, a.birthyear
from usertbl a
join usertbl b on a.birthyear = b.birthyear
where a.userid <> b.userid;

--usertbl�� ������(���) id�� �ִٰ� ����
--���� : usertbl�� managerid �÷��� �߰�
--self join ���� ����� ������ ����
select * from userselftesttbl;
select e.name as ������, m.name as �����ڸ�
from userselftesttbl e
join userselftesttbl m
on e.managerid = m.userid;

select m.empname, count(*)
from emptbl e
join emptbl m
on e.managerid = m.empid
group by m.empname;

select m.empname
from emptbl e
join emptbl m
on e.managerid = m.empid
where m.empname = '���ǥ';

--inner join ����
--1. ��� ȸ���� �̸��� ������ ��ǰ��, �ܰ�, ���� ��ȸ(�̱��� ȸ�� ����)
select * from usertbl;

select name, prodname, price,amount
from usertbl u
join buytbl b
on u.userid = b.userid;

--2. ȸ���� �� ���� �ݾ�(�ܰ� x ������ ��) ���
--�̸�, �ѱ��űݾ� ���. �ݾ� ���� �� ����
select name, sum(price*amount)
from usertbl u
join buytbl b
on u.userid = b.userid
group by name
order by sum(price*amount) desc;

--outer join ����
--left join
--1. ��� ȸ���� �̸��� ���� ����(������ null ǥ��)
select name, b.prodname,price
from usertbl u
left join buytbl b
on u.userid = b.userid;

--2. ���� �̷��� ���� ȸ���� ��ȸ
select name, u.userid
from usertbl u
left join buytbl b 
on u.userid = b.userid
where b.userid is null;

--3. ������ ȸ�� �̸��� ���� ����(������ null)
select addr, name, amount
from usertbl u
left join buytbl b on u.userid = b.userid;

--4. ȸ���� �� ���� �ݾ�(������ 0)
select name, nvl(sum(price * amount), 0)
from usertbl u
left join buytbl b on u.userid = b.userid 
group by name;

--5. Ű�� 170 �̻��� ȸ���� ��������
select name, amount, prodname
from usertbl u
left join buytbl b on u.userid = b.userid
where height>=170;

--right join
--1. ���� ���̺� �������� ȸ�� �̸��� ���� ��ǰ ���
select name,prodname
from buytbl b
right join usertbl u
on b.userid = u.userid;

--2. ȸ�������� ���� ���� ������ ��ȸ(�̻� ��Ȳ)
select prodname, price
from usertbl u
right join buytbl b
on u.userid = b.userid
where u.userid is null;

--3. ���� ��ǰ�� �ش� �������� Ű ���
select prodname, height
from usertbl u
right join buytbl b on u.userid = b.userid;

--4. ���� ���� �������� ȸ������ ��ȸ
select prodname, addr
from usertbl u
right join buytbl b on u.userid = b.userid;

--5. ȸ�������ϰ� ���� ��ǰ ���
select * from usertbl;
select mdate, prodname
from usertbl u
right join buytbl b on u.userid = b.userid;

--self join ����
--1. ���� ������ ��� ���� �ٸ� ȸ�� �� ã��
select u.name, u2.name, u.addr
from usertbl u
join usertbl u2 on u.addr = u2.addr and u.userid < u2.userid;


--natural join
--���� �׸��� �ڵ����� ���� ������ �����Ͽ� �߰� ���� �ʿ� ����.
--�����ϸ� ���� �׸� �� �ϳ��� ��������.
select *
from usertbl u
natural join buytbl b;

select *
from usertbl u
join buytbl b on u.userid = b.userid;

--���� ����

--���ȣ���� Ű�� ū ����� ��ȸ
select userid, name, height
from usertbl
where height>(select height from usertbl where name='���ȣ');

--���� �� ����
--�泲 ������ ��� ����ڿ� ���� Ű�� ���� ����� ��ȸ
select userid, name, addr, height
from usertbl
where height >= any (select height from usertbl where addr='�泲');
-- any : ���� ���� �� �ƹ��ų� �����ϴ� �׸�(= or)

select userid, name, addr, height
from usertbl
where height >= all (select height from usertbl where addr='�泲');
-- all : ���� ������ ��� �����ϴ� �׸�(= and)

--���� �÷� ���� ����
--�ּҺ��� ���� Ű�� ū ����� ��ȸ
select userid, name, addr, height
from usertbl
where(addr, height) in(select addr, max(height) from usertbl group by addr);

--where ���� ���Ǵ� ���� ����
--��� Ű���� ū ����� ��ȸ
select userid,name,height
from usertbl
where height > (select avg(height) from usertbl);

--���� ���� ����
--1. ���� ������ �����ϴ� ȸ�� �� ��ü ��� Ű���� ū ȸ���� �̸��� Ű ��ȸ
select name, height
from usertbl
where addr ='����' and height>(select avg(height) from usertbl);

--2. ��ǰ�� �� ���̶� ������ ���� �ִ� ȸ���� �̸��� �ּ� ��ȸ
select name, addr
from usertbl u
where userid in (select distinct userid from buytbl);

--3. '����'�з� �� ���� ��� ��ǰ�� ������ ȸ���� �̸�, ��ǰ��, ������ ��ȸ
select * from buytbl;
select name, prodname, price
from buytbl b
join usertbl u on b.userid = u.userid
where groupname = '����'
and price = (select max(price) from buytbl where groupname = '����');

--4. �� ȸ���� ������ �� �ݾ��� ��պ��� �� ���� ������ ȸ���� �̸��� �� ���űݾ� ��ȸ
select userid, �ѱ��űݾ�
from (select userid,sum(price*amount) as �ѱ��űݾ� from buytbl group by userid)
where �ѱ��űݾ�>(select avg(��ü��ձݾ�) from (select sum(price*amount) as ��ü��ձݾ�
    from buytbl group by userid));
    
--5. �� ���� ������ ������ �� ���� ȸ���� �̸��� �������� ��ȸ
select name, mdate
from usertbl
where userid not in(select distinct userid from buytbl);

--union
--�� select ����� ���ļ� �ϳ��� ����� ����ϰ� �ߺ��� ���� 






