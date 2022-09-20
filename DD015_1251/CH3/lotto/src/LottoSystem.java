import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LottoSystem {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    int[] gameNumber = new int[6];

    void run() {
        readAll();
    }

    void readAll() {
        while (true) {
            String name = scanner.next();

            // 0 입력 받으면 입력 종료
            if (name.equals("0")) {
                gameStart();
                printAll();
                return;
            }

            String phone = scanner.next();

            Customer customer = new Customer(name, phone);
            customerList.add(customer);
        }
    }

    void printAll() {
        for (Customer customer : customerList) {
            int checkNum = 0;

            customer.print();

            for (int i = 0; i < gameNumber.length; i++) {
                int key = gameNumber[i];

                Arrays.sort(customer.number);
                if (Arrays.binarySearch(customer.number, key) >= 0) {
                    checkNum++;
                }
            }

            System.out.print("==> (" + checkNum + "개) ");

            switch (checkNum) {
                case 3:
                    System.out.println("5등");
                    break;
                case 4:
                    System.out.println("4등");
                    break;
                case 5:
                    System.out.println("3등");
                    break;
                case 6:
                    System.out.println("1등");
                    break;

                default:
                    System.out.println("0등");
                    break;
            }
        }
    }

    void gameStart() {
        for (int i = 0; i < 6; i++) {
            gameNumber[i] = (int) (Math.random() * 44 + 1);
        }

        System.out.print("추첨번호 [");

        for (int number : gameNumber) {
            System.out.print(" " + number);
        }

        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.run();
    }
}

/**
 * 손님의 객체가 생긴다는 것은 복권을 구매했다는 것과 같다.
 * 따라서 객체가 생기는 순간 랜덤으로 숫자가 지정된다.
 */
class Customer {
    Scanner scanner = new Scanner(System.in);

    String name;
    String phone;
    int[] number = new int[6];

    public Customer() {
        read(scanner);
        random();
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        random();
    }

    void read(Scanner scanner) {
        name = scanner.next();
        phone = scanner.next();
    }

    void print() {
        System.out.print(phone + " [");

        for (int i : number) {
            System.out.printf(" %2d", i);
        }

        System.out.print("] ");
    }

    void random() {
        for (int i = 0; i < 6; i++) {
            number[i] = (int) (Math.random() * 44 + 1);
        }
    }
}