import java.util.Scanner;

class Item {
    String id;
    String itemName;
    int price;

    boolean read(Scanner scanner) {
        id = scanner.next();

        // 0이 입력될 경우 입력종료
        if (id.equals("0")) {
            return true;
        }

        itemName = scanner.next();
        price = scanner.nextInt();

        return false;
    }

    void print() {
        System.out.printf("[%5s] %-20s %6d원\n", id, itemName, price);

    }
}
