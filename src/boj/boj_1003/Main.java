package boj.boj_1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int[][] dp;

    public void solution() throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[41][2];

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 2; i <= N; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
