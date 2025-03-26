--having ����
--����
--select from [where] group by having [order by asc|desc]

--���űݾ� �հ谡 1000 �̻��� ����� ��ȸ
select userid, sum(price * amount) 
from buytbl
group by userid
having sum(price*amount)>=1000;


--�� Ű�� 175 �̻��� ���� ��ȸ
select addr, avg(height)
from usertbl
group by addr
having avg(height)>=175;

--���� Ƚ���� 2ȸ �̻��� ������� �� ���ž�
select * from buytbl;

select userid, sum(price*amount)
from buytbl
group by userid
having count(amount)>=2;

--���� group by
--����� ������, ��ǰ �׷캰 ���ž� �հ�
select u.addr,nvl(b.groupname,'�̺з�'), sum(b.amount*b.price)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr,b.groupname
order by u.addr, b.groupname;

--���ɴ뺰, ��ǰ�� ���� ���
select floor((2023-birthyear)/10)*10 as ���ɴ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2023-birthyear)/10)*10,b.prodname
order by ���ɴ�, b.prodname;

--������, ������ �����ڼ�
select * from usertbl;
select addr, extract(year from mdate) as ���Կ���, count (*)
from usertbl
group by addr, extract(year from mdate)
having count(*)>=2;

--rollup
--�Ұ�� �հ踦 �ڵ����� ����ϴ� �Լ�

select groupname, sum(price*amount)
from buytbl
--where groupname is not null
group by rollup(groupname);

--cube
--��� ������ ������ �Ұ�� �հ踦 ���
select groupname,prodname, sum(price*amount)
from buytbl
where groupname is not null
group by cube(groupname,prodname);


--union, union all
--���� �������� ���ļ� �ϳ��� ������
--union
--�ߺ� ����
--union all
--�ߺ����� ����
select groupname, null as prodname, sum(price*amount)
from buytbl
where groupname is not null
group by groupname

union all

select null as groupname,prodname, sum(price*amount)
from buytbl 
where groupname is not null
group by prodname;

--having ���� ����
--1. buytbl���� �� ���ž��� 1000�̻��� ����ڸ� ��ȸ
select * from buytbl;
select userid, sum(price*amount) as �ѱ��ž�
from buytbl
group by userid
having sum(price*amount)>=1000;

--2. usertbl���� ������ ���� 2�� �̻��� ������ ��ȸ
select addr, count(userid) as ������
from usertbl
group by addr
having count(userid)>=2;

--3. buytbl���� ��� ���ž��� 100 �̻��� ��ǰ�� ��ȸ
select prodname, avg(price*amount) as ��ձ��ž�
from buytbl
group by prodname
having avg(price*amount)>=100;

--4. usertbl���� ��� Ű�� 175 �̻��� ����⵵ ��ȸ
select * from usertbl;
select birthyear, avg(height)
from usertbl
group by birthyear
having avg(height)>=175;

--5. buytbl���� �ּ� 2�� �̻��� ��ǰ�� ������ ����ڸ� ��ȸ
select * from buytbl;
select userid, count(distinct prodname)
from buytbl
group by userid
having count(distinct prodname)>=2;

--6. usertbl�� buytbl�� �����Ͽ� ���� �Ѿ��� 200 �̻��� ������ ��ȸ
select u.addr, sum(b.price*b.amount)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr
having sum(b.price*b.amount)>=200;

--7. buytbl���� ���� Ƚ���� 3ȸ �̻��̰� �� ���ž��� 500 �̻��� ����ڸ� ��ȸ
select * from buytbl;
select userid, count(*), sum(amount*price)
from buytbl
group by userid
having count(*)>=3 and sum(amount*price)>=500;

--8. usertbl���� ��� Ű�� ���� ū ������ ��ȸ(�������� ���)
select*
from (select addr, avg(height) as ���Ű from usertbl group by addr)
where ���Ű = (select max(avg(height)) from usertbl group by addr);

--9. buytbl���� ���� �ݾ��� ��հ����� �� ���� �ݾ��� ����� ����� ��ȸ
select userid, sum(amount*price)
from buytbl
group by userid
having sum(amount*price)>(select avg(amount*price) from buytbl);

--10. usertbl�� buytbl��  �����Ͽ� ���� ������ ��� ����ڵ� �� ���� �Ѿ��� ������ ���
--���ž׺��� ���� ����ڸ� ��ȸ
--select u.addr, sum(b.amount*b.price)
--from usertbl u
--join buytbl b
--on u.userid=b.userid group by u.addr;

select u.userid, u.name,u.addr,sum(b.price*b.amount) as �ѱ��ž�
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid, u.name,u.addr
having sum(b.price*b.amount)>(select avg(�������ž�)
from (select u2.addr,sum(b2.price*b2.amount) as �������ž�
from usertbl u2
join buytbl d2
on u2.userid = b2.userid
where u2.addr=u.addr
group by u2.addr));


