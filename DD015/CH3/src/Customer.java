/**
 * 손님의 객체가 생긴다는 것은 복권을 구매했다는 것과 같다.
 * 따라서 객체가 생기는 순간 랜덤으로 숫자가 지정된다. (생성자)
 */

class Customer {
    String name;
    String phone;
    int[] gmaeNum = new int[6];

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;

        // 랜덤
        for (int i = 0; i < 6; i++) {
            gmaeNum[i] = (int) (Math.random() * 44 + 1);
        }
    }

    void print() {
        System.out.print(phone + " [");

        for (int i : gmaeNum) {
            System.out.printf(" %2d", i);
        }

        System.out.print("] ");
    }
}