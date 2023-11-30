package swea.swea_6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임

public class Solution {
    static int T, gyu_win, in_win, idx;
    static int[] cards_gyuyoung, cards_inyeong, result;
    static boolean[] check, visited;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_6808/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            cards_gyuyoung = new int[9];
            cards_inyeong = new int[9];
            result = new int[9];
            check = new boolean[19];
            visited = new boolean[9];
            gyu_win = 0;
            in_win = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                cards_gyuyoung[i] = Integer.parseInt(st.nextToken());
                check[cards_gyuyoung[i]] = true;
            }

            idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    cards_inyeong[idx++] = i;
                }
            }

            permutation(0);

            System.out.println("#" + test_case + " " + gyu_win + " " + in_win);
        }
    }

    static void permutation(int depth) {
        if (depth == 9) {
            int in_score = 0, gyu_score = 0;

            for (int i = 0; i < 9; i++) {
                int score = cards_gyuyoung[i] + result[i];
                if (cards_gyuyoung[i] > result[i]) gyu_score += score;
                if (cards_gyuyoung[i] < result[i]) in_score += score;
            }

            if (gyu_score > in_score) gyu_win += 1;
            if (gyu_score < in_score) in_win += 1;

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[depth] = cards_inyeong[i];
            permutation(depth + 1);
            visited[i] = false;

        }
    }
}
