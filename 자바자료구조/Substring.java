import java.util.*;

public class Substring {
	static HashSet<String> set;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		set = new HashSet<String>();
		
		String name = "";
		
		for(int i=0;i<s.length();i++) {
			name ="";
			
			//i부터 끝까지 반복을 하여 Hash set에 넣는데 중복이 있으면 안넣겠죠?
			for(int j=i;j<s.length();j++){
				name+=s.substring(j,j+1);
				set.add(name);
			}
		}
		
		System.out.println(set.size());
		sc.close();
	}
}