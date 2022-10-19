package book;

import java.util.Scanner;

public class Pen implements Manageable {
	String itemName;
	float mmThick;
	int price;

	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		itemName = scan.next();
		mmThick = scan.nextFloat();
		price = scan.nextInt();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.format("[Pen] %s %fmm %d원\n",
				itemName, mmThick, price);
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (kwd.contentEquals("Pen"))
			return true;
		if (itemName.contains(kwd))
			return true;
		if (("" + mmThick).contentEquals(kwd))
			return true;
		if (("" + price).contentEquals(kwd))
			return true;
		return false;
	}

}
