
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Manageable {
	// lee lll 0
	String userId;
	String pwd;
	int point;
	ArrayList<Order> myOrderList = new ArrayList<>();

	@Override
	public void read(Scanner scan) {
		userId = scan.next();
		pwd = scan.next();
		point = scan.nextInt();
	}

	/*
	 * [lee] (10점)
	 * [주문아이디: 1] 20201010 사용자: le 문금액: 3420 인 3점)
	 * [주문아이디: 7] 20201011 사용자: le 주문금액: 7380 인트: 7점)
	 */

	void addOrder(Order order) {
		myOrderList.add(order);
		point += order.point;
	}

	@Override
	public void print() {
		System.out.printf("[%s] (%d¡°)\n", userId, point);
		for (Order od : myOrderList)
			od.print(false);
	}

	@Override
	public boolean matches(String kwd) {
		if (userId.equals(kwd))
			return true;
		for (Order od : myOrderList)
			if (od.matches(kwd))
				return true;
		return false;
	}
}
