package boj.boj_1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, arrival, N;
    static boolean[] isBrokenButton;


    public void solution
            () throws Exception {
        answer = Integer.MAX_VALUE;

        arrival = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        if (arrival == 100) {
            System.out.println(0);
            return;
        }

        isBrokenButton = new boolean[10];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) isBrokenButton[Integer.parseInt(st.nextToken())] = true;
        }

        answer = Math.abs(100 - arrival);

        BruteForceSearch(0, "");
        System.out.println(answer);
    }

    public static void BruteForceSearch(int digit, String str) {
        for (int i = 0; i < 10; i++) {
            if (!isBrokenButton[i]) {
                String newStr = str + i;

                int pushCount = Math.abs(arrival - Integer.parseInt(newStr)) + newStr.length();
                answer = Math.min(pushCount, answer);

                if (digit < 6)
                    BruteForceSearch(digit + 1, newStr);
            }
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
