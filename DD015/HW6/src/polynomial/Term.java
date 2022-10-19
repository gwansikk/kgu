package polynomial;

import java.util.Scanner;

class Term implements Manageable {
	public int coef;
	public int expo;

	Term() {
	}

	Term(int c, int e) {
		coef = c;
		expo = e;
	}

	@Override
	public void read(Scanner scan) {
		coef = scan.nextInt();
		expo = scan.nextInt();
	}

	// 항을 c x ^ e 형태로 출력
	@Override
	public void print() {
		if (expo == 0) {
			System.out.print(coef);
			return;
		}

		System.out.format("%d x ^ %d + ", coef, expo);
	}

	@Override
	public boolean matches(String kwd) {
		return Integer.parseInt(kwd) == expo;
	}

	// x의 값을 받아 항을 계산한 결과를 반환
	@Override
	public int calc(int x) {
		return coef * (int) (Math.pow(x, expo));
	}

	// 지수를 비교하여 exponent가 더 크면 1, 같으면 0, 작으면 -1 반환
	int compare(int e) {
		return expo - e;
	}

	// 지수가 같은 항의 계수를 받아 coeff에 더한다
	void addTerm(Term t) {
		coef += t.coef;
	}
}