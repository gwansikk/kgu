import java.util.Scanner;

class Ebook extends Book {
    String url;
    String format;

    Ebook() {

    }

    Ebook(String kwd) {
        super(kwd);
    }

    @Override
    void read(Scanner scanner) {
        super.read(scanner);

        url = scanner.next();
        format = scanner.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("\t%s [%s]\n", url, format);
    }

    @Override
    void printBookType() {
        System.out.print("[전자책] ");
    }

    @Override
    boolean matches(String key) {
        if (super.matches(key))
            return true;

        if (url.contains(key))
            return true;

        if (format.contains(key))
            return true;

        return false;
    }

}
