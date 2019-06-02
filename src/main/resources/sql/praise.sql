-- -----------------Table for User---------------------------
DROP TABLE IF EXISTS user;

create table user
(
  id      varchar(32) not null comment '用户id',
  name    varchar(20) default null comment '姓名',
  account varchar(20) default null comment '账号',
  primary key (id),
  key user_name_index (name) using btree,
  key user_account_index (account) using btree
) engine = InnoDB
  default charset = utf8;

-- ------------------Table for Mood---------------------
drop table if exists mood;

create table mood(
  id varchar(32) not null comment 'id',
  content varchar(256) default null comment '评论id',
  user_id varchar(32) default null comment '用户Id',
  publish_time datetime default null comment '发布时间',
  praise_num int(11) default null comment '点赞数量',
  primary key (id),
  key mood_user_id_index (user_id) using btree
) engine = InnoDB default charset=utf8;

-- ------------------Table for 点赞-用户评论关系------------------------
drop table if exists user_mood_praise_rel;
create table user_mood_praise_rel(
  id bigint(32) not null auto_increment,
  user_id varchar(32) default null comment '用户id',
  mood_id varchar(32) default null comment '评论id',
  primary key (id),
  key user_mood_praise_rel_user_id_index (user_id) using btree ,
  key user_mood_praise_rel_mood_id_index (mood_id) using btree
) engine =innodb default charset =utf8;


-- -----------------Test Data------------------
delete from user;
insert into user values ('1', 'Lilei', 'digua');
insert into user values ('2', 'HanMeimei', 'tudou');

delete from mood;
insert into mood
values ('1', 'Today is a sunny day.', '1', '2019-06-02 11:07:38', '99');
insert into mood
values ('2', 'Today is children\'s day.', '2', '2019-06-01 10:11:12', 888);
insert into mood
values ('3', 'Today is a day.', '2', '2018-05-01 1:2:3', 333);

-- ---------------------------------------------------
select * from user;

select * from mood;

select * from user_mood_praise_rel;