package boj.boj_2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, maxHeight, answer;
    static int[][] safeZone;
    static boolean[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public void solution() throws Exception {
        answer = 0;
        N = Integer.parseInt(br.readLine());
        safeZone = new int[N][N];
        maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                safeZone[i][j] = input;
                if (input > maxHeight) maxHeight = input;
            }
        }

        for (int height = 0; height < maxHeight; height++) {
            visited = new boolean[N][N];
            int temp = 0;

            checkFloodedZone(safeZone, height);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (safeZone[i][j] == 0 || visited[i][j]) continue;

                    temp += 1;
                    checkSafeZone(i, j);
                }
            }

            answer = Math.max(temp, answer);
        }

        System.out.println(answer);
    }

    public static void checkFloodedZone(int[][] safeZone, int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (safeZone[i][j] <= height) {
                    safeZone[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
    }

    public static void checkSafeZone(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                if (!visited[newRow][newCol] && safeZone[newRow][newCol] != 0)
                    checkSafeZone(newRow, newCol);
            }
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
