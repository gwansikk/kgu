import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String id;
    String name;
    String phone;
    String grade;
    ArrayList<Lecture> registeredList = new ArrayList<Lecture>();

    Student(String token) {
        id = token;
    }

    void read(Scanner scanner, Department department) {
        // id = scanner.next();
        name = scanner.next();
        phone = scanner.next();
        grade = scanner.next();

        String code;
        Lecture lecture = null;

        while (true) {
            code = scanner.next();

            if (code.equals("0"))
                break;

            lecture = department.findLecture(code);
            registeredList.add(lecture);
        }
    }

    void print() {
        System.out.printf("%s %s %s (%s학년)\n", id, name, phone, grade);

        for (Lecture lecture : registeredList) {
            System.out.printf("\t");
            lecture.print();
        }
    }

    boolean containsLecture(Lecture lecture) {
        for (Lecture registered : registeredList)
            if (registered.code.equals(lecture.code))
                return true;

        return false;
    }

}
