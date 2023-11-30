package boj.boj_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static long N, start, mid, end, sum;
    static int[] lan_cables;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan_cables = new int[K];
        start = 1;
        end = -1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lan_cables[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            end = Math.max(lan_cables[i], end);
        }

        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for (long num : lan_cables) {
                if (num >= mid)
                    sum += num / mid;

            }

            if (sum < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.print(end);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
