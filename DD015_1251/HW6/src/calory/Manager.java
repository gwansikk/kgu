package calory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

abstract public class Manager {
    ArrayList<Manageable> foodList = new ArrayList<Manageable>();
    ArrayList<Manageable> eatlist = new ArrayList<Manageable>();
    HashMap<String, Manageable> foodMap = new HashMap<>();

    static Scanner scan = new Scanner(System.in);

    void readFoods(Factory facroty) {
        Manageable m = null;
        String type;

        while (true) {
            type = scan.next();

            if (type.equals("0"))
                break;

            m = facroty.create();
            m.read(scan, null);
            foodList.add(m);
            foodMap.put(m.getName(), m);
            // System.out.println(m);
        }

        for (Manageable f : foodList) {
            System.out.println(f);
        }
    }

    void readEats(Factory facroty) {
        int day, month;
        String eatType;
        int totalCal = 0;

        month = scan.nextInt();
        day = scan.nextInt();
        eatType = scan.next();

        int cc = scan.nextInt();

        for (int i = 0; i < cc; i++) {
            Eat et = new Eat();

            et.read(scan, this);
            eatlist.add(et);
            totalCal += et.getKcal(et.kcal, et.unit);
        }

        System.out.printf("%d/%d %s ", month, day, eatType);
        System.out.printf("총칼로리: %dkcal\n", totalCal);

        for (Manageable f : eatlist)
            System.out.println("  " + f);
    }

    Manageable findFood(String n) {
        Manageable f = foodMap.get(n);

        if (f == null) {
            System.out.println("find null => " + n);
            throw new NullPointerException();
        }
        return f;
    }
}
