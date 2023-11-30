package boj.boj_5585;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer, change;

    public void solution() throws Exception {
        answer = 0;
        change = 1000 - Integer.parseInt(br.readLine());

        while (change >= 500) {
            change -= 500;
            answer += 1;
        }

        while (change >= 100) {
            change -= 100;
            answer += 1;
        }

        while (change >= 50) {
            change -= 50;
            answer += 1;
        }

        while (change >= 10) {
            change -= 10;
            answer += 1;
        }

        while (change >= 5) {
            change -= 5;
            answer += 1;
        }

        answer += change;

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
