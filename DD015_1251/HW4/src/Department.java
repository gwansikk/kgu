import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
    ArrayList<Student> studentList = new ArrayList<Student>();

    void run() {
        readAllLectures();
        readAllStudent();

        printAllStudent();
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

        lecture.print();

        for (Student student : studentList) {
            if (student.containsLecture(lecture))
                student.print();
        }
    }
}
