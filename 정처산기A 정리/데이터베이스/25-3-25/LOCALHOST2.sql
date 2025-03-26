--having 구문
--순서
--select from [where] group by having [order by asc|desc]

--구매금액 합계가 1000 이상인 사용자 조회
select userid, sum(price * amount) 
from buytbl
group by userid
having sum(price*amount)>=1000;


--평군 키가 175 이상인 지역 조회
select addr, avg(height)
from usertbl
group by addr
having avg(height)>=175;

--구매 횟수가 2회 이상인 사용자의 총 구매액
select * from buytbl;

select userid, sum(price*amount)
from buytbl
group by userid
having count(amount)>=2;

--복합 group by
--사용자 지역별, 제품 그룹별 구매액 합계
select u.addr,nvl(b.groupname,'미분류'), sum(b.amount*b.price)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr,b.groupname
order by u.addr, b.groupname;

--연령대별, 제품별 구매 통계
select floor((2023-birthyear)/10)*10 as 연령대
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2023-birthyear)/10)*10,b.prodname
order by 연령대, b.prodname;

--지역별, 연도별 가입자수
select * from usertbl;
select addr, extract(year from mdate) as 가입연도, count (*)
from usertbl
group by addr, extract(year from mdate)
having count(*)>=2;

--rollup
--소계와 합계를 자동으로 계산하는 함수

select groupname, sum(price*amount)
from buytbl
--where groupname is not null
group by rollup(groupname);

--cube
--모든 가능한 조합의 소계와 합계를 계산
select groupname,prodname, sum(price*amount)
from buytbl
where groupname is not null
group by cube(groupname,prodname);


--union, union all
--여러 쿼리문을 합쳐서 하나로 보여줌
--union
--중복 제거
--union all
--중복까지 포함
select groupname, null as prodname, sum(price*amount)
from buytbl
where groupname is not null
group by groupname

union all

select null as groupname,prodname, sum(price*amount)
from buytbl 
where groupname is not null
group by prodname;

--having 구문 문제
--1. buytbl에서 총 구매액이 1000이상인 사용자만 조회
select * from buytbl;
select userid, sum(price*amount) as 총구매액
from buytbl
group by userid
having sum(price*amount)>=1000;

--2. usertbl에서 가입자 수가 2명 이상인 지역만 조회
select addr, count(userid) as 가입자
from usertbl
group by addr
having count(userid)>=2;

--3. buytbl에서 평균 구매액이 100 이상인 제품만 조회
select prodname, avg(price*amount) as 평균구매액
from buytbl
group by prodname
having avg(price*amount)>=100;

--4. usertbl에서 평균 키가 175 이상인 출생년도 조회
select * from usertbl;
select birthyear, avg(height)
from usertbl
group by birthyear
having avg(height)>=175;

--5. buytbl에서 최소 2개 이상의 제품을 구매한 사용자를 조회
select * from buytbl;
select userid, count(distinct prodname)
from buytbl
group by userid
having count(distinct prodname)>=2;

--6. usertbl과 buytbl을 조인하여 구매 총액이 200 이상인 지역만 조회
select u.addr, sum(b.price*b.amount)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr
having sum(b.price*b.amount)>=200;

--7. buytbl에서 구매 횟수가 3회 이상이고 총 구매액이 500 이상인 사용자를 조회
select * from buytbl;
select userid, count(*), sum(amount*price)
from buytbl
group by userid
having count(*)>=3 and sum(amount*price)>=500;

--8. usertbl에서 평균 키가 가장 큰 지역을 조회(서브쿼리 사용)
select*
from (select addr, avg(height) as 평균키 from usertbl group by addr)
where 평균키 = (select max(avg(height)) from usertbl group by addr);

--9. buytbl에서 구매 금액의 평균값보다 더 많은 금액을 사용한 사용자 조회
select userid, sum(amount*price)
from buytbl
group by userid
having sum(amount*price)>(select avg(amount*price) from buytbl);

--10. usertbl과 buytbl을  조인하여 같은 지역에 사는 사용자들 중 구매 총액이 지역별 평균
--구매액보다 높은 사용자를 조회
--select u.addr, sum(b.amount*b.price)
--from usertbl u
--join buytbl b
--on u.userid=b.userid group by u.addr;

