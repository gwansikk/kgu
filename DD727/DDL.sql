create sequence BOOKS_SEQ_AUTO
    maxvalue 9999999999
    nocache;

create sequence GROUPS_SEQ_AUTO
    maxvalue 9999999999
    nocache;

create sequence MEMBERSHIP_SEQ_AUTO
    maxvalue 9999999999
    nocache;

create sequence POST_SEQ_AUTO
    maxvalue 9999999999
    nocache;

create sequence COMMENTS_SEQ_AUTO
    maxvalue 9999999999
    nocache;

create table USERS
(
    STUDENT_ID CHAR(9)       not null,
    ID         VARCHAR2(100) not null,
    PASSWORD   VARCHAR2(100) not null,
    NAME       VARCHAR2(40)  not null,
    PHONE      CHAR(13)      not null,
    MAJOR      VARCHAR2(100) not null,
    constraint PK_USERS
        primary key (STUDENT_ID)
);

create table BOOKS
(
    NO          NUMBER(10)    not null,
    NAME        VARCHAR2(100) not null,
    AUTHOR      VARCHAR2(100),
    PUBLISHER   VARCHAR2(100),
    STUDENT_ID  CHAR(9),
    RENTAL_DATE DATE,
    RETURN_DATE DATE,
    constraint PK_BOOKS
        primary key (NO),
    constraint FK_BOOKS
        foreign key (STUDENT_ID) references USERS
);

create table GROUPS
(
    NO         NUMBER(10) not null,
    PERIOD     DATE       not null,
    PLACE      VARCHAR2(100),
    DAY_CYCLE  DATE       not null,
    STUDENT_ID CHAR(9),
    constraint PK_GROUPS
        primary key (NO),
    constraint FK_GROUPS
        foreign key (STUDENT_ID) references USERS
);

create table GROUPS_JOIN
(
    GROUPS_NO  NUMBER(10) not null,
    STUDENT_ID CHAR(9)    not null,
    constraint PK_GROUPS_JOIN
        primary key (GROUPS_NO, STUDENT_ID),
    constraint FK_GROUPS_JOIN_ID
        foreign key (STUDENT_ID) references USERS,
    constraint FK_GROUPS_JOIN_NO
        foreign key (GROUPS_NO) references GROUPS
);

create table MEMBERSHIP
(
    NO        NUMBER(10)    not null,
    USE_DATE  DATE          not null,
    PURPOSE   VARCHAR2(100) not null,
    PRICE     NUMBER(8)     not null,
    GROUPS_NO NUMBER(10),
    constraint PK_MEMBERSHIP
        primary key (NO),
    constraint FK_MEMBERSHIP
        foreign key (GROUPS_NO) references GROUPS
);

create table POST
(
    NO           NUMBER(10)     not null,
    TYPE         VARCHAR2(10)   not null,
    TITLE        VARCHAR2(50)   not null,
    CONTENT      VARCHAR2(1000) not null,
    CREATED_DATE DATE           not null,
    STUDENT_ID   CHAR(9)        not null,
    constraint PK_POST
        primary key (NO),
    constraint FK_POST
        foreign key (STUDENT_ID) references USERS
);

create table COMMENTS
(
    POST_NO NUMBER(10)    not null,
    NO      NUMBER(10)    not null,
    WRITER  VARCHAR2(20)  not null,
    CONTENT VARCHAR2(200) not null,
    constraint PK_COMMENTS
        primary key (POST_NO, NO),
    constraint FK_COMMENTS_POST
        foreign key (POST_NO) references POST
);

