import java.util.Scanner;

public class FoodPlus extends Food {
    int weight;
    String subUnit;

    FoodPlus(String type) {
        super(type);
    }

    @Override
    void read(Scanner scan) {
        super.read(scan);
        weight = scan.nextInt();
        subUnit = scan.next();
    }

    @Override
    public String toString() {
        return String.format("[%2d] %s-%s (%dkcal/%s) %d%s", id, type, name, cal, unit, weight, subUnit);
    }

    @Override
    int getKcal(int s, String u) {
        if (u.equals(subUnit) == false)
            return super.getKcal(s, u);

        return cal * s / weight;
    }

    @Override
    String getDetail(int n, String unit) {
        if (unit.equals(subUnit) == false)
            return super.getDetail(n, unit);

        return String.format("%dkcal/%d%s -> %dkcal*%d/%d%s=%dkcal", cal, 1, this.unit, cal, n, weight, subUnit,
                getKcal(n, unit));
    }
}
