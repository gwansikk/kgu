package calory;

import java.util.Scanner;

class Food implements Manageable {
	static int serialNo = 0;
	int id;
	String type;
	String name;
	String unit;
	int cal;

	Food(String type) {
		id = ++serialNo;
		this.type = type;
	}

	@Override
	public void read(Scanner scan, Manager main) {
		// type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}

	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", cal, 1, this.unit);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getKcal(int s, java.lang.String u) {
		return s * cal;
	}

	@Override
	public String toString() {
		return String.format("[%2d] %s-%s (%dkcal/%s)", id, type, name, cal, unit);
	}
}