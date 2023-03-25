package project;

import java.util.Scanner;

abstract class Friend {
    String name;
    String phone;
    String address;
    String etc;

    public Friend(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public abstract void showAllInfo();

    public abstract void showBasicInfo();
}

class HighFriend extends Friend {
    public HighFriend(String name, String phone, String address, String job) {
        super(name, phone, address);
        this.etc = job;
    }

    @Override
    public void showAllInfo() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phone);
        System.out.println("주소 : " + address);
        System.out.println("직업 : " + etc);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phone);
    }
}

class UnivFriend extends Friend {
    public UnivFriend(String name, String phone, String address, String major) {
        super(name, phone, address);
        this.etc = major;
    }

    @Override
    public void showAllInfo() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phone);
        System.out.println("주소 : " + address);
        System.out.println("전공 : " + etc);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phone);
        System.out.println("전공 : " + etc);
    }
}

class FriendInfoHandler {
    private Friend[] myFriends;
    private int numOfFriends;

    public FriendInfoHandler(int num) {
        myFriends = new Friend[num];
        numOfFriends = 0;
    }

    void addFriendInfo(Friend fren) {
        myFriends[numOfFriends++] = fren;
    }

    void showAllData() {
        for (int i = 0; i < numOfFriends; i++) {
            myFriends[i].showAllInfo();
            System.out.println();
        }
    }

    void showAllSimpleData() {
        for (int i = 0; i < numOfFriends; i++) {
            myFriends[i].showBasicInfo();
            System.out.println();
        }
    }
}

public class Contact {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FriendInfoHandler friendInfoHandler = new FriendInfoHandler(10);

        // Loop
        while (true) {
            String name;
            String phone;
            String address;
            String job;
            String major;
            Friend friend;

            System.out.println("*** 메뉴 선택 ***");
            System.out.println("1. 고교 정보 저장");
            System.out.println("2. 대학 친구 저장");
            System.out.println("3. 전체 정보 출력");
            System.out.println("4. 기본 정보 출력");
            System.out.println("5. 프로그램 종료");
            System.out.print("선택>> ");
            int select = scanner.nextInt();

            switch (select) {
                case 1: // 고교 정보 저장
                    System.out.print("이름 : ");
                    name = scanner.next();
                    System.out.print("전화 : ");
                    phone = scanner.next();
                    System.out.print("주소 : ");
                    address = scanner.next();
                    System.out.print("직업 : ");
                    job = scanner.next();

                    friend = new HighFriend(name, phone, address, job);
                    friendInfoHandler.addFriendInfo(friend);
                    System.out.println("입력 완료!");
                    break;

                case 2: // 대학 친구 저장
                    System.out.print("이름 : ");
                    name = scanner.next();
                    System.out.print("전화 : ");
                    phone = scanner.next();
                    System.out.print("주소 : ");
                    address = scanner.next();
                    System.out.print("학과 : ");
                    major = scanner.next();

                    friend = new UnivFriend(name, phone, address, major);
                    friendInfoHandler.addFriendInfo(friend);
                    System.out.println("입력 완료!");
                    break;

                case 3: // 전체출력
                    friendInfoHandler.showAllData();
                    break;

                case 4: // 기본정보 출력
                    friendInfoHandler.showAllSimpleData();
                    break;

                default:
                    break;
            }

            // 프로그램 종료
            if (select == 5)
                break;
        }

        System.out.println("프로그램이 종료되었습니다!");
    }
}