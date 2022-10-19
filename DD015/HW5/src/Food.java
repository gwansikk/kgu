import java.util.Scanner;

public class Food {
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

	void read(Scanner scan) {
		type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}

	@Override
	public String toString() {
		return String.format("[%2d] %s-%s (%dkcal/%s)", id, type, name, cal, unit);
	}

	int getKcal(int s, String u) {
		return s * cal;
	}

	String getDetail(int n, String unit) {
		return String.format("%dkcal/%d%s", cal, 1, this.unit);
	}
}