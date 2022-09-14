package CH10;

/**
 * Plane
 */
public class Plane {
    private String maker;
    private String model;
    private int max;
    private static int planes = 0;

    public Plane() {
        this("ERROR", "ERROR", -1);
    }

    public Plane(String maker, String model, int max) {
        this.maker = maker;
        this.model = model;
        this.max = max;
        planes++;
    }

    public String PrintPlaneNum() {
        return "비행기 개수 : " + planes + " 개";
    }

    @Override
    public String toString() {
        return "비행기 모델 : " + model + ", 승객수: " + max + ", 제조사: " + maker;
    }

    void mymain() {
        Plane p1 = new Plane();
        Plane p2 = new Plane("Korea", "Boeing 800", 900);
        Plane p3 = new Plane("airbus", "A380", 500);
        Plane p4 = new Plane("김관식", "종이비행기", 0);

        System.out.println(p4.PrintPlaneNum());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }

    public static void main(String[] args) {
        Plane my = new Plane();
        my.mymain();
    }
}