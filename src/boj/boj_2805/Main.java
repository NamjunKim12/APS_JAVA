package boj.boj_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 나무의 수, 집으로 가져가려는 나무의 길이
    static long sum, start, end, mid;
    static long[] trees;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new long[N];
        start = 1;
        end = -1;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            end = Math.max(end, trees[i]);
        }

        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for (long tree : trees) {
                if (tree >= mid) sum += tree - mid;
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.print(end);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
