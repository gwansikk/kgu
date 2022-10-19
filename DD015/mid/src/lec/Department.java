package lec;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Subject> subList = new ArrayList<>();

	void run() {
		readAllSubjects();
		printAllSubjects();
		readAll();
		printAll();
		search();
	}

	void printAllSubjects() {
		// TODO Auto-generated method stub
		for (Subject s : subList)
			s.print();
	}

	void readAllSubjects() {
		// TODO Auto-generated method stub
		String token = null;
		Subject s = null;
		while (true) {
			token = scan.next();
			if (token.equals("end"))
				break;
			s = new Subject(token);
			s.read(scan);
			subList.add(s);
		}

	}

	void search() {
		// String kwd = null;
		String line = null;
		String[] kwdArr = null;
		scan.nextLine();
		while (true) {
			System.out.print("검색키워드 여러개(빈칸으로 구분):");
			line = scan.nextLine();
			if (line.contentEquals("end"))
				break;
			kwdArr = line.split(" ");
			for (Student st : studentList) {
				if (st.matches(kwdArr))
					st.print();
			}
		}
	}

	void readAll() {
		Student st = null;
		int id = 0;
		while (true) {
			id = scan.nextInt();
			if (id == 0)
				break;
			st = new Student(id);
			st.read(scan, this);
			studentList.add(st);
			st.print();
		}
	}

	void printAll() {
		int i = 1;
		for (Student st : studentList) {
			System.out.printf("[%d] ", i++);
			st.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.run();
	}

	Subject findSubject(String token) {
		// TODO Auto-generated method stub
		for (Subject s : subList)
			if (s.matches(token))
				return s;
		return null;
	}

}
