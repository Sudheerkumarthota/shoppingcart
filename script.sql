 drop table cart if exists
 drop table cart_item if exists
 drop table item if exists
 drop table user if exists
 drop sequence if exists hibernate_sequence
 create sequence hibernate_sequence start with 1 increment by 1
 create table cart (id bigint not null, created_on timestamp, updated_on timestamp, primary key (id))
 create table cart_item (item_id bigint not null, course_id bigint not null, primary key (item_id, course_id))
 create table item (id bigint not null, created_on timestamp, name varchar(255), price double, quantity integer, updated_on timestamp, primary key (id))
 create table user (id bigint not null, created_by varchar(255), created_on timestamp, email_id varchar(255), name varchar(255), update_by varchar(255), updated_on timestamp, cart_id bigint, primary key (id))
 alter table cart_item add constraint FK6aam4olbs9v02xta24h2ntwpn foreign key (course_id) references item
 alter table cart_item add constraint FKcfmg10mley03tjpdjiekm8b6j foreign key (item_id) references cart
 alter table user add constraint FKtqa69bib34k2c0jhe7afqsao6 foreign key (cart_id) references cart


 call next value for hibernate_sequence
 insert into user (cart_id, created_by, created_on, email_id, name, update_by, updated_on, id) values (?, ?, ?, ?, ?, ?, ?, ?)
 call next value for hibernate_sequence
 call next value for hibernate_sequence
 insert into item (created_on, name, price, quantity, updated_on, id) values (?, ?, ?, ?, ?, ?)
 insert into item (created_on, name, price, quantity, updated_on, id) values (?, ?, ?, ?, ?, ?)
 select user0_.id as id1_3_0_, user0_.cart_id as cart_id8_3_0_, user0_.created_by as created_2_3_0_, user0_.created_on as created_3_3_0_, user0_.email_id as email_id4_3_0_, user0_.name as name5_3_0_, user0_.update_by as update_b6_3_0_, user0_.updated_on as updated_7_3_0_, cart1_.id as id1_0_1_, cart1_.created_on as created_2_0_1_, cart1_.updated_on as updated_3_0_1_ from user user0_ left outer join cart cart1_ on user0_.cart_id=cart1_.id where user0_.id=?
 call next value for hibernate_sequence
 insert into cart (created_on, updated_on, id) values (?, ?, ?)
 insert into cart_item (item_id, course_id) values (?, ?)
 insert into cart_item (item_id, course_id) values (?, ?)