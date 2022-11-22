/* 3-1 */
SELECT no 
FROM lecture 
WHERE name = '데이터베이스';

/* 3-2 */

SELECT id, name 
FROM student 
WHERE name LIKE '박%';

/* 3-3 */
SELECT id, name 
FROM student 
WHERE id IN (
    SELECT studentId 
    FROM course 
    WHERE lectureNo = '1250'
);

/* 3-4 */
SELECT no
FROM lecture 
WHERE no NOT IN (
    SELECT lectureNo 
    FROM course 
);

/* 3-5 */
SELECT grade
FROM student 
WHERE id IN (
    SELECT studentId 
    FROM course 
    WHERE lectureNo = '1250'
)
GROUP BY grade;

/* 3-6 */
SELECT  no, name
FROM lecture 
WHERE no IN (
    SELECT lectureNo
    FROM course c, student s
    WHERE c.studentId = s.id AND grade = 2
    GROUP BY lectureNo
);


/* 3-7 */
SELECT id, COUNT(*) AS cnt
FROM course c, student s
WHERE c.studentId = s.id AND grade = 2
GROUP BY id
HAVING COUNT(id)>=2