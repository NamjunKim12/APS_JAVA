package dongbinBook.Implemetation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Impl2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer;

    public void solution
            () throws Exception {
        answer = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <= 59; k++) {
                    if(i == 3) {
                        answer++;
                        continue;
                    }
                    if(Integer.toString(j).contains("3")){
                        answer++;
                        continue;
                    }
                    if(Integer.toString(k).contains("3")){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);

    }

    public static void main
            (String[] args) throws Exception {
        new Impl2().solution();
    }
}
