package dongbinBook.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSBFS1 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, N, M;

    static int[][] map;
    static boolean[][] visited;

    public void solution() throws Exception {
        answer = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                if (dfs(i, j)) answer += 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean dfs(int row, int col) {
        if (row <= -1 || row >= N || col <= -1 || col >= M)
            return false;

        if (!visited[row][col] && map[row][col] == 0) {
            visited[row][col] = true;

            dfs(row - 1, col);
            dfs(row + 1, col);
            dfs(row, col - 1);
            dfs(row, col + 1);
            return true;
        }

        return false;
    }

    public static void main
            (String[] args) throws Exception {
        new DFSBFS1().solution();
    }
}
