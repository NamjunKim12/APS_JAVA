package boj.boj_14940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    private final static int[] dr = {0, 0, -1, 1};
    private final static int[] dc = {-1, 1, 0, 0};

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    map[i][j] = 0;

                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    map[i][j] = -1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void bfs(int row, int col) {
        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = point[0] + dr[i];
                int nc = point[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                queue.add(new int[]{nr, nc});
                map[nr][nc] = map[point[0]][point[1]] + 1;
                visited[nr][nc] = true;
            }
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
