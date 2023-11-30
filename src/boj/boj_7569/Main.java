package boj.boj_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int height;
        int row;
        int col;


        Point(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, M, N, H, normalTomatoCount;
    static int[][][] tomatoField;

    static Queue<Point> queue = new LinkedList<>();
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public void solution
            () throws Exception {
        Scanner sc = new Scanner(System.in);

        answer = 0;
        normalTomatoCount = 0;

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tomatoField = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int tomato = sc.nextInt();

                    if (tomato == 0) normalTomatoCount += 1;
                    if (tomato == 1) queue.add(new Point(h, r, c));

                    tomatoField[h][r][c] = tomato;
                }
            }
        }


        while (normalTomatoCount > 0 && !queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Point point = queue.poll();

                int h = point.height;
                int r = point.row;
                int c = point.col;

                for (int j = 0; j < 6; j++) {
                    int nh = h + dh[j];
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (nr < 0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H || tomatoField[nh][nr][nc] != 0)
                        continue;

                    normalTomatoCount -= 1;
                    tomatoField[nh][nr][nc] = 1;

                    queue.offer(new Point(nh, nr, nc));
                }
            }
            answer += 1;
        }

        System.out.println(normalTomatoCount == 0 ? answer : -1);

    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
