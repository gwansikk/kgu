import java.util.*;

public class ArrayListEx{
    public static void main(String args[]) {
        ArrayList<String> a = new ArrayList<String>();

        a.add("abc");
        a.add("dfgg");
        a.add("ooepdss");

        for(int i = 0; i < a.size(); i++) {
            String name = a.get(i);
            System.out.println(name + " ");
        }

        int longestIndex = 0;

        for (int i = 1; i < a.size(); i++) {
            if(a.get(longestIndex).length() < a.get(i).length())
                longestIndex = i;
        }

        System.out.println("가장 긴 이름: " + a.get(longestIndex));
    }

}