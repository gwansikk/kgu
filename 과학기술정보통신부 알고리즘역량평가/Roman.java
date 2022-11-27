import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Roman {
	static HashMap<String, Integer> map;
	static int ans1 = 0;
	static String ans2 = "";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str[] = in.readLine().split("");

		map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);

		for (int i = 0; i < str.length; i++) {
			char c = str[i].charAt(0);
			if ((c == 'I' || c == 'X' || c == 'C') && i < str.length - 1) {
				String s = str[i] + str[i + 1];
				if (map.containsKey(s)) {
					ans1 += map.get(s);
					i++;
					continue;
				}
			}

			ans1 += map.get(str[i]);
		}

		System.out.println(ans1);
	}
}