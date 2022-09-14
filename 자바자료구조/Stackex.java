import java.util.Scanner;
import java.util.Stack;

public class Stackex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        
        int sum = 0;
        int elementNumber = scanner.nextInt();

        for (int i = 0; i < elementNumber; i++) {
            int value = scanner.nextInt();

            if (value == 0) {
                sum -= stack.pop();
            } else {
                sum += value;
                stack.push(value);
            }
        }
        
        System.out.println(sum);
        scanner.close();
    }
}
