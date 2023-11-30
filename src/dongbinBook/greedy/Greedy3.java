package dongbinBook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy3 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int N, K, answer;

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = 0;

        int tmp = N;

        while(tmp > 1){
            if(tmp % K == 0) tmp /= K;
            else if(tmp % K != 0) tmp -= 1;

            answer += 1;
        }

        System.out.println(answer);
    }

    public static void main
            (String[] args) throws Exception {
        new Greedy3().solution();
    }
}
