-- join - 교차 join
--두 테이블의 모든 조합을 반환한다. 조인 조건이 없고, 결과는 두 태이블의 행 수를 곱한 만큼
--행을 생성한다

--모든 회원과 모든 상품 조합 조회(테이블 내 모든 조합)
select u.name, b.prodname
from usertbl u
cross join buytbl b;

--join - self join
--하나의 테이블을 자기 자신과 조인하는 방식이다. 주로 계층적 데이터 구조를 표현할 때 사용

--usertbl 내에서 출생년도가 같은 회원끼리 짝 지어보기(자기자신 제외)
select a.name, b.name, a.birthyear
from usertbl a
join usertbl b on a.birthyear = b.birthyear
where a.userid <> b.userid;

--usertbl에 관리자(상사) id가 있다고 가정
--가정 : usertbl에 managerid 컬럼이 추가
--self join 으로 사원과 관리자 연결
select * from userselftesttbl;
select e.name as 직원명, m.name as 관리자명
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
where m.empname = '김대표';

--inner join 문제
--1. 모든 회원의 이름과 구매한 상품명, 단가, 수량 조회(미구매 회원 제외)
select * from usertbl;

select name, prodname, price,amount
from usertbl u
join buytbl b
on u.userid = b.userid;

--2. 회원별 총 구매 금액(단가 x 수량의 합) 출력
--이름, 총구매금액 출력. 금액 높은 순 정렬
select name, sum(price*amount)
from usertbl u
join buytbl b
on u.userid = b.userid
group by name
order by sum(price*amount) desc;

--outer join 문제
--left join
--1. 모든 회원의 이름과 구매 내역(없으면 null 표시)
select name, b.prodname,price
from usertbl u
left join buytbl b
on u.userid = b.userid;

--2. 구매 이력이 없는 회원만 조회
select name, u.userid
from usertbl u
left join buytbl b 
on u.userid = b.userid
where b.userid is null;

--3. 지역별 회원 이름과 구매 수량(없으면 null)
select addr, name, amount
from usertbl u
left join buytbl b on u.userid = b.userid;

--4. 회원별 총 구매 금액(없으면 0)
select name, nvl(sum(price * amount), 0)
from usertbl u
left join buytbl b on u.userid = b.userid 
group by name;

--5. 키가 170 이상인 회원의 구매정보
select name, amount, prodname
from usertbl u
left join buytbl b on u.userid = b.userid
where height>=170;

--right join
--1. 구매 테이블 기준으로 회원 이름과 구매 상품 출력
select name,prodname
from buytbl b
right join usertbl u
on b.userid = u.userid;

--2. 회원정보가 없는 구매 데이터 조회(이상 상황)
select prodname, price
from usertbl u
right join buytbl b
on u.userid = b.userid
where u.userid is null;

--3. 구매 상품과 해당 구매자의 키 출력
select prodname, height
from usertbl u
right join buytbl b on u.userid = b.userid;

--4. 구매 내역 기준으로 회원지역 조회
select prodname, addr
from usertbl u
right join buytbl b on u.userid = b.userid;

--5. 회원가입일과 구매 상품 출력
select * from usertbl;
select mdate, prodname
from usertbl u
right join buytbl b on u.userid = b.userid;

--self join 문제
--1. 같은 지역에 사는 서로 다른 회원 쌍 찾기
select u.name, u2.name, u.addr
from usertbl u
join usertbl u2 on u.addr = u2.addr and u.userid < u2.userid;


--natural join
--동일 항목을 자동으로 동등 조인을 수행하여 추가 조건 필요 없다.
--실행하면 동일 항목 중 하나가 없어진다.
select *
from usertbl u
natural join buytbl b;

select *
from usertbl u
join buytbl b on u.userid = b.userid;

--서브 쿼리

--김경호보다 키가 큰 사용자 조회
select userid, name, height
from usertbl
where height>(select height from usertbl where name='김경호');

--다중 행 쿼리
--경남 지역에 사는 사용자와 같은 키를 가진 사용자 조회
select userid, name, addr, height
from usertbl
where height >= any (select height from usertbl where addr='경남');
-- any : 여러 조건 중 아무거나 만족하는 항목(= or)

select userid, name, addr, height
from usertbl
where height >= all (select height from usertbl where addr='경남');
-- all : 여러 조건을 모두 만족하는 항목(= and)

--다중 컬럼 서브 쿼리
--주소별로 가장 키가 큰 사람들 조회
select userid, name, addr, height
from usertbl
where(addr, height) in(select addr, max(height) from usertbl group by addr);

--where 절에 사용되는 서브 쿼리
--평균 키보다 큰 사용자 조회
select userid,name,height
from usertbl
where height > (select avg(height) from usertbl);

--서브 쿼리 문제
--1. 서울 지역에 거주하는 회원 중 전체 평균 키보다 큰 회원의 이름과 키 조회
select name, height
from usertbl
where addr ='서울' and height>(select avg(height) from usertbl);

--2. 물품을 한 번이라도 구매한 적이 있는 회원의 이름과 주소 조회
select name, addr
from usertbl u
where userid in (select distinct userid from buytbl);

--3. '전자'분류 중 가장 비싼 상품을 구매한 회원의 이름, 상품명, 가격을 조회
select * from buytbl;
select name, prodname, price
from buytbl b
join usertbl u on b.userid = u.userid
where groupname = '전자'
and price = (select max(price) from buytbl where groupname = '전자');

--4. 각 회원이 구매한 총 금액의 평균보다 더 많이 구매한 회원의 이름과 총 구매금액 조회
select userid, 총구매금액
from (select userid,sum(price*amount) as 총구매금액 from buytbl group by userid)
where 총구매금액>(select avg(전체평균금액) from (select sum(price*amount) as 전체평균금액
    from buytbl group by userid));
    
--5. 한 번도 물건을 구매한 적 없는 회원의 이름과 가입일을 조회
select name, mdate
from usertbl
where userid not in(select distinct userid from buytbl);

--union
--두 select 결과를 합쳐서 하나의 결과로 출력하고 중복은 제거 






