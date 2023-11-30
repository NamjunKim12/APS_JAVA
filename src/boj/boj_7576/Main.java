package boj.boj_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, M, N, normalTomatoCount;
    static int[][] tomatoField;

    static Queue<Point> queue = new LinkedList<>();
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public void solution
            () throws Exception {
        answer = 0;
        normalTomatoCount = 0;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoField = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());

                if (tomato == 0) normalTomatoCount += 1;
                if (tomato == 1) queue.add(new Point(i, j));

                tomatoField[i][j] = tomato;
            }
        }

        while (normalTomatoCount > 0 && !queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Point point = queue.poll();

                int r = point.row;
                int c = point.col;

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || tomatoField[nr][nc] != 0) continue;

                    normalTomatoCount -= 1;
                    tomatoField[nr][nc] = 1;

                    queue.add(new Point(nr, nc));
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
