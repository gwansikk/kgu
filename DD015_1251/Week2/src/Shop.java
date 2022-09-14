import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Item> items = new ArrayList<Item>();

    void run() {
        readAll();
        printAll();
    }

    void readAll() {
        while (true) {
            Item item = new Item();

            // 0이 입력될 경우 read 종료
            if (item.read(scanner)) {
                item = null; // 객체 삭제
                break;
            }

            items.add(item);
        }
    }

    void printAll() {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%2d) ", i + 1);
            items.get(i).print();
        }

    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.run();
    }
}
