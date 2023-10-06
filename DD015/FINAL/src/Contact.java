package DD015.CT1.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    Scanner scanner = new Scanner(System.in);
    ArrayList<People> peopleList = new ArrayList<People>();

    void run() {
        readAll();

        int kwd = 0;

        while (true) {
            System.out.println("############ 연락처 관리 ############");
            System.out.print("(1) 연락처 출력  (2) 새로 등록  (3) 삭제  (4) 검색  (5) 수정  (6) 끝내기  ... ");
            kwd = scanner.nextInt();

            switch (kwd) {
                case 1:
                    printAll();
                    break;
                case 2:
                    addPeople();
                    break;
                case 3:
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    break;
            }

        }
    }

    void addPeople() {
        String phone = null;
        String name = null;
        String ord = null;

        System.out.print("전화번호 : ");
        phone = scanner.next();
        System.out.print("이름 : ");
        name = scanner.next();
        System.out.print("나이 : ");
        ord = scanner.next();

        People pe = new People(phone, name, ord);
        peopleList.add(pe);
    }

    void search() {
        String kwd = null;

        System.out.print("검색할 키워드: ");
        kwd = scanner.next();

        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).matchs(kwd)) {
                System.out.printf("[%d] ", i + 1);
                peopleList.get(i).print();
            }
        }
    }

    void printAll() {
        int count = 1;

        for (People people : peopleList) {
            System.out.printf("[%d] ", count++);
            people.print();
        }
    }

    void readAll() {
        String kwd = null;

        while (true) {
            kwd = scanner.next();

            if (kwd.equals("end"))
                break;

            People pe = new People(kwd);
            pe.read(scanner);

            peopleList.add(pe);
        }
    }

    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.run();
    }
}
