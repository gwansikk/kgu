-- 19 학번만 조회
SELECT STUDENT_ID AS 학번, NAME AS 이름, MAJOR AS 전공
FROM USERS
WHERE REGEXP_LIKE(STUDENT_ID, '2019[0123456789]');

-- 화학과
SELECT STUDENT_ID AS 학번, NAME AS 이름
FROM USERS
WHERE MAJOR = '화학과';

-- 18 학번, 컴퓨터공학부 조회
SELECT STUDENT_ID AS 학번, NAME AS 이름
FROM USERS
WHERE STUDENT_ID LIKE '2018%' AND MAJOR = '컴퓨터공학부'; 

-- 수요일에 진행하는 활동그룹
SELECT NAME AS 활동명, PERIOD AS 기한, PLACE AS 장소, STUDENT_ID AS 팀장
FROM GROUPS
WHERE DAY_CYCLE = '수';

-- 회비를 사용한 그룹 그리고 사용한 횟수
SELECT g.NAME AS 활동명, count(*) AS 사용횟수
FROM GROUPS g, MEMBERSHIP m
WHERE g.NO = m.GROUPS_NO
GROUP BY g.NAME;

-- 회비를 사용한 그룹 중 3만원 이상
SELECT g.NAME AS 활동명, m.PRICE AS 가격
FROM GROUPS g, MEMBERSHIP m
WHERE g.NO = m.GROUPS_NO AND m.PRICE >= 40000;

-- 도서 대출
UPDATE BOOKS
SET STUDENT_ID = 201912023,
    RENTAL_DATE = '2022-12-3',
    RETURN_DATE = '2022-12-5'
WHERE NO = 3;

UPDATE BOOKS
SET STUDENT_ID = 201912040,
    RENTAL_DATE = '2022-12-1',
    RETURN_DATE = '2023-1-1'
WHERE NO = 1;

UPDATE BOOKS
SET STUDENT_ID = 201812020,
    RENTAL_DATE = '2022-11-1',
    RETURN_DATE = '2022-12-1'
WHERE NO = 5;

-- 대출된 도서
SELECT NAME AS 책이름, AUTHOR AS 저자, PUBLISHER AS 출판사, STUDENT_ID AS 대여자_학번
FROM BOOKS
WHERE STUDENT_ID IS NOT NULL;

-- 대출되지 않은 도서
SELECT NAME AS 책이름, AUTHOR AS 저자, PUBLISHER AS 출판사
FROM BOOKS
WHERE STUDENT_ID IS NULL;

-- 대출 반납기한이 지난 도서
SELECT NAME AS 책이름, RETURN_DATE AS 반납일, STUDENT_ID AS 대여자_학번
FROM BOOKS
WHERE RETURN_DATE < (
    SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
    FROM DUAL
);

-- 공지 조회
SELECT TITLE AS 제목, CONTENT AS 내용, CREATED_DATE AS 작성일, WRITER AS 작성자
FROM POST
WHERE TYPE = '공지';

-- 게시글에 댓글이 몇 개인지
SELECT POST.TITLE AS 제목, COUNT(*) AS 댓글갯수
FROM POST, COMMENTS
WHERE POST.NO = COMMENTS.POST_NO
GROUP BY POST.TITLE;

-- 1번 공지사항에 대한 댓글 조회
SELECT COMMENTS.WRITER AS 작성자, COMMENTS.CONTENT AS 내용
FROM POST, COMMENTS
WHERE POST.NO = COMMENTS.POST_NO AND POST_NO = 1;

--- 게시글 삭제
DELETE FROM COMMENTS
WHERE POST_NO = 1;
DELETE FROM POST
WHERE NO = 1;

