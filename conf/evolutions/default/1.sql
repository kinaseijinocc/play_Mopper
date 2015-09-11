# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table place (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_place primary key (id))
;

create table syain (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_syain primary key (id))
;

create sequence place_seq;

create sequence syain_seq;




# --- !Downs

drop table if exists place cascade;

drop table if exists syain cascade;

drop sequence if exists place_seq;

drop sequence if exists syain_seq;

