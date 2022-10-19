package Java.CH9;

class A {
    private int a; // 전용
    int b; // 디폴트
    public int c; // 공용
}

public class Test {
    public static void main(String args[]) {
        A obj = new A(); // 객체생성
        obj.a = 10;
        obj.b = 20;
        obj.c = 30;
    }
}