select u.userid, u.name,u.addr,sum(b.price*b.amount) as 총구매액
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid, u.name,u.addr
having sum(b.price*b.amount)>(select avg(지역구매액)
from (select u2.addr,sum(b2.price*b2.amount) as 지역구매액
from usertbl u2
join buytbl d2
on u2.userid = b2.userid
where u2.addr=u.addr
group by u2.addr));


--함수
--특정 작업을 수행하기 위해 미리 정의된 명령어

--단일행 : 행별로 하나의 결과 변환
--upper : 각 행별로 처리
select userid, upper(name) as upper_name 
from usertbl;

--다중행 : 여러 행의 값을 입력받고 하나의 결과 반환
--count : 여러행 묶어서 처리
select addr, count(*) as user_count 
from usertbl 
group by addr;

--단일행 함수 - 문자형 함수
select userid, lower(userid) as lower_id
from usertbl;
--소문자 변환

select userid, upper(userid) as upper_id
from usertbl;
--대문자 변환

select userid, initcap(userid) as init_cap
from usertbl;
--첫글자만 대문자 변환

--문자열 길이
select name, length(name)
from usertbl;
--이름의 문자 개수

select name, length(addr)
from usertbl;
--주소의 문자 개수

--문자열 추출
select name, substr(name,1,1)
from usertbl;
--이름의 첫글자

select name, substr(name,2)
from usertbl;
--userid의 두번째 문자부터 끝

--문자 위치 찾기
select name, instr(name,'김')
from usertbl;
--'김'이 있는 위치(없으면 0)

--문자열 채우기
select userid, lpad(userid,10,'*')
from usertbl;
--userid 왼쪽을 *로 채워 10자리로

select userid, rpad(userid,10,'*')
from usertbl;
--userid 오른쪽을 *로 채워 10자리로

--공백 제거
select trim('SQL')
from dual;
--양쪽 공백 제거: 'SQL'

select ltrim('SQL')
from dual;
--왼쪽 공백 제거 : 'SQL'

select trim('SQL'), rtrim('SQL')
from dual;
--오른쪽 공백 제거: 'SQL'

--문자열 치환
select name, replace(mobile1,null,'없음')
from usertbl;
--null을 '없음'으로 대체

select name, replace(addr,'서울','seoul')
from usertbl;
--'서울'을 'seoul'로 대체

--문자열 연결
select name, concat(mobile1,'-')
from usertbl;
--휴대폰 국번과 '-'연결

select name, concat(concat(mobile1,'-'),mobile2)
from usertbl;
--국번-전화번호 형식으로 연결

select name,mobile1||'-'||mobile2
from usertbl;
--연결 연산자 사용


--단일행 함수 - 날짜형 함수
--현재 날짜와 회원가입일 활용

select name, mdate, sysdate
from usertbl;
--현재 날짜/ 시간

select name, mdate, current_date
from usertbl;
--현재 날짜

--날짜 연산
select name, mdate, mdate + 7
from usertbl;
--가입일 1주일 후

--날짜 연산
select name, mdate, mdate - 7
from usertbl;
--가입일 1주일 전

--월 관련 함수
--날짜 연산
select name, mdate, add_months(mdate,6)
from usertbl;
--가입일 6개월 후

--날짜 연산
select name, mdate, months_between(sysdate,mdate)
from usertbl;
--가입 후 경과 월 수

--요일, 말일 함수
--날짜 연산
select name, mdate, next_day(mdate,'금요일')
from usertbl;
--가입일 이후의 첫 금요일

select name, mdate, last_day(mdate)
from usertbl;
--가입일 1주일 후

--날짜 요소 추출
select name, mdate, extract(year from mdate)
from usertbl;
--가입 연도

select name, mdate, extract(month from mdate)
from usertbl;
--가입 월

select name, mdate, extract(day from mdate)
from usertbl;
--가입 일

--단일행 함수 - 변환 함수
--날짜 -> 문자 변환
select name, mdate, to_char(mdate,'yyyy-MM-dd')
from usertbl;
--2008-08-08 형식

select name, mdate, to_char(mdate,'yyyy"년"MM"월"dd"일"')
from usertbl;
--2008년 08월 08일 형식

select name, mdate, to_char(mdate,'yyyy/MM/dd hh24:mi:ss')
from usertbl;
--시간 포함 형식 형식

-- 암시적 형변환
SELECT name, birthYear, 
       birthYear + 100 AS after_100years  -- 문자열이 자동으로 숫자로 변환
FROM userTbl;

