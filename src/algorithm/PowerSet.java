package algorithm;

import java.util.Scanner;

public class PowerSet {
    public static int[] arr;
    public static int N;
    public static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = i + 1;

        visited = new boolean[N];

        powerset(N, 0);
    }

    public static void powerset(int n, int depth) {
        // 기저 파트
        if (depth == n) {
            print(arr, visited, n);
            return;
        }

        // 재귀 파트
        visited[depth] = false;
        powerset(n, depth + 1);

        visited[depth] = true;
        powerset(n, depth + 1);

    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
