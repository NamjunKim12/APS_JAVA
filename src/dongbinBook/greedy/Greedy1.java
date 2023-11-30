package dongbinBook.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 큰 수의 법칙
public class Greedy1 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer;
    static int N, M, K;

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        // 배열의 크기
        N = Integer.parseInt(st.nextToken());
        // 숫자가 더해지는 횟수
        M = Integer.parseInt(st.nextToken());
        // 연속해서 더해질 수 있는 횟수
        K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        Integer[] nums = new Integer[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        int max = nums[0];
        int secondMax = nums[1];

        // M과 K 가 같을 경우 최댓값에 K를 곱하여 출력 후 리턴
        if(M == K){
            System.out.println(max * K);
            return;
        }

        answer = max;

        for(int i = 1; i < M; i++){
            if(i % K == 0) {
                answer += secondMax;
                continue;
            }
            answer += max;
        }

        // 출력부
        System.out.println(answer);
    }

    public static void main
            (String[] args) throws Exception {
        new Greedy1().solution();
    }
}


