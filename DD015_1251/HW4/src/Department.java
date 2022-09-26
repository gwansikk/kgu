import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
    ArrayList<Student> studentList = new ArrayList<Student>();

    void run() {
        readAllLectures();
        readAllStudent();

        printAllLectures();
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

        return null;
    }
}
