package calory;

import java.util.Scanner;

class Eat implements Manageable {
	Food food;
	int qnty;
	String unit;
	int kcal;

	@Override
	public void read(Scanner scan, Manager main) {
		String name = scan.next();
		food = (Food) main.findFood(name);
		qnty = scan.nextInt();
		kcal = getKcal(qnty, unit);
		unit = food.unit;
	}

	@Override
	public String getName() {
		return food.name;
	}

	@Override
	public int getKcal(int s, String u) {
		return food.getKcal(s, u);
	}

	@Override
	public String toString() {
		return String.format("%s %d%s(%dkcal) - %s", food.name, qnty, unit, kcal, food.getDetail(qnty, unit));
	}
}