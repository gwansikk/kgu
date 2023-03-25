package 비교과.자바자료구조;

import java.util.*;

public class Card {
    static int list[], arr[];
    static int N = 0, K = 0;
    static boolean visit[];
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[K];
        list = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
        sc.close();
        dfs(0);

        System.out.println(set.size());
    }

    private static void dfs(int depth) {
        if (depth == K) {
            String sum = "";
            for (int i = 0; i < arr.length; i += 1) {
                sum += arr[i];
            }

            set.add(Integer.parseInt(sum));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = list[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
