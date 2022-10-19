import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dine {
	ArrayList<Food> foods = new ArrayList<>();
	HashMap<String, Food> foodMap = new HashMap<>();
	ArrayList<Eat> eatlist = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Dine a = new Dine();
		a.mymain();
	}

	void mymain() {
		readFoods();
		readEats();
	}

	void readEats() {
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
			totalCal += et.getKcal();
		}

		System.out.printf("%d/%d %s ", month, day, eatType);
		System.out.printf("총칼로리: %dkcal\n", totalCal);

		for (Eat f : eatlist)
			System.out.println("  " + f);
	}

	void readFoods() {
		Food m = null;
		String type;
		while (true) {
			type = scan.next();

			if (type.equals("0"))
				break;

			if (type.equals("1"))
				m = new Food(type);
			else
				m = new FoodPlus(type);

			m.read(scan);
			foods.add(m);
			foodMap.put(m.name, m);
			// System.out.println(m);
		}

		for (Food f : foods) {
			System.out.println(f);
		}
	}

	Food findFood(String n) {
		Food f = foodMap.get(n);
		if (f == null) {
			System.out.println("find null => " + n);
			throw new NullPointerException();
		}
		return f;
	}
}