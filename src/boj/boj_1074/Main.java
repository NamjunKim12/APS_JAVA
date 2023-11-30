package boj.boj_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, N, r, c, size;

    public void solution
            () throws Exception {
        answer = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        answer = searchResult(0, 0, size);

        System.out.println(answer);
    }

    public static int searchResult(int newRow, int newCol, int size) {
        // 기저조건 - 더이상 반으로 쪼갤 수 없다면 리턴;
        if (size == 1) return 0;

        // 2사분면
        if (r < newRow + size / 2 && c < newCol + size / 2)
            return searchResult(newRow, newCol, size / 2);

        // 1사분면
        else if (r < newRow + size / 2 && c < newCol + size)
            return searchResult(newRow, newCol + size / 2, size / 2) + (int) Math.pow(size / 2, 2);

        // 3사분면
        else if (r < newRow + size && c < newCol + size / 2)
            return searchResult(newRow + size / 2, newCol, size / 2) + (int) Math.pow(size / 2, 2) * 2;

        // 4사분면
        else
            return searchResult(newRow + size / 2, newCol + size / 2, size / 2) + (int) Math.pow(size / 2, 2) * 3;
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
