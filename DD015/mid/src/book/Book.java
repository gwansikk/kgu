package book;

import java.util.ArrayList;
import java.util.Scanner;

class Book implements Manageable {
	// 자료구조 생능출판 1001 2003 천인국 공용해 하상호 0 15000
	String title;
	String pub;
	String isbn;
	int year;
	ArrayList<String> authors = new ArrayList<>();
	int price;

	@Override
	public void read(Scanner scan) {
		title = scan.next();
		pub = scan.next();
		isbn = scan.next();
		year = scan.nextInt();
		String token = null;
		while (true) {
			token = scan.next();
			if (token.contentEquals("0"))
				break;
			authors.add(token);
		}
		price = scan.nextInt();
	}

	// 자료구조 (생능출판/1001/2003년) [15000원] 저자:천인국 공용해 하상호
	@Override
	public void print() {
		System.out.format("%s (%s/%s/%d년) [%d원] 저자:",
				title, pub, isbn, year, price);
		for (String a : authors)
			System.out.print(a + " ");
		System.out.println();
	}

	@Override
	public boolean matches(String kwd) {
		if (title.contains(kwd))
			return true;
		if (isbn.equals(kwd))
			return true;
		return false;
	}
}
