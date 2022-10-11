package calory;

public class Dine extends Manager implements Factory {

	public static void main(String[] args) {
		Dine main = new Dine();
		main.run();
	}

	void run() {
		readFoods(this);
		readEats(this);
	}

	@Override
	public Manageable create() {
		return new Food(null);
	}
}