package Java.CH14;

import java.io.FileInputStream;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {
        FileInputStream in = null;

        try {
            in = new FileInputStream("test01.txt");

            int c;

            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }

            in.close();
        } catch (IOException e) {
            System.out.println("입출력오류");
        }
    }
}