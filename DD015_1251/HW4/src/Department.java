import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
    ArrayList<Student> studentList = new ArrayList<Student>();

    void run() {
        int key = 0;

        // 입력값 받기
        readAllLectures();
        readAllStudent();

        System.out.printf("대분류 (1) 학생 (2) 과목 (3) 연관검색 : ");
        key = scanner.nextInt();

        switch (key) {
            case 1:
                printAllStudent();
                break;
            case 2:
                printAllLectures();
                break;
            case 3:

                System.out.println("연관검색 메뉴 (1) 과목별 수강생 (2) 요일별 수강생");
                System.out.printf("(3) 타학년 과목 수강생수 조사 : ");
                key = scanner.nextInt();

                switch (key) {
                    case 1:
                        searchStudentsByLecture();
                        break;
                    case 2:
                        searchStudentsByLecture();
                        break;
                    case 3:
                        countLectureByDifferentGrade();
                        break;
                    default:
                        break;
                }

            default:
                break;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.run();
    }

    void readAllStudent() {
        Student st = null;
        String token = null;

        while (true) {
            token = scanner.next();

            if (token.equals("0"))
                break;

            st = new Student(token);
            st.read(scanner, this);
            studentList.add(st);
        }
    }

    void printAllStudent() {
        for (Student student : studentList) {
            student.print();
        }
    }

    void readAllLectures() {
        Lecture lt = null;
        String token = null;

        while (true) {
            token = scanner.next();

            if (token.equals("end"))
                break;

            lt = new Lecture(token);
            lt.read(scanner);
            lectureList.add(lt);
        }
    }

    void printAllLectures() {
        for (Lecture lecture : lectureList) {
            lecture.print();
        }
    }

    Lecture findLecture(String token) {
        for (Lecture lecture : lectureList)
            if (lecture.code.equals(token))
                return lecture;

        return null;
    }

    void searchStudentsByLecture() {
        String kwd;

        System.out.print("검색할 과목: ");
        kwd = scanner.next();
        Lecture lecture = null;

        for (Lecture lec : lectureList)
            if (lec.match(kwd))
                lecture = lec;

        if (lecture == null) {
            System.out.println("없는 과목명입니다.");
            return;
        }

        System.out.printf("%s %s %s학년 %s요일/%s", lecture.code, lecture.name, lecture.grade, lecture.day, lecture.time);

        for (Student student : studentList) {
            if (student.containsLecture(lecture))
                System.out.printf("\t%s %s (%s학년)\n", student.id, student.name, student.grade);
        }
    }

    void searchStudentsByDays() {
        String kwd;

        System.out.print("검색할 요일: ");
        kwd = scanner.next();

        System.out.printf("%s요일 과목을 수강하는 학생: ", kwd);

        for (Student student : studentList) {
            if (student.matchDays(kwd))
                System.out.print(student.name + " ");
        }

        System.out.println("");
    }

    void countLectureByDifferentGrade() {
        for (Lecture lecture : lectureList) {
            int count = 0;

            System.out.printf("[%s] %s %s학년 %s요일/%s ", lecture.code, lecture.name, lecture.grade, lecture.day,
                    lecture.time);

            for (Student student : studentList) {
                if (student.containsLecture(lecture)) {
                    if (student.grade.equals(lecture.grade) == false) // 다르면
                        count++;
                }
            }

            System.out.println(count + "명");
        }
    }
}
