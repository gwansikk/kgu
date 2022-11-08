import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();

	public void readAll(String filename, Factory<T> fac) {
		Scanner file = openFile(filename);

		while (file.hasNext()) {
			T t = fac.create();
			t.read(file);
			mList.add(t);
		}
		file.close();
	}

	public void printAll() {
		for (Manageable m : mList) {
			m.print();
		}
	}

	public T find(String kwd) {
		for (T m : mList)
			if (m.matches(kwd))
				return m;
		return null;
	}

	public List<Manageable> findAll(String kwd) {
		List<Manageable> results = new ArrayList<>();
		for (Manageable m : mList)
			if (m.matches(kwd))
				results.add(m);
		return results;
	}

	public void search(Scanner keyScanner) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = keyScanner.next();
			if (kwd.equals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	public Scanner openFile(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return file;
	}
}
