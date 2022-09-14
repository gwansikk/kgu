import java.util.Scanner;
import java.util.TreeSet;

public class OrderTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<>();

        int N = in.nextInt();
        for (int i = 0; i < N*3; i++) {
            set.add(in.next());
        }
    }
}
