package book;

import java.util.Scanner;

public class Pen implements Manageable {
	String itemName;
	float mmThick;
	int price;

	@Override
	public void read(Scanner scan) {

		itemName = scan.next();
		mmThick = scan.nextFloat();
		price = scan.nextInt();
	}

	@Override
	public void print() {
		System.out.format("[Pen] %s %fmm %d원\n", itemName, mmThick, price);
	}

	@Override
	public boolean matches(String kwd) {

		if (kwd.contentEquals("Pen")) // 값의 String이 같는지
			return true;
		if (itemName.contains(kwd)) // 포함여부
			return true;
		if (("" + mmThick).contentEquals(kwd))
			return true;
		if (("" + price).contentEquals(kwd))
			return true;
		return false;
	}

}
