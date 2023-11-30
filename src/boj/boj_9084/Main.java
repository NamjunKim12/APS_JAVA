package boj.boj_9084;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    static int answer, T, N, M;
    static int[] coins, dp;

    public void solution
            () throws Exception {
        answer = 0;

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                coins[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for (int coin : coins)
                for (int j = coin; j <= M; j++) dp[j] += dp[j - coin];

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
