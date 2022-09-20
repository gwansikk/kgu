import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LottoSystem {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    int[] gameNum = new int[6];

    void run() {
        readAll();
        gameStart();
        printAll();
    }

    void readAll() {
        while (true) {
            String name = scanner.next();

            // 0이 입력되면 입력 종료
            if (name.equals("0"))
                return;

            String phone = scanner.next();

            // 리스트에 추가
            customerList.add(new Customer(name, phone));
        }
    }

    void printAll() {
        for (Customer customer : customerList) {
            int checkNum = 0; // 당첨 숫자 카운트

            // 전화번호, 게임 숫자 출력
            customer.print();

            // 당첨된 숫자 확인
            for (int i = 0; i < gameNum.length; i++) {
                int key = gameNum[i];

                Arrays.sort(customer.gmaeNum);
                if (Arrays.binarySearch(customer.gmaeNum, key) >= 0) {
                    checkNum++;
                }
            }

            // 당첨 숫자 출력
            System.out.print("==> (" + checkNum + "개) ");

            // 등수 출력
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
            gameNum[i] = (int) (Math.random() * 44 + 1);
        }

        System.out.print("추첨번호 [");

        for (int numList : gameNum)
            System.out.print(" " + numList);

        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        LottoSystem lottoSystem = new LottoSystem();
        lottoSystem.run();
    }
}
