import java.util.Scanner;

class Lecture {
    String code;
    String name;
    String grade;
    String day;
    String time;

    Lecture(String token) {
        code = token;
    }

    void read(Scanner scanner) {
        // code = scanner.next();
        name = scanner.next();
        grade = scanner.next();
        day = scanner.next();
        time = scanner.next();
    }

    void print() {
        System.out.printf("[%s] %s %s학년 (%s요일 %s)\n", code, name, grade, day, time);
    }

    Boolean match(String key) {
        if (code.equals(key))
            return true;
        return false;
    }
}
