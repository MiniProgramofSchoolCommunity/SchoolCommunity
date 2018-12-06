-- 先使用超级用户在该database下添加插件
-- create extension pgcrypto;
-- 可不使用该插件，在java后台处理
create table log(
userid serial8,
username varchar(20),
pwd text,
primary key(userid)
);

create table role(
roleid int,
rolename varchar(10) not null,
primary key(roleid)
);

create table userbasicinfo(
userid bigint not null,
email varchar(30) not null,
roleid int not null,
status int not null default 0,
sent int not null default 0,
foreign key(userid) references log(userid),
foreign key(roleid) references role(roleid),
unique(email)
);

create table community(
userid bigint not null,
sname varchar(40) not null,
school varchar(40) not null,
slevel int not null,
sintro varchar(100) not null,
sleadername varchar(40) not null,
sleaderidcard varchar(18) not null,
sleadernum varchar(13) not null,
contactsname varchar(40),
contactsnum varchar(13),
foreign key(userid) references log(userid),
primary key(userid),
unique(sname,school)
);

create table corporation(
userid bigint not null,
cname varchar(100) not null,
address varchar(100) not null,
cintro varchar(200) not null,
cregisnum varchar(18) not null,
cleadername varchar(40) not null,
cleaderidcard varchar(18) not null,
cleadernum varchar(13) not null,
contactsname varchar(40),
contactsnum varchar(13),
foreign key(userid) references log(userid),
primary key(userid),
unique(cname,cregisnum)
);

create table authority(
authorityid int,
authorityname varchar(10) not null,
primary key(authorityid)
);

create table activitybasicinfo(
activityid serial8,
publisherid bigint not null,
activityname varchar(60) not null,
activityaddress varchar(120) not null,
date date not null,
time time not null,
activityintro varchar(400) not null,
type int not null,
primary key(activityid),
foreign key(publisherid) references log(userid)
);

create table requirement(
activityid bigint not null,
requirement varchar(40) not null,
sname varchar(40) not null,
slevel int not null,
sleadername varchar(40) not null,
sleadernum varchar(13) not null,
contactsname varchar(40),
contactsnum varchar(13),
foreign key(activityid) references activitybasicinfo(activityid),
primary key(activityid)
);

create table activityneeded(
activityid bigint not null,
cname varchar(100) not null,
requirement varchar(600) not null,
sponsorship varchar(200) not null,
cleadername varchar(40) not null,
cleadernum varchar(13) not null,
contactsname varchar(40),
contactsnum varchar(13),
primary key(activityid)
);

create table manage(
manageruserid bigint not null,
interviwee bigint not null,
primary key(manageruserid,interviwee),
foreign key(manageruserid) references log(userid),
foreign key(interviwee) references log(userid)
);

create table loginstatus(
openid text not null,
token text not null,
primary key(token)
);

insert into role(roleid,rolename) values(0,'超管');
insert into role(roleid,rolename) values(1,'社团联');
insert into role(roleid,rolename) values(2,'社团');
insert into role(roleid,rolename) values(3,'企业');

insert into authority(authorityid,authorityname) values(0,'发布');
insert into authority(authorityid,authorityname) values(1,'删除');
insert into authority(authorityid,authorityname) values(2,'浏览详细信息');
insert into authority(authorityid,authorityname) values(3,'审核社团');
insert into authority(authorityid,authorityname) values(4,'审核企业');
