package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Manager {
	static public Scanner sc = new Scanner(System.in);
	protected ArrayList<Manageable> mList = new ArrayList<>();

	public Manageable find(String name) {
		for (Manageable p : mList) {
			if (p.matches(name))
				return p;
		}
		return null;
	}

	public void readNAdd(Factory fac) {
		Manageable m = fac.create();
		m.read(sc);
		add(m);
	}

	public void add(Manageable m) {
		mList.add(m);
	}

	public void printAll() {
		for (Manageable p : mList)
			p.print();
	}
}