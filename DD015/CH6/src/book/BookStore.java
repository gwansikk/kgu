package book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();

	void run() {
		readAllBooks();
		printAllBooks();
		search();
	}

	private void printAllBooks() {
		// TODO Auto-generated method stub
		for (Book b : bookList)
			b.print();
	}

	void readAllBooks() {
		int n = 0;
		Book b = null;
		while (true) {
			n = scan.nextInt();
			if (n == 0)
				break;
			switch (n) {
				case 1:
					b = new Book();
					break;
				case 2:
					b = new EBook();
					break;
				case 3:
					b = new ABook();
					break;
				default:
					break;
			}
			b.read(scan);
			bookList.add(b);
		}
	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			for (Book b : bookList)
				if (b.matches(kwd))
					b.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore store = new BookStore();
		store.run();
	}

}
