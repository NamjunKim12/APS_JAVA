package swea.swea_2817;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, N, K, answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_2817/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;
            N = sc.nextInt();
            K = sc.nextInt();
            int[] arr = new int[N];
            boolean[] visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            powerset(arr, visited, N, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void powerset(int[] arr, boolean[] visited, int n, int idx) {
        // 기저 파트
        if (idx == n) {
            getSum(arr, visited, n);
            return;
        }

        // 재귀 파트
        visited[idx] = false;
        powerset(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerset(arr, visited, n, idx + 1);

    }

    static void getSum(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                sum += arr[i];
        }
        if (sum == K) {
            answer++;
        }
    }
}
