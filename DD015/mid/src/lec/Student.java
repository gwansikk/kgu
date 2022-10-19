package lec;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	String phone;
	int year;
	int score;
	ArrayList<Subject> registeredList = new ArrayList<>();
	static Random rand = new Random();

	public Student(int id2) {
		id = id2;
	}

	void read(Scanner scan, Department dept) {
		// id = scan.nextInt();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String token = null;
		Subject s = null;
		while (true) {
			token = scan.next();
			if (token.equals("0"))
				break;
			s = dept.findSubject(token);
			registeredList.add(s);
		}	
	}

	void print() { // Student
		System.out.format("%d %s %s (%d학년)", id, name, phone, year);
		if (score != 0)
			System.out.format(" %d점", score);
		System.out.println();
		for (Subject s: registeredList) {
			System.out.print('\t');
			s.print();
		}
	}

	void inputScore(Scanner scan) {
		// System.out.printf("%s: ", name);
		// score = scan.nextInt();
		score = rand.nextInt(100) + 1;
		System.out.printf("%s: %d점\n", name, score);

	}


	boolean matches(String kwd) {
		if (kwd.length() == 1 && Character.isDigit(kwd.charAt(0)))
			return kwd.contentEquals("" + year);
		return (kwd.contentEquals(name) || ("" + id).contains(kwd) || phone.contains(kwd));
	}

	boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if (kwd.charAt(0) == '-') {
				kwd = kwd.substring(1);
				if (matches(kwd))
					return false;
			}
			else if (!matches(kwd))
				return false;
		}
		return true;
	}
}