--단일행 함수 - NULL 관련 함수
-- NVL 함수
SELECT name, mobile1, mobile2,
       NVL(mobile1, '없음') AS nvl_mobile1,         -- NULL이면 '없음' 반환
       NVL(height, 0) AS nvl_height                -- NULL이면 0 반환
FROM userTbl;

-- NVL2 함수
SELECT name, mobile1,
       NVL2(mobile1, '연락처 있음', '연락처 없음') AS contact_status,  -- NULL이 아니면 첫번째 값, NULL이면 두번째 값
       NVL2(mobile1, mobile1 || '-' || mobile2, '연락처 없음') AS full_mobile -- NULL 여부에 따른 처리
FROM userTbl;

-- NULLIF 함수
SELECT prodName, price, amount,
       NULLIF(price, 30) AS nullif_price       -- price가 30이면 NULL, 아니면 price 반환
FROM buyTbl;

-- COALESCE 함수
SELECT name, 
       COALESCE(mobile1, mobile2, '연락처 없음') AS contact,   -- 첫번째 NULL 아닌 값 반환
       COALESCE(NULL, NULL, '모두 NULL') AS test_coalesce      -- 모두 NULL이면 마지막 값 반환
FROM userTbl;

--단일행 함수 - 조건부 함수
-- DECODE 함수 (Oracle 전용)
SELECT name, addr,
       DECODE(addr, 
              '서울', '수도권', 
              '경기', '수도권',
              '경남', '경상권',
              '경북', '경상권',
              '전남', '전라권',
              '기타') AS region
FROM userTbl;

-- 단순 CASE 표현식
SELECT userID, prodName,
       CASE groupName
           WHEN '전자' THEN '디지털'
           WHEN '의류' THEN '패션'
           WHEN '서적' THEN '교육'
           ELSE '기타'
       END AS category
FROM buyTbl;

-- 검색 CASE 표현식
SELECT name, height,
       CASE 
           WHEN height >= 180 THEN '키 큼'
           WHEN height >= 170 THEN '보통'
           WHEN height IS NOT NULL THEN '키 작음'
           ELSE '미기재'
       END AS height_grade
FROM userTbl;

-- 복합 조건 CASE
SELECT prodName, price, amount,
       CASE
           WHEN price * amount >= 1000 THEN '고가 구매'
           WHEN price * amount >= 500 THEN '중간 구매'
           ELSE '일반 구매'
       END AS purchase_type
FROM buyTbl;

--조인
--두 개 이상의 테이블을 결합하여 관련된 데이터를 하나의 결과 집합으로 반환하는 연산
--조건을 만족한다면 여러개 연결할 수 있다

--inner join
select *
from usertbl u
join buytbl b on u.userid = b.userid;
--겹치지 않는 항목은 어느 테이블의 항목인지 표시할 필요가 없다

select u.userid, name, birthyear, addr, prodname, groupname, price
from usertbl u
join buytbl b on u.userid = b.userid;

--회원별 총 구매 금액
select u.userid,u.name,sum(b.price*b.amount) as 총구매금액
from usertbl u
join buytbl b
on u.userid = b.userid 
group by u.name, u.userid;

select u.name, sum(b.amount) as 총수량
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.name
order by 총수량 desc;

--outer join
--조인 조건에 일치하지 않는 행도 포함하여 반환
select*
from usertbl u
left join buytbl b  --조건에 만족하지 않는 테이블 중 왼쪽 테이블을 표시
on u.userid = b.userid;

--구매가 없는 회원 찾기
select u.name, sum(b.amount)
from usertbl u
left join buytbl b
on u.userid = b.userid
where b.userid is null group by u.name;

--조인은 프라이머리와 외래키가 전제가 된다

select*
from usertbl u
right join buytbl b  --조건에 만족하지 않는 테이블 중 오른쪽 테이블을 표시
on u.userid = b.userid;



--full outer join
--학생 테이블
select * from studenttbl;
select * from examtbl;

--모든 학생과 모든 시험 정보 출력(누락 정보는 null)
select s.name, e.subject , e.score
from studenttbl s
full outer join examtbl e on s.studentid = e.studentid;

--시험에 응시하지 않은 학생 찾기
select s.name
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid
where e.studentid is null;

--존재하지 않는 학생ID로 응시한 시험 조회
select e.examid, e.subject,e.score
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid
where s.studentid is null;

--학생과 시험 정보를 묶어 성적 없는 학생과 학생 없는 시험 모두 보기
select s.studentid, s.name, e.subject, e.score
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid;





