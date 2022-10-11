package polynomial;

import java.util.Scanner;

class Polynomial extends Manager implements Manageable, Factory {
	String name; // 다항식의 이름

	Polynomial() {
	}

	// 입력에서 다항식의 이름과 계수, 지수를 받아 이름 저장 f및 항을 하나 생성
	// 입력: f 3 4
	@Override
	public void read(Scanner scan) {
		name = scan.next();
		readNAdd(this);
	}

	// 이 다항식을 f = 3 x ^ 4 + 2 x + 6 형태로 출력
	@Override
	public void print() {
		printAll();
		System.out.println("");
	}

	@Override
	public boolean matches(String kwd) {
		return name.equals(kwd);
	}

	// x의 값을 받아 다항식을 계산한 결과를 반환
	@Override
	public int calc(int x) {
		int sum = 0;

		for (Manageable manageable : mList) {
			sum += manageable.calc(x);
		}

		System.out.printf("f(%d) = %d\n", x, sum);
		return sum;
	}

	// 항을 받아 추가하는 함수 (Manager의 메소드 오버라이드)
	@Override
	public void add(Manageable m) {
		Manageable result = findTerm(m);

		// 기존에 있으면 기존 객체에 추가
		if (result != null) {
			((Term) result).addTerm((Term) m);
			return;
		}

		mList.add(m);
	}

	private Manageable findTerm(Manageable m) {
		for (Manageable manageable : mList) {
			Term term = (Term) manageable;

			if (manageable.matches(Integer.toString(term.expo))) {
				return manageable;
			}
		}

		return null;
	}

	@Override
	public Manageable create() {
		return new Term();
	}
}