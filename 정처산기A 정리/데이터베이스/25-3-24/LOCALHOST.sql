--where ��
desc usertbl;
select * from usertbl where name='���ȣ';

--������ + ���迬����
select * from usertbl where birthyear >=1970 and height>=182;
select * from usertbl where birthyear >=1970 or height>=182;

--between
select * from usertbl where birthyear >=1970 and birthyear<=1980;
select * from usertbl where birthyear  between 1970 and 1980;

--in
select * from usertbl where addr in('�泲','����','���');
select * from usertbl where mobile1 in('010','011');

--like  %(��繮��, �������� x), _(��繮��, _��ŭ�� ����)
select name,height from usertbl where name like '��%';
select name, height from usertbl where name like '_���';

--null check
select * from usertbl where mobile1 is null;
select * from usertbl where mobile1 is not null;

--distinct row �� �ߺ� row ����
select addr from usertbl;
select DISTINCT addr from usertbl;

--alias ��Ī
select * from usertbl;
select name,addr, mobile1 || mobile2 from usertbl;
select name,addr, mobile1 || mobile2 as phone from usertbl;


--����
select * from buytbl;

--1. ���ŷ��� 5�� �̻��� �� ���
select * from buytbl where amount>=5;

--2. ������ 50�̻� 500 ������ ���� userid�� prodname ���
select userid, prodname from buytbl where price>=50 and price<=500;

--3. ���ŷ��� 10�̻� �Ǵ� ������ 100 �̻��� �� ���
SELECT * from buytbl where amount>=10 or price>=100;

--4. userid�� K�� �����ϴ� �� ���
select * from buytbl where userid like 'K%';

--5. '����'�̰ų� '����'�� �� ���
select * from buytbl where groupname in('����', '����');

--6. ��ǰ�� å�̰ų� userid�� w�� ������ �� ���
select * from buytbl where prodname in('å') or userid like '%W';

-- �л� ���̺�
CREATE TABLE studentTbl (
  studentID CHAR(5) PRIMARY KEY,
  name VARCHAR2(20)
);

-- ���� ���� ���̺�
CREATE TABLE examTbl (
  examID CHAR(5) PRIMARY KEY,
  studentID CHAR(5),
  subject VARCHAR2(20),
  score NUMBER
);

-- �л� ������ ����
INSERT INTO studentTbl VALUES ('S001', 'ȫ�浿');
INSERT INTO studentTbl VALUES ('S002', '��ö��');
INSERT INTO studentTbl VALUES ('S003', '�̿���');
INSERT INTO studentTbl VALUES ('S004', '������');

-- ���� ���� ������ ����
INSERT INTO examTbl VALUES ('E101', 'S001', '����', 85);
INSERT INTO examTbl VALUES ('E102', 'S002', '����', 90);
INSERT INTO examTbl VALUES ('E103', 'S005', '����', 88); -- �������� �ʴ� �л�

COMMIT;




