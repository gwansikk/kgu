CREATE TABLE student (
    id NUMBER(9) PRIMARY KEY,
    name VARCHAR(20),
    grade NUMBER(1)
);


CREATE TABLE lecture (
    no VARCHAR(4) PRIMARY KEY,
    name VARCHAR(30)
);


CREATE TABLE course (
    studentId NUMBER(9),
    lectureNo VARCHAR(4),
    year NUMBER(4) NOT NULL,
    CONSTRAINT pk_course
        PRIMARY KEY(studentId, lectureNo),
    CONSTRAINT fk_course_id 
        FOREIGN KEY (studentId) REFERENCES student(id),
    CONSTRAINT fk_course_no
        FOREIGN KEY (lectureNo) REFERENCES lecture(no)
);