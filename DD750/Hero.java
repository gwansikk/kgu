import java.util.Scanner;

class Hero1 {
    protected String name;

    public Hero1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("영웅입력: ");
        String name = scanner.next();

        this.name = name;
    }

    public Hero1(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Heroman extends Hero1{
    private String level;

    public Heroman() {
        super();

        Scanner scanner = new Scanner(System.in);
        System.out.print("무기입력: ");
        level = scanner.next();
    }

    public Heroman(String name, String level) {
        super.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + "이(가) " + level + "로 이동";
    }
}

public class Hero {
    public static void main(String[] args) {
        Hero1[] list = new Heroman[3];

        System.out.println("영웅과 무기를 입력하시오");

        for (int i = 0; i < list.length; i++) {
            list[i] = new Heroman();
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
