drop table BANK_CUSTOMERS;
drop sequence BANK_CUSTOMER_SEQUENCE;

create sequence BANK_CUSTOMER_SEQUENCE;

create table BANK_CUSTOMERS (
  id int primary key,
  name varchar2(80) not null
  );

