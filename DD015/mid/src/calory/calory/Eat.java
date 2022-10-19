package calory.calory;

import java.util.Scanner;

import calory.mgr.Manageable;

class Eat implements Manageable {
	Food food;
	int qnty;
	String unit;
	int kcal;

	public void read(Scanner scan) {
		String name = scan.next();
		qnty = scan.nextInt();
		unit = scan.next();
		food = (Food) Dine.foodMgr.find(name);
		kcal = getKcal();
	}

	public void print() {
		System.out.println(this);
	}

	public boolean matches(String kwd) {
		return false;
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