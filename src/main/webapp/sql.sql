select * from shop_member;
select * from shop_board;


create table shop_board (
no number primary key,
tit varchar2(200) not null,
con varchar2(2000) not null,
writer varchar(200) not null,
regdate date default sysdate,
viewed number default 0,
thumb number default 0,
lock_post number default 1
);

insert into shop_board values(
1,
'제목1',
'내용1',
'작성자',
sysdate,
0,
0,
1
);

insert into shop_board values(
(select nvl(max(no),0)+1 from shop_board),
'제목2',
'내용2',
'작성자',
sysdate,
0,
0,
1
);

select * from shop_board;

--------------------------------------------------------------------------------
drop table shop_member;
create table shop_member(
mno number,
mid varchar2(100) not null primary key,
mpw varchar2(2000) not null,
mname varchar2(20) not null,
mtel varchar2(50) not null,
maddress varchar2(200) not null,
memail varchar2(100) not null,
mnick varchar2(50) not null,
mcash number default 0,
mpoint number default 0,
mgrade number default 1,
mjday date default sysdate,
mlatest date default sysdate
);

insert into shop_member values(
1,
'admin',
'1234',
'관리자',
'010-0000-0000',
'파주시',
'admin@admin.com',
'관리자',
1000,
1000,
5,
sysdate,
sysdate
);

insert into shop_member values(
(select nvl(max(mno),0)+1 from shop_member),
'admin2',
'1234',
'관리자2',
'010-0000-0000',
'파주시',
'admin2@admin.com',
'관리자2',
1000,
1000,
5,
sysdate,
sysdate
);

select * from shop_member;

desc shop_member;
commit;


update shop_member set mpoint=mpoint+10 where mid='admin';
update shop_member set mpw='MTIzNA==' where mid='admin';