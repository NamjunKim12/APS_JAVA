package boj.boj_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, answer;

    public void solution() throws Exception {
        answer = 0;
        N = Integer.parseInt(br.readLine());
        answer = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                System.out.println(answer);
                return;
            }

            N -= 3;
            answer += 1;

            if (N == 0) {
                System.out.println(answer);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
