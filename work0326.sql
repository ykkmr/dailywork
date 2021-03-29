/*
아래 제시된 Data Dictionary를 파악한 후,  Dictionary를 사용하여
   emp 테이블에 컬럼명,데이터형, 크기, defalut값, 제약사항명을 조회하세요.
    단, 크기는 숫자인 경우 22자가 아닌 실제 크기를 출력.
    Dictionary :  user_tab_cols , user_cons_columns, user_constraints
*/
select * from user_tab_cols where table_name='EMP';
select * from user_cons_columns where table_name='EMP';
-- 특정 테이블의 모든 제약을 검색
select * from user_constraints where table_name='EMP';
-- 특정 테이블의 특정 제약 검색.

select  utc.column_name, utc.data_type,
        nvl(utc.data_precision,utc.data_length ) data_length,
        utc.data_default, ucc.constraint_name,uc.constraint_type
from 		user_tab_cols utc,user_cons_columns ucc,user_constraints uc
where 	(utc.column_name=ucc.column_name and ucc.constraint_name=uc.constraint_name)
			 and utc.table_name='EMP' ;

/*	이학민민*/
/*3.
 차량의 제조사가 '현대','기아','삼성','BMW','AUDI'이고 옵션에 'ABS','TCS'가
 있는 차량의  제조국, 제조사,모델명, 연식,가격, 옵션, 이미지, 배기량 조회
  --단, 연식의 내림차순 정렬하고, 연식이 같다면 가격의 내림차순으로 정렬
   하여 출력, 이미지는 이미지명과 확장자를 구분하여 출력할것,
   제조사명이 영어라면 Bmw, Audi 의 형식으로 출력 .
  -진재혁
*/
 select cco.country, initcap(cma.maker), cmo.model, cmo.car_year,cmo.price, cmo.car_option,
 substr(cmo.car_img, 1, instr(cmo.car_img,'.')-1) imgname, substr(cmo.car_img, instr(cmo.car_img,'.')+1,3) 확장자명, cmo.cc
 from  car_model cmo, car_country cco, car_maker cma
 where (cco.maker = cma.maker and cmo.model = cma.model)
 and cma.maker in ('현대','기아','삼성','BMW','AUDI')
 and (cmo.car_option like '%ABS%' or cmo.car_option like '%TCS%')
 order by cmo.car_year desc, cmo.price desc;

/*6. 사원명이 'S'로 끝나거나 이름5자이면서 세번째 글자가 'A'인
   사원의  사원번호, 사원명, 입사일,연봉,세금, 실수령액, 연봉인상액,
   부서번호,부서명,위치,우편번호,시도, 구군,동,번지 를 조회
   단,실수령액은 연봉+퇴직금+보너스-세금(연봉 3.3) 로 계산
     연봉인상액은 부서번호에 따라 차등 인상
     10- 년봉 7%, 20- 년봉 4%, 30- 년봉+보너스 10%, 그외 3%로
     계산하여 3자리마다 ,를 넣어 출력.
     모든 영어는 소문자로 출력.

     -이하늘
*/

select e.empno,lower(e.ename),e.hiredate,e.sal,e.sal*0.033 tax,
	     trunc((sal+(sal/12)+nvl(comm,0)-(sal*0.033)),0) real_income,
			 to_char(trunc(decode(e.deptno,10,e.sal*0.07,20,e.sal*0.04,30,(sal+nvl(comm,0))*0.1,e.sal*0.03),0),'9,999') increase,
			 d.deptno,lower(d.dname),lower(d.loc),z.zipcode,z.sido,z.gugun,z.dong,z.bunji
from emp e,dept d,zipcode z
where (e.deptno=d.deptno and e.empno=z.seq) and (e.ename like '%S' or e.ename like '__A__');

/*
1. 배기량이 1500~3000 사이인 차량의 제조국,제조사,모델명,년식,가격,
    이미지,입력일,배기량, 옵션을 조회
   단. 출력은 배기량의 내림차순 정렬했을때 3~6번째 레코드만 조회하고,
     옵션은 처음 ',' 까지만 출력 할것. 가격과 연식은 3자리마다 ,를 넣어출력,
     입력일은 월-일-년 의 형식으로 출력 할것.
      --한상민
*/

select  country, maker, model,to_char(car_year,'9,999') car_year, to_char(price,'9,999') price, car_img, to_char(hiredate,'mm-dd-yy') hiredate, cc,
					substr(car_option,1,instr(car_option,',')-1) car_option
from (select row_number()over(order by cmo.cc desc) flag_cc,cco.country, cma.maker, cma.model, cmo.car_year, cmo.price, cmo.car_img,
						 cmo.hiredate, cmo.cc, cmo.car_option
			from   car_model cmo, car_maker cma, car_country cco
			where  cco.maker = cma.maker and cma.model=cmo.model) and (cmo.cc between 1500 and 3000)
where flag_cc between 3 and 6;

/*

4. 모델명이 'K5','아반테', '소렌토','A8','SM3' 인 차량의 번호, 모델명, 제조국,
  제조사,가격,연식을 아래와 같은 형식의 문장으로 출력.
  단,번호는 1번부터 출력하고,
   출력 가격의 오름차순을 정렬했을 때 2~7 사이의 레코드만 출력,
   [모델명] 차량의 연식은 [ xxxx ]이고, 제조국은 [국산|수입]이며,
   [XX]사가 제조사입니다. 가격은 [0,000,000]원 입니다.

*/
select rownum,'['||model||']차량의 연식은 ['||car_year||']이고, 제조국은['||country
			||']이며,['||maker||']사가 제조사입니다. 가격은 ['||to_char(price,'0,000,000')||']원 입니다.  ' output
from (select	cmo.model ,cmo.car_year,cc.country,cc.maker,cmo.price,
					row_number() over( order by price ) rnum
		from 		car_country cc, car_maker cma, car_model cmo
		where   (cma.maker= cc.maker and cmo.model=cma.model)
						and cmo.model in ('K5','아반테','소렌토','A8','SM3'))
where rnum between 2 and 7;

--오답
select '['||model||']차량의 연식은 ['||car_year||']이고, 제조국은['||country
			||']이며,['||maker||']사가 제조사입니다. 가격은 ['||to_char(price,'0,000,000')||']원 입니다.  ' output
from (	select rownum rnum ,cmd.model ,cmd.car_year,cc.country,cc.maker,cmd.price
	from  car_country cc,car_model cmd,car_maker cmk
	where (cmk.model= cmd.model
				and cc.maker=cmk.maker)
				and cmd.model in ('K5','아반테','소렌토','A8','SM3')
	ORDER BY CMD.PRice )
	where rnum between 2 and 7;