--�Լ�
--Ư�� �۾��� �����ϱ� ���� �̸� ���ǵ� ��ɾ�

--������ : �ະ�� �ϳ��� ��� ��ȯ
--upper : �� �ະ�� ó��
select userid, upper(name) as upper_name 
from usertbl;

--������ : ���� ���� ���� �Է¹ް� �ϳ��� ��� ��ȯ
--count : ������ ��� ó��
select addr, count(*) as user_count 
from usertbl 
group by addr;

--������ �Լ� - ������ �Լ�
select userid, lower(userid) as lower_id
from usertbl;
--�ҹ��� ��ȯ

select userid, upper(userid) as upper_id
from usertbl;
--�빮�� ��ȯ

select userid, initcap(userid) as init_cap
from usertbl;
--ù���ڸ� �빮�� ��ȯ

--���ڿ� ����
select name, length(name)
from usertbl;
--�̸��� ���� ����

select name, length(addr)
from usertbl;
--�ּ��� ���� ����

--���ڿ� ����
select name, substr(name,1,1)
from usertbl;
--�̸��� ù����

select name, substr(name,2)
from usertbl;
--userid�� �ι�° ���ں��� ��

--���� ��ġ ã��
select name, instr(name,'��')
from usertbl;
--'��'�� �ִ� ��ġ(������ 0)

--���ڿ� ä���
select userid, lpad(userid,10,'*')
from usertbl;
--userid ������ *�� ä�� 10�ڸ���

select userid, rpad(userid,10,'*')
from usertbl;
--userid �������� *�� ä�� 10�ڸ���

--���� ����
select trim('SQL')
from dual;
--���� ���� ����: 'SQL'

select ltrim('SQL')
from dual;
--���� ���� ���� : 'SQL'

select trim('SQL'), rtrim('SQL')
from dual;
--������ ���� ����: 'SQL'

--���ڿ� ġȯ
select name, replace(mobile1,null,'����')
from usertbl;
--null�� '����'���� ��ü

select name, replace(addr,'����','seoul')
from usertbl;
--'����'�� 'seoul'�� ��ü

--���ڿ� ����
select name, concat(mobile1,'-')
from usertbl;
--�޴��� ������ '-'����

select name, concat(concat(mobile1,'-'),mobile2)
from usertbl;
--����-��ȭ��ȣ �������� ����

select name,mobile1||'-'||mobile2
from usertbl;
--���� ������ ���


--������ �Լ� - ��¥�� �Լ�
--���� ��¥�� ȸ�������� Ȱ��

select name, mdate, sysdate
from usertbl;
--���� ��¥/ �ð�

select name, mdate, current_date
from usertbl;
--���� ��¥

--��¥ ����
select name, mdate, mdate + 7
from usertbl;
--������ 1���� ��

--��¥ ����
select name, mdate, mdate - 7
from usertbl;
--������ 1���� ��

--�� ���� �Լ�
--��¥ ����
select name, mdate, add_months(mdate,6)
from usertbl;
--������ 6���� ��

--��¥ ����
select name, mdate, months_between(sysdate,mdate)
from usertbl;
--���� �� ��� �� ��

--����, ���� �Լ�
--��¥ ����
select name, mdate, next_day(mdate,'�ݿ���')
from usertbl;
--������ ������ ù �ݿ���

select name, mdate, last_day(mdate)
from usertbl;
--������ 1���� ��

--��¥ ��� ����
select name, mdate, extract(year from mdate)
from usertbl;
--���� ����

select name, mdate, extract(month from mdate)
from usertbl;
--���� ��

select name, mdate, extract(day from mdate)
from usertbl;
--���� ��

--������ �Լ� - ��ȯ �Լ�
--��¥ -> ���� ��ȯ
select name, mdate, to_char(mdate,'yyyy-MM-dd')
from usertbl;
--2008-08-08 ����

select name, mdate, to_char(mdate,'yyyy"��"MM"��"dd"��"')
from usertbl;
--2008�� 08�� 08�� ����

select name, mdate, to_char(mdate,'yyyy/MM/dd hh24:mi:ss')
from usertbl;
--�ð� ���� ���� ����

-- �Ͻ��� ����ȯ
SELECT name, birthYear, 
       birthYear + 100 AS after_100years  -- ���ڿ��� �ڵ����� ���ڷ� ��ȯ
FROM userTbl;

--������ �Լ� - NULL ���� �Լ�
-- NVL �Լ�
SELECT name, mobile1, mobile2,
       NVL(mobile1, '����') AS nvl_mobile1,         -- NULL�̸� '����' ��ȯ
       NVL(height, 0) AS nvl_height                -- NULL�̸� 0 ��ȯ
