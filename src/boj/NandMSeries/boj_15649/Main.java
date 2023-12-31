package boj.NandMSeries.boj_15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// N과 M 1 (순열)
public class Main {
    static int N, M;
    static int[] answer;
    static boolean[] visit;

    static BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        visit = new boolean[N + 1];
        permutation(0);

        bw.flush();
        bw.close();
    }

    private static void permutation(int depth) throws IOException {
        if (depth == M) {
            for (int num : answer) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;

            answer[depth] = i;
            visit[i] = true;
            permutation(depth + 1);
            visit[i] = false;
        }

    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
