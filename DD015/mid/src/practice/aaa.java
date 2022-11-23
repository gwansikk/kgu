package practice;

import java.util.Scanner;

public class aaa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = null;

        String keywords[] = { "one", "two", "three", "four", "five" };
        for (int k = 0; k < 10; k++) {
            word = scan.next();

            for (int i = 0; i < keywords.length; i++) {
                if (word.equals(keywords[i]))
                    word = Integer.toString(i + 1);
            }

            System.out.print(word + " ");
        }

        scan.close();
    }
}
