package Java.CH11;

class Item {
    public int price;
}

class Noodle extends Item {
    public Noodle() {
        price = 2500;
    }

    @Override
    public String toString() {
        return "Noodle";
    }
}

class Mixnoodle extends Item {
    public Mixnoodle() {
        price = 3000;
    }

    @Override
    public String toString() {
        return "Marynoodle";
    }
}

class Wodong extends Item {
    public Wodong() {
        price = 2500;
    }

    @Override
    public String toString() {
        return "Wodong";
    }
}

class Buyer {
    private int money;

    public Buyer(int money) {
        this.money = money;
    }

    public void buy(Item item, int count) {
        System.out.println(item + "을 " + count + "개를 맛있게 먹었습니다.");
        money = money - (item.price * count);
        System.out.println("남은 돈: " + money);
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Buyer buyer = new Buyer(20000);

        buyer.buy(new Noodle(), 1);
        buyer.buy(new Mixnoodle(), 2);
        buyer.buy(new Wodong(), 3);
    }
}
