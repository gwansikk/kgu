package DD015.CT1.src;

import java.util.Scanner;

class People {
    String phone;
    String name;
    String ord;

    People(String phone) {
        this.phone = phone;
    }

    People(String phone, String name, String ord) {
        this(phone);
        this.name = name;
        this.ord = ord;
    }

    void read(Scanner scanner) {
        name = scanner.next();
        ord = scanner.next();
    }

    Boolean matchs(String kwd) {
        if (phone.contains(kwd))
            return true;

        if (name.contains(kwd))
            return true;

        if (ord.equals(kwd))
            return true;

        return false;
    }

    public void print() {
        System.out.printf("%-20s %3s세 %-14s\n", name, ord, phone);
    }
}
