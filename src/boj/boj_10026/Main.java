package boj.boj_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 적록색약

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, N;
    static boolean[][] visited;
    static char[][] colorBlock, colorBlockForBlind;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public void solution
            () throws Exception {

        ///////////// 입력부

        N = Integer.parseInt(br.readLine());
        colorBlock = new char[N][N];
        colorBlockForBlind = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char color = str.charAt(j);
                colorBlock[i][j] = color;
                colorBlockForBlind[i][j] = color;
                if (color == 'G') colorBlockForBlind[i][j] = 'R';
            }
        }
        //////////구현부

        getAnswer(colorBlock);
        getAnswer(colorBlockForBlind);
    }

    public static void getAnswer(char map[][]) {
        visited = new boolean[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    SearchBlockForEachColor(map, i, j);
                    answer += 1;
                }
            }
        }
        System.out.printf(answer + " ");
    }

    public static void SearchBlockForEachColor(char[][] colorMap, int row, int col) {

        visited[row][col] = true;
        char color = colorMap[row][col];

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nc < 0 || N <= nr || N <= nc || colorMap[nr][nc] != color || visited[nr][nc]) continue;
            if (!visited[nr][nc] && colorMap[nr][nc] == color) SearchBlockForEachColor(colorMap, nr, nc);
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
