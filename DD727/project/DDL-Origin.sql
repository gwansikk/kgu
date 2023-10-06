-- 회원
CREATE TABLE users (
    student_id CHAR(9) NOT NULL, -- 기본키, 고정 9자리, 201912023
    id VARCHAR2(100) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    name VARCHAR2(40) NOT NULL,
    phone CHAR(13) NOT NULL, -- 고정 13자리, - 포함
    major VARCHAR2(100) NOT NULL,

    CONSTRAINT PK_USERS PRIMARY KEY (student_id)
);

-- 도서
CREATE TABLE books (
    no NUMBER(10) NOT NULL, -- 기본키, 자동증가
    name VARCHAR2(100) NOT NULL,
    author VARCHAR2(100),
    publisher VARCHAR2(100),

    student_id CHAR(9), -- FK, 대여자
    rental_date DATE,
    return_date DATE,

    CONSTRAINT PK_BOOKS PRIMARY KEY (no),
    CONSTRAINT FK_BOOKS FOREIGN KEY (student_id) REFERENCES USERS(STUDENT_ID)
);

-- 활동그룹
CREATE TABLE groups (
    no NUMBER(10) NOT NULL, -- 기본키, 자동증가
    name VARCHAR2(50) NOT NULL,
    period VARCHAR2(50) NOT NULL,
    place VARCHAR2(100),
    day_cycle VARCHAR2(50) NOT NULL ,

    student_id CHAR(9) NOT NULL, -- FK, 관리자

    CONSTRAINT PK_GROUPS PRIMARY KEY (no),
    CONSTRAINT FK_GROUPS FOREIGN KEY (student_id) REFERENCES USERS(STUDENT_ID)
);

-- 그룹 참여
CREATE TABLE groups_join (
    groups_no NUMBER(10), -- FK, 그룹번호
    student_id CHAR(9), -- FK, 회원번호

    CONSTRAINT PK_GROUPS_JOIN PRIMARY KEY (groups_no, student_id),
    CONSTRAINT FK_GROUPS_JOIN_NO FOREIGN KEY (groups_no) REFERENCES GROUPS(NO),
    CONSTRAINT FK_GROUPS_JOIN_ID FOREIGN KEY (student_id) REFERENCES USERS(STUDENT_ID)
);

-- 회비 (멤버십), 그룹만 사용가능
CREATE TABLE membership (
    no NUMBER(10) NOT NULL, -- 기본키, 자동증가
    use_date DATE NOT NULL,
    purpose VARCHAR2(100) NOT NULL ,
    price NUMBER(8) NOT NULL, -- 1억 단위로 사용할 일이 없으니 천단위 까지

    groups_no NUMBER(10) NOT NULL ,

    CONSTRAINT PK_MEMBERSHIP PRIMARY KEY (no),
    CONSTRAINT FK_MEMBERSHIP FOREIGN KEY (groups_no) REFERENCES GROUPS(NO)
);

-- 게시글
CREATE TABLE post (
    no NUMBER(10) NOT NULL, -- 기본키, 자동증가
    type VARCHAR2(10) NOT NULL,
    title VARCHAR2(50) NOT NULL,
    content VARCHAR2(1000) NOT NULL, -- 내용은 최대 1000자만
    created_date DATE NOT NULL,
    writer VARCHAR2(50) NOT NULL, -- 작성자

    CONSTRAINT PK_POST PRIMARY KEY (no)
);

-- 댓글
CREATE TABLE comments (
    post_no NUMBER(10), -- FK
    no NUMBER(10) NOT NULL, -- 자동증가
    writer VARCHAR2(20) NOT NULL,
    content VARCHAR2(200) NOT NULL, -- 내용은 최대 200자만

    CONSTRAINT PK_COMMENTS PRIMARY KEY (post_no, no),
    CONSTRAINT FK_COMMENTS_POST FOREIGN KEY (post_no) REFERENCES POST(NO)
);


-- 자동증가 시퀀스
CREATE SEQUENCE BOOKS_SEQ_AUTO START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;
CREATE SEQUENCE GROUPS_SEQ_AUTO START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;
CREATE SEQUENCE MEMBERSHIP_SEQ_AUTO START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;
CREATE SEQUENCE POST_SEQ_AUTO START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;
CREATE SEQUENCE COMMENTS_SEQ_AUTO START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;