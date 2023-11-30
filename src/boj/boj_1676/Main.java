package boj.boj_1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, N;

    public void solution
            () throws Exception {
        answer = 0;
        N = Integer.parseInt(br.readLine());

        while (N >= 5) {
            answer += N / 5;
            N /= 5;
        }


        System.out.println(answer);

    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }

}
