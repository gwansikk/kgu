abstract class Calculator {
    public abstract int add(int a, int b); 
    public abstract int subtract(int a, int b); 
    public abstract double average(int[] a);
}

class GoodCale extends Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double average(int[] a) {
        double sum = 0;

        for(int index : a) {
            sum += index;
        }

        return sum / a.length;
    }
    
    public static void main(String[] args) {
        GoodCale g = new GoodCale();

        System.out.println( g.add(1, 1));
        System.out.println( g.subtract(1, 1));
        System.out.println( g.average( new int[] {1,2,3}));
    }
}

