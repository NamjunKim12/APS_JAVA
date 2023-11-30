package boj.boj_18110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer, n;
    static int[] arr;

    public void solution
            () throws Exception {
        n = Integer.parseInt(br.readLine());
        answer = 0;
        arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int outLierCount = (int) Math.round(n * 0.15);

        for (int i = outLierCount; i < n - outLierCount; i++) sum += arr[i];

        answer = Math.round((float) sum / (n - (outLierCount * 2)));
        System.out.println(answer);
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
