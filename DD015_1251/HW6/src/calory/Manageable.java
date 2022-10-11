package calory;

import java.util.Scanner;

interface Manageable {

    void read(Scanner scan, Manager main);

    int getKcal(int s, String u);

    String getName();
}
