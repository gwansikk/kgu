package 비교과.자바자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {
    static int getAnswer(int[] list, int n, int v, int k) {
        if (k < n)
            return list[k];
        else
            return list[(k - (v - 1)) % (n - (v - 1)) + v - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        list[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++)
            list[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(getAnswer(list, N, V, k) + "\n");
        }

        System.out.println(sb);
    }
}