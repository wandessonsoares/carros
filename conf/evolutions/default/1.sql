# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table carro (
  id                        bigint not null,
  marca                     varchar(255),
  modelo                    varchar(255),
  cor                       varchar(255),
  constraint pk_carro primary key (id))
;

create sequence carro_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists carro;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists carro_seq;

