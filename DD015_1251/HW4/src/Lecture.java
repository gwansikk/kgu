import java.util.Scanner;

class Lecture {
    String code;
    String name;
    int grade;
    String day;
    String time;

    Lecture(String token) {
        code = token;
    }

    void read(Scanner scanner) {
        // code = scanner.next();
        name = scanner.next();
        grade = scanner.nextInt();
        day = scanner.next();
        time = scanner.next();
    }

    void print() {
        System.out.printf("[%s] %s %d학년 (%s요일 %s)\n", code, name, grade, day, time);
    }

    void match() {

    }
}
