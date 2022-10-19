package polynomial;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator {
    ArrayList<Polynomial> polynomials = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Polynomial find(Scanner sc) {
        Character key = sc.next().charAt(0);

        for (Polynomial polynomial : polynomials) {
            if (polynomial.name.equals(key)) {
                return polynomial;
            }
        }

        return null;
    }

    void run() {
        Polynomial p = null;

        while (true) {
            System.out.print("$ ");
            String command = sc.next();

            if (command.equals("exit"))
                break;

            if (command.equals("create")) {
                p = new Polynomial();
                p.read(sc);
                polynomials.add(p);
                continue;
            }

            p = find(sc);

            if (p == null) {
                sc.nextLine();
                continue;
            }

            switch (command) {
                case "add":
                    p.add(sc);
                    break;
                case "calc":
                    int n = sc.nextInt();
                    p.calc(n);
                    break;
                case "print":
                    p.print();
                    break;
                default:
                    sc.nextLine();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.run();
    }
}

class Polynomial {
    ArrayList<Term> terms = new ArrayList<>();
    Character name;

    Polynomial() {
        terms.add(new Term(0, 0));
    }

    void read(Scanner scan) {
        name = scan.next().charAt(0);
        add(scan);
    }

    public boolean compare(String name2) {
        return name.equals(name2.charAt(0));
    }

    void print() {

        for (int i = 0; i < terms.size(); i++) {
            terms.get(i).print();

            if (i != terms.size() - 1)
                System.out.print(" + ");

        }

        System.out.println("");
    }

    int calc(int x) {
        int result = 0;

        for (Term term : terms)
            result += (int) Math.pow(term.coef * x, term.expo);

        System.out.printf("f(%d) = %d\n", x, result);

        return result;
    }

    void add(Scanner scan) {
        int c = scan.nextInt();
        int e = scan.nextInt();

        addTerm(c, e);
    }

    private void addTerm(int c, int e) {
        Term t = findTerm(e);

        if (t != null) {
            t.add(c);
            return;
        }

        t = new Term(c, e);

        for (int i = 0; i < terms.size(); i++) {
            if (terms.get(i).compare(t.expo) < 0) {
                terms.add(i, t);
                return;
            }
        }
    }

    private Term findTerm(int e) {
        for (Term term : terms) {
            if (term.equals(e))
                return term;
        }

        return null;
    }

    class Term {
        public int coef;
        public int expo;

        Term(int c, int e) {
            coef = c; // 밑
            expo = e; // 지수
        }

        void read(Scanner scan) {
            coef = scan.nextInt();
            expo = scan.nextInt();
        }

        void print() {
            if (expo == 0)
                System.out.printf("%d", coef);
            else
                System.out.printf("%dx ^ %d", coef, expo);
        }

        int calc(int x) {
            return (int) Math.pow(coef * x, expo);
        }

        boolean equals(int e) {
            return (expo == e);
        }

        int compare(int e) {
            if (equals(e))
                return 0;

            return (expo > e) ? 1 : -1;
        }

        void add(int c) {
            coef += c;
        }
    }

}