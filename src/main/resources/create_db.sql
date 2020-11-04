drop table if exists ITEM;

drop table if exists ORDERS;

drop table if exists USER;

drop table if exists CATEGOTY;

create table "USER"
(
  "ID"       BIGINT       NOT NULL AUTO_INCREMENT,
  "NICKNAME" VARCHAR(100) NOT NULL,
  "EMAIL"    VARCHAR(100) NOT NULL,
  "BIRTHDAY" DATE         NOT NULL,
  CONSTRAINT "USER_PKEY" PRIMARY KEY ("ID")
);

insert into USER (ID, NICKNAME, EMAIL, BIRTHDAY)
values
  (1, 'Mark', 'Markovich@mail.net', '1988-12-13'),
  (2, 'Marina', 'poli@ukr.net', '2000-05-13'),
  (3, 'Petr', 'petrosik@gmail.net', '2005-08-23'),
  (4, 'Gosh', 'lombok@meta.net', '1986-09-30'),
  (5, 'Mila', 'romik@ukr.net', '1996-06-27');


create table "ITEM"
(
  "ID"              BIGINT       NOT NULL AUTO_INCREMENT,
  "NAME"            VARCHAR(100) NOT NULL,
  "PRICE"           INT          NOT NULL,
  "AVAILABLE_COUNT" LONG         NOT NULL,
  "CATEGORY_ID"        INT          NOT NULL,
  CONSTRAINT "ITEM_PKEY" PRIMARY KEY ("ID")
);

insert into ITEM (ID, NAME, PRICE, AVAILABLE_COUNT, CATEGORY_ID)
values
  (1, 'Ball', 90, 9, 1),
  (2, 'MiniBall', 45, 16, 1),
  (3, 'T-shirt', 90, 3, 2),
  (4, 'Cup', 44, 12, 3),
  (5, 'Cross', 25, 35, 4);

create table "CATEGORY"
(
  "ID"   BIGINT       NOT NULL AUTO_INCREMENT,
  "NAME" VARCHAR(100) NOT NULL,
  CONSTRAINT "CATEGORY_PKEY" PRIMARY KEY ("ID")
);

insert into CATEGORY (ID, NAME)
values
  (1, 'INVENTORY'),
  (2, 'CLOTHES'),
  (3, 'CAP'),
  (4, 'FOOTWEAR');

create table "ORDERS"
(
  "ID" BIGINT NOT NULL AUTO_INCREMENT,

  CONSTRAINT "ORDERS_PKEY" PRIMARY KEY ("ID")
);

/*create table EMPLOYEE_DEPARTMENT
(
  "EMPLOYEE_ID"   BIGINT NOT NULL,
  "DEPARTMENT_ID" BIGINT NOT NULL,
  PRIMARY KEY (EMPLOYEE_ID, DEPARTMENT_ID),
  FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

insert into EMPLOYEE_DEPARTMENT (EMPLOYEE_ID, DEPARTMENT_ID)
values
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 2),
  (6, 3),
  (7, 4),
  (8, 4),
  (9, 1),
  (10, 3);*/
