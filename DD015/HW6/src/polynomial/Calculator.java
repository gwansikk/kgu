package polynomial;

/*
	=== 사용법 ===
	create f 3 4 	: f = 3 x ^ 4 다항식 생성
	add f 2 1		: f에 2 x 항을 생성, f = 3 x ^ 4 + 2 x
	calc f 3		: f(3) = 249 을 계산해서 결과 출력 
	add f 6 0		: f = 3 x ^ 4 + 2 x + 6
	print f		: f(x) = 3 x ^ 4 + 2 x + 6 + 0출력
	exit		: 종료
*/
class Calculator extends Manager implements Factory {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.run();
	}

	// 이름 한글자 읽어서 다항식 찾아 리턴, 없으면 null
	public void run() {
		Manageable p = null;

		while (true) {
			System.out.print("$ ");
			String command = sc.next();

			if (command.equals("exit")) // 종료
				break;
			// 항의 생성
			if (command.equals("create")) {
				readNAdd(this);
				continue;
			}

			p = find(sc.next()); // 그 이외의 경우는 이름을 입력받음
			if (p == null) { // 이름의 다항식이 없으면 오류
				sc.nextLine(); // 이름 오류이므로 뒤 부분 읽어 버림
				continue;
			}

			switch (command) {
				case "add": // 다항식에 새로운 항 (c x ^ e)를 더함
					Polynomial poly = (Polynomial) p;
					poly.readNAdd(poly);
					break;
				case "calc": // 입력한 수로 f(x)를 계산
					int n = sc.nextInt();
					p.calc(n);
					break;
				case "print": // 다항식 출력.
					p.print();
				default:
					sc.nextLine();
					break;
			}
		}
	}

	@Override
	public Manageable create() {
		return new Polynomial();
	}
}
