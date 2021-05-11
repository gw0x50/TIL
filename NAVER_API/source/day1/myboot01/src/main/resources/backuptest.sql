-- conn system/system
-- create user backupuser identified by backupuser;
-- grant connect, resource to backupuser;
-- conn backupuser/backupuser;


--conn jdbc/jdbc

create table inform(
name varchar2(30) , 
age number(5)
);

insert into inform values('javaname', 20);
insert into inform values('oraclename', 30);
insert into inform values('springname', 28);
insert into inform values('bootname', 40);
insert into inform values('servletname', 50);
--commit;


select * from inform;

-- 5개 데이터 insert 상태 백업하자
--(도스) exp userid=jdbc/jdbc@xe file=c:/kdigital/backup tables=(inform) 

drop table inform;
select * from inform;

--(도스) imp userid=jdbc/jdbc@xe file=c:/kditial/backup tables=(inform) 

select * from inform;