FROM userTbl;

-- NVL2 �Լ�
SELECT name, mobile1,
       NVL2(mobile1, '����ó ����', '����ó ����') AS contact_status,  -- NULL�� �ƴϸ� ù��° ��, NULL�̸� �ι�° ��
       NVL2(mobile1, mobile1 || '-' || mobile2, '����ó ����') AS full_mobile -- NULL ���ο� ���� ó��
FROM userTbl;

-- NULLIF �Լ�
SELECT prodName, price, amount,
       NULLIF(price, 30) AS nullif_price       -- price�� 30�̸� NULL, �ƴϸ� price ��ȯ
FROM buyTbl;

-- COALESCE �Լ�
SELECT name, 
       COALESCE(mobile1, mobile2, '����ó ����') AS contact,   -- ù��° NULL �ƴ� �� ��ȯ
       COALESCE(NULL, NULL, '��� NULL') AS test_coalesce      -- ��� NULL�̸� ������ �� ��ȯ
FROM userTbl;

--������ �Լ� - ���Ǻ� �Լ�
-- DECODE �Լ� (Oracle ����)
SELECT name, addr,
       DECODE(addr, 
              '����', '������', 
              '���', '������',
              '�泲', '����',
              '���', '����',
              '����', '�����',
              '��Ÿ') AS region
FROM userTbl;

-- �ܼ� CASE ǥ����
SELECT userID, prodName,
       CASE groupName
           WHEN '����' THEN '������'
           WHEN '�Ƿ�' THEN '�м�'
           WHEN '����' THEN '����'
           ELSE '��Ÿ'
       END AS category
FROM buyTbl;

-- �˻� CASE ǥ����
SELECT name, height,
       CASE 
           WHEN height >= 180 THEN 'Ű ŭ'
           WHEN height >= 170 THEN '����'
           WHEN height IS NOT NULL THEN 'Ű ����'
           ELSE '�̱���'
       END AS height_grade
FROM userTbl;

-- ���� ���� CASE
SELECT prodName, price, amount,
       CASE
           WHEN price * amount >= 1000 THEN '�� ����'
           WHEN price * amount >= 500 THEN '�߰� ����'
           ELSE '�Ϲ� ����'
       END AS purchase_type
FROM buyTbl;

--����
--�� �� �̻��� ���̺��� �����Ͽ� ���õ� �����͸� �ϳ��� ��� �������� ��ȯ�ϴ� ����
--������ �����Ѵٸ� ������ ������ �� �ִ�

--inner join
select *
from usertbl u
join buytbl b on u.userid = b.userid;
--��ġ�� �ʴ� �׸��� ��� ���̺��� �׸����� ǥ���� �ʿ䰡 ����

select u.userid, name, birthyear, addr, prodname, groupname, price
from usertbl u
join buytbl b on u.userid = b.userid;

--ȸ���� �� ���� �ݾ�
select u.userid,u.name,sum(b.price*b.amount) as �ѱ��űݾ�
from usertbl u
join buytbl b
on u.userid = b.userid 
group by u.name, u.userid;

select u.name, sum(b.amount) as �Ѽ���
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.name
order by �Ѽ��� desc;

--outer join
--���� ���ǿ� ��ġ���� �ʴ� �൵ �����Ͽ� ��ȯ
select*
from usertbl u
left join buytbl b  --���ǿ� �������� �ʴ� ���̺� �� ���� ���̺��� ǥ��
on u.userid = b.userid;

--���Ű� ���� ȸ�� ã��
select u.name, sum(b.amount)
from usertbl u
left join buytbl b
on u.userid = b.userid
where b.userid is null group by u.name;

--������ �����̸Ӹ��� �ܷ�Ű�� ������ �ȴ�

select*
from usertbl u
right join buytbl b  --���ǿ� �������� �ʴ� ���̺� �� ������ ���̺��� ǥ��
on u.userid = b.userid;



--full outer join
--�л� ���̺�
select * from studenttbl;
select * from examtbl;

--��� �л��� ��� ���� ���� ���(���� ������ null)
select s.name, e.subject , e.score
from studenttbl s
full outer join examtbl e on s.studentid = e.studentid;

--���迡 �������� ���� �л� ã��
select s.name
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid
where e.studentid is null;

--�������� �ʴ� �л�ID�� ������ ���� ��ȸ
select e.examid, e.subject,e.score
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid
where s.studentid is null;

--�л��� ���� ������ ���� ���� ���� �л��� �л� ���� ���� ��� ����
select s.studentid, s.name, e.subject, e.score
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid;





