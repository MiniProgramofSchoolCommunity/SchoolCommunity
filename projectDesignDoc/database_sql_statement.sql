-- 先使用超级用户在该database下添加插件
-- create extension pgcrypto;
-- 可不使用该插件，在java后台处理
-- 使用UFT-8输入


-- 定义系统表和约束关系
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
unique(email),
primary key(userid)
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

create table role_authority(
roleid int not null,
authorityid int not null,
primary key(roleid, authorityid),
foreign key(roleid) references role(roleid),
foreign key(authorityid) references authority(authorityid)
);

-- 定义系统角色
insert into role(roleid,rolename) values(0,'超管');
insert into role(roleid,rolename) values(1,'社团联');
insert into role(roleid,rolename) values(2,'社团');
insert into role(roleid,rolename) values(3,'企业');
insert into role(roleid, rolename) values(4,'未认证用户');

-- 定义系统权限
insert into authority(authorityid,authorityname) values(0,'发布');
insert into authority(authorityid,authorityname) values(1,'删除');
insert into authority(authorityid,authorityname) values(2,'浏览详细信息');
insert into authority(authorityid,authorityname) values(3,'审核社团');
insert into authority(authorityid,authorityname) values(4,'审核企业');

-- 分配用户权限
insert into role_authority(roleid, authorityid) values(0,0);
insert into role_authority(roleid, authorityid) values(0,1);
insert into role_authority(roleid, authorityid) values(0,2);
insert into role_authority(roleid, authorityid) values(0,3);
insert into role_authority(roleid, authorityid) values(0,4);
insert into role_authority(roleid, authorityid) values(1,0);
insert into role_authority(roleid, authorityid) values(1,1);
insert into role_authority(roleid, authorityid) values(1,2);
insert into role_authority(roleid, authorityid) values(1,3);
insert into role_authority(roleid, authorityid) values(2,0);
insert into role_authority(roleid, authorityid) values(2,1);
insert into role_authority(roleid, authorityid) values(2,2);
insert into role_authority(roleid, authorityid) values(3,0);
insert into role_authority(roleid, authorityid) values(3,1);
insert into role_authority(roleid, authorityid) values(3,2);

-- 定义系统管理用户
insert into log (username, pwd) values('stt','82ug05b311fs6kb56afa3vqsbr5tnfnf');
insert into userbasicinfo(userid, email, roleid, sent, status) values(1,'123',0,1,1);
insert into log (username, pwd) values('sxx','82ug05b311fs6kb56afa3vqsbr5tnfnf');
insert into userbasicinfo(userid, email, roleid, sent, status) values(2,'456',1,1,1);
