/*
�Ʒ� ���õ� Data Dictionary�� �ľ��� ��,  Dictionary�� ����Ͽ�
   emp ���̺� �÷���,��������, ũ��, defalut��, ������׸��� ��ȸ�ϼ���.
    ��, ũ��� ������ ��� 22�ڰ� �ƴ� ���� ũ�⸦ ���.
    Dictionary :  user_tab_cols , user_cons_columns, user_constraints
*/
select * from user_tab_cols where table_name='EMP';
select * from user_cons_columns where table_name='EMP';
-- Ư�� ���̺��� ��� ������ �˻�
select * from user_constraints where table_name='EMP';
-- Ư�� ���̺��� Ư�� ���� �˻�.

select  utc.column_name, utc.data_type,
        nvl(utc.data_precision,utc.data_length ) data_length,
        utc.data_default, ucc.constraint_name,uc.constraint_type
from 		user_tab_cols utc,user_cons_columns ucc,user_constraints uc
where 	(utc.column_name=ucc.column_name and ucc.constraint_name=uc.constraint_name)
			 and utc.table_name='EMP' ;

/*	���йι�*/
/*3.
 ������ �����簡 '����','���','�Ｚ','BMW','AUDI'�̰� �ɼǿ� 'ABS','TCS'��
 �ִ� ������  ������, ������,�𵨸�, ����,����, �ɼ�, �̹���, ��ⷮ ��ȸ
  --��, ������ �������� �����ϰ�, ������ ���ٸ� ������ ������������ ����
   �Ͽ� ���, �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ����Ұ�,
   ��������� ������ Bmw, Audi �� �������� ��� .
  -������
*/
 select cco.country, initcap(cma.maker), cmo.model, cmo.car_year,cmo.price, cmo.car_option,
 substr(cmo.car_img, 1, instr(cmo.car_img,'.')-1) imgname, substr(cmo.car_img, instr(cmo.car_img,'.')+1,3) Ȯ���ڸ�, cmo.cc
 from  car_model cmo, car_country cco, car_maker cma
 where (cco.maker = cma.maker and cmo.model = cma.model)
 and cma.maker in ('����','���','�Ｚ','BMW','AUDI')
 and (cmo.car_option like '%ABS%' or cmo.car_option like '%TCS%')
 order by cmo.car_year desc, cmo.price desc;

/*6. ������� 'S'�� �����ų� �̸�5���̸鼭 ����° ���ڰ� 'A'��
   �����  �����ȣ, �����, �Ի���,����,����, �Ǽ��ɾ�, �����λ��,
   �μ���ȣ,�μ���,��ġ,�����ȣ,�õ�, ����,��,���� �� ��ȸ
   ��,�Ǽ��ɾ��� ����+������+���ʽ�-����(���� 3.3) �� ���
     �����λ���� �μ���ȣ�� ���� ���� �λ�
     10- ��� 7%, 20- ��� 4%, 30- ���+���ʽ� 10%, �׿� 3%��
     ����Ͽ� 3�ڸ����� ,�� �־� ���.
     ��� ����� �ҹ��ڷ� ���.

     -���ϴ�
*/

select e.empno,lower(e.ename),e.hiredate,e.sal,e.sal*0.033 tax,
	     trunc((sal+(sal/12)+nvl(comm,0)-(sal*0.033)),0) real_income,
			 to_char(trunc(decode(e.deptno,10,e.sal*0.07,20,e.sal*0.04,30,(sal+nvl(comm,0))*0.1,e.sal*0.03),0),'9,999') increase,
			 d.deptno,lower(d.dname),lower(d.loc),z.zipcode,z.sido,z.gugun,z.dong,z.bunji
from emp e,dept d,zipcode z
where (e.deptno=d.deptno and e.empno=z.seq) and (e.ename like '%S' or e.ename like '__A__');

/*
1. ��ⷮ�� 1500~3000 ������ ������ ������,������,�𵨸�,���,����,
    �̹���,�Է���,��ⷮ, �ɼ��� ��ȸ
   ��. ����� ��ⷮ�� �������� ���������� 3~6��° ���ڵ常 ��ȸ�ϰ�,
     �ɼ��� ó�� ',' ������ ��� �Ұ�. ���ݰ� ������ 3�ڸ����� ,�� �־����,
     �Է����� ��-��-�� �� �������� ��� �Ұ�.
      --�ѻ��
*/

select  country, maker, model,to_char(car_year,'9,999') car_year, to_char(price,'9,999') price, car_img, to_char(hiredate,'mm-dd-yy') hiredate, cc,
					substr(car_option,1,instr(car_option,',')-1) car_option
from (select row_number()over(order by cmo.cc desc) flag_cc,cco.country, cma.maker, cma.model, cmo.car_year, cmo.price, cmo.car_img,
						 cmo.hiredate, cmo.cc, cmo.car_option
			from   car_model cmo, car_maker cma, car_country cco
			where  cco.maker = cma.maker and cma.model=cmo.model) and (cmo.cc between 1500 and 3000)
where flag_cc between 3 and 6;

/*

4. �𵨸��� 'K5','�ƹ���', '�ҷ���','A8','SM3' �� ������ ��ȣ, �𵨸�, ������,
  ������,����,������ �Ʒ��� ���� ������ �������� ���.
  ��,��ȣ�� 1������ ����ϰ�,
   ��� ������ ���������� �������� �� 2~7 ������ ���ڵ常 ���,
   [�𵨸�] ������ ������ [ xxxx ]�̰�, �������� [����|����]�̸�,
   [XX]�簡 �������Դϴ�. ������ [0,000,000]�� �Դϴ�.

*/
select rownum,'['||model||']������ ������ ['||car_year||']�̰�, ��������['||country
			||']�̸�,['||maker||']�簡 �������Դϴ�. ������ ['||to_char(price,'0,000,000')||']�� �Դϴ�.  ' output
from (select	cmo.model ,cmo.car_year,cc.country,cc.maker,cmo.price,
					row_number() over( order by price ) rnum
		from 		car_country cc, car_maker cma, car_model cmo
		where   (cma.maker= cc.maker and cmo.model=cma.model)
						and cmo.model in ('K5','�ƹ���','�ҷ���','A8','SM3'))
where rnum between 2 and 7;

--����
select '['||model||']������ ������ ['||car_year||']�̰�, ��������['||country
			||']�̸�,['||maker||']�簡 �������Դϴ�. ������ ['||to_char(price,'0,000,000')||']�� �Դϴ�.  ' output
from (	select rownum rnum ,cmd.model ,cmd.car_year,cc.country,cc.maker,cmd.price
	from  car_country cc,car_model cmd,car_maker cmk
	where (cmk.model= cmd.model
				and cc.maker=cmk.maker)
				and cmd.model in ('K5','�ƹ���','�ҷ���','A8','SM3')
	ORDER BY CMD.PRice )
	where rnum between 2 and 7;
