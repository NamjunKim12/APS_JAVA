package swea.swea_1486;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, N, B, S;
    static int[] H;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1486/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            B = sc.nextInt();
            H = new int[N];
            visited = new boolean[N];
            S = Integer.MAX_VALUE;


            for (int i = 0; i < N; i++) {
                H[i] = sc.nextInt();
            }

            powerset(0);

            System.out.println("#" + test_case + " " + (S - B));
        }
    }

    public static void powerset(int idx) {
        if (idx == N) {
            int sum = array_sum(H);
            if (sum < S && sum >= B) {
                S = sum;
            }
            return;
        }

        // 재귀 파트
        visited[idx] = true;
        powerset(idx + 1);

        visited[idx] = false;
        powerset(idx + 1);
    }

    public static int array_sum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                sum += arr[i];
            }
        }

        return sum;
    }
}
