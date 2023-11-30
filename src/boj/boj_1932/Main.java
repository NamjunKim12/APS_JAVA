package boj.boj_1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, currentAcc, answer;
    static int[][] arr, dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dp = new int[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        for (int i = (N - 2); i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                currentAcc = arr[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                dp[i][j] = currentAcc;
            }
        }

        answer = dp[0][0];

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
