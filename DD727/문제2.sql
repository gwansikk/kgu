INSERT INTO student (id, name, grade)
VALUES (201912023, '김관식', 2);

INSERT INTO student (id, name, grade)
VALUES (201912111, '홍길동', 2);

INSERT INTO student (id, name, grade)
VALUES (202013004, '박성민', 4);

INSERT INTO student (id, name, grade)
VALUES (201811934, '키보드', 2);

INSERT INTO student (id, name, grade)
VALUES (201733441, '마우스', 2);


SELECT * FROM student;


INSERT INTO lecture (no, name)
VALUES ('0663', '직무이해와자기개발');

INSERT INTO lecture (no, name)
VALUES ('1847', '공학윤리');

INSERT INTO lecture (no, name)
VALUES ('0601', '컴퓨터과학개론');

INSERT INTO lecture (no, name)
VALUES ('1251', '객체지향프로그래밍');

INSERT INTO lecture (no, name)
VALUES ('1250', '데이터베이스');

INSERT INTO lecture (no, name)
VALUES ('1248', '계산이론');

INSERT INTO lecture (no, name)
VALUES ('1264', '컴퓨터네트워크');

INSERT INTO course (studentId, lectureNo, year)
VALUES (201912023, '1250', 2022);

INSERT INTO course (studentId, lectureNo, year)
VALUES (201912023, '1264', 2022);

INSERT INTO course (studentId, lectureNo, year)
VALUES (201912023, '1248', 2022);


INSERT INTO course (studentId, lectureNo, year)
VALUES (201811934, '1250', 2022);

INSERT INTO course (studentId, lectureNo, year)
VALUES (201733441, '0663', 2022);

INSERT INTO course (studentId, lectureNo, year)
VALUES (201733441, '0601', 2022);

INSERT INTO course (studentId, lectureNo, year)
VALUES (202013004, '1248', 2019);


