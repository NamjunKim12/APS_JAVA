package dongbinBook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, M, answer;

    public void solution() throws Exception {
        answer = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            int min = 10001;
            for(int j = 0; j < N; j++){
                min = Math.min(min, arr[i][j]);
            }
            answer = Math.max(answer, min);
        }

        System.out.println(answer);
    }

    public static void main
            (String[] args) throws Exception {
        new Greedy2().solution();
    }
}
