package boj.boj_14916;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer, change;

    public void solution() throws Exception {
        answer = 0;
        change = Integer.parseInt(br.readLine());

        while (change > 0) {
            if (change % 5 == 0) {
                answer += change / 5;
                System.out.print(answer);
                return;
            }

            change -= 2;
            answer += 1;

            if (change == 0) {
                System.out.print(answer);
                return;
            }
        }

        System.out.print(-1);
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
