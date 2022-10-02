import java.util.Scanner;

class Eat {
	Food food;
	int qnty;
	String unit;
	int kcal;

	void read(Scanner scan, Dine main) {
		String name = scan.next(); // 1
		food = main.findFood(name);
		qnty = scan.nextInt(); // 2
		unit = scan.next(); // 3
		kcal = getKcal();
	}

	@Override
	public String toString() {
		return String.format("%s %d%s(%dkcal) - %s",
				food.name, qnty, unit, kcal, food.getDetail(qnty, unit));
	}

	int getKcal() {
		return food.getKcal(qnty, unit);
	}
}