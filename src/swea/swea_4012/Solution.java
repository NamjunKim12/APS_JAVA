package swea.swea_4012;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, N, r, answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_4012/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            r = N / 2;
            map = new int[N][N];
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            combination(0, r);

            System.out.println("#" + test_case + " " + answer);

        }
    }

    static int getMinValue() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (visited[i] && visited[j]) {
                    x += map[i][j];
                }
                if (!visited[i] && !visited[j]) {
                    y += map[i][j];
                }
            }
        }
        return Math.abs(x - y);
    }

    static void combination(int idx, int cnt) {
        if (cnt == 0) {
            answer = Math.min(answer, getMinValue());
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            combination(i + 1, cnt - 1);
            visited[i] = false;
        }
    }

}
