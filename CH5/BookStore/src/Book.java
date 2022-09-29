import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String pub;
    String isbn;
    int year;
    int price;
    ArrayList<String> authors = new ArrayList<String>();

    Book() {
    };

    Book(String title) {
        this.title = title;
    }

    void read(Scanner scanner) {
        title = scanner.next();
        pub = scanner.next();
        isbn = scanner.next();
        year = scanner.nextInt();

        while (true) {
            String name = new String();
            name = scanner.next();

            if (name.equals("0"))
                break;

            authors.add(name);
        }

        price = scanner.nextInt();
    }

    void print() {
        System.out.printf("%s (%s/%s/%d년) [%d원] 저자:", title, pub, isbn, year, price);

        for (String author : authors) {
            System.out.print(author + " ");
        }

        System.out.println();
    }

    boolean matches(String key) {
        if (title.contains(key))
            return true;

        if (isbn.contains(key))
            return true;

        return false;

    }
}
