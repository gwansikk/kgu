import java.util.*;

public class HashMapDicEx {
    public static void main(String args[]) {
        HashMap<String, String> dic = new HashMap<String, String>();

        dic.put("A", "안녕");
        dic.put("B", "하세요");
        dic.put("C", "배고파요");

        String a = dic.get("A");
        String b = dic.get("K");

        if(a == null) {
            System.out.println("없는 단어");
        } else {
            System.out.println(a);
        }


        if(b == null) {
            System.out.println("없는 단어");
        } else {
            System.out.println(b);
        }
    }
}