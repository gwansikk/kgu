import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<Book>();

    void run() {
        readAllBooks();
        printAllBooks();
        search();
    }

    void readAllBooks() {

        Book b = null;

        while (true) {
            int n = scanner.nextInt();

            if (n == 0)
                break;

            switch (n) {
                case 1:
                    b = new Book();
                    break;
                case 2:
                    b = new Ebook();
                    break;
                default:
                    break;
            }

            b.read(scanner);
            bookList.add(b);
        }
    }

    void printAllBooks() {
        for (Book book : bookList)
            book.print();

    }

    void search() {
        String key = null;

        while (true) {
            System.out.print(">> ");
            key = scanner.next();

            if (key.equals("0"))
                break;

            for (Book book : bookList) {
                if (book.matches(key)) {
                    book.print();
                    return;
                }
            }

            System.out.println("찾을 수 없습니다.");
        }

    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.run();
    }

}
