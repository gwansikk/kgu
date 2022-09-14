import java.util.Scanner;

public class FirstProgram {
    String name;
    int id;
    Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        FirstProgram my = new FirstProgram();
        my.run();
    }

    void run() {
        System.out.println("자바 제대로 배워보자!");
        inputInfo();
        System.out.printf("이름:%s, 학번:%d\n", name, id);
    }

    void inputInfo() {
        System.out.print("이름과 학번을 넣으세요.. ");
        name = scan.next();
        id = scan.nextInt();
    }
}