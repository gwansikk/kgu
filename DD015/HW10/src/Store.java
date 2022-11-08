
import java.util.Comparator;
import java.util.Scanner;

public class Store {
	Scanner scan = new Scanner(System.in);

	static Manager<Item> itemMgr = new Manager<>();
	static Manager<User> userMgr = new Manager<>();
	static Manager<Order> orderMgr = new Manager<>();
	static User loginUser = null; // 로그인

	void run() {
		itemMgr.readAll("src/input/items.txt", Item::new);
		userMgr.readAll("src/input/user.txt", User::new);
		orderMgr.readAll("src/input/order.txt", Order::new);

		login();
		menu();
	}

	private void login() {
		System.out.println("----- 로그인 -----");
		System.out.print("[ID] ");
		String loginID = scan.next();

		System.out.print("[PW] ");
		String loginPWD = scan.next();

		for (User user : userMgr.mList) {
			if (user.login(loginID, loginPWD)) {
				loginUser = user; // 로그인
				System.out.println(loginUser.userId + "님 환영합니다.");
			}
		}
	}

	void menu() {
		int num;

		while (true) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (기타) 종료 ");
			num = scan.nextInt();

			if (num < 1 || num > 4)
				break;

			switch (num) {
				case 1:
					itemOrderPrint();
					break;
				case 2:
					userMgr.printAll();
					break;
				case 3:
					orderMgr.printAll();
					break;
				case 4:
					searchMenu();
					break;
				default:
					break;
			}
		}
	}

	private void itemOrderPrint() {
		int num;

		while (true) {
			System.out.print("(1)이름순 (2)코드순 (3)가격순 (기타) 종료 ");
			num = scan.nextInt();

			if (num < 1 || num > 3)
				break;

			switch (num) {
				case 1: // 이름
					itemMgr.mList.sort(new Comparator<Item>() {
						@Override
						public int compare(Item o1, Item o2) {
							return (o1.name.compareTo(o2.name));
						}
					});
					break;

				case 2: // 코드
					itemMgr.mList.sort(new Comparator<Item>() {
						@Override
						public int compare(Item o1, Item o2) {
							return (o1.id.compareTo(o2.id));
						}
					});
					break;

				case 3: // 가격
					itemMgr.mList.sort(new Comparator<Item>() {
						@Override
						public int compare(Item o1, Item o2) {
							return (o1.getPrice() - o2.getPrice());
						}
					});
					break;
			}

			itemMgr.printAll();
		}

	}

	void searchMenu() {
		int num;
		while (true) {
			System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (기타) 종료 ");
			num = scan.nextInt();

			if (num < 1 || num > 3)
				break;

			switch (num) {
				case 1:
					itemMgr.search(scan);
					break;
				case 2:
					userMgr.search(scan);
					break;
				case 3:
					orderMgr.search(scan);
					break;
				default:
					break;
			}
		}
	}

	static Item findItem(String kwd) {
		return itemMgr.find(kwd);
	}

	static User findUser(String kwd) {
		return userMgr.find(kwd);
	}

	static Order findOrder(String kwd) {
		return orderMgr.find(kwd);
	}

	public static void main(String[] args) {
		Store m = new Store();
		m.run();
	}
}
