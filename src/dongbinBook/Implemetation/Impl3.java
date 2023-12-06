package dongbinBook.Implemetation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Impl3 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int startRow, startCol;
    static int answer;
    String[] cols = {"a","b","c","d","e","f","g","h"};
    static int[] dr = {1, -1, 1, -1, 2, 2, -2, -2};
    static int[] dc = {2, 2, -2, -2, -1, 1, -1, 1};

    public void solution() throws Exception {
        answer = 0;

        String[] inputs = br.readLine().split("");

        startRow = Integer.parseInt(inputs[1]) - 1;
        startCol = Arrays.asList(cols).indexOf("a");

        for (int i = 0; i < 8; i++) {
            int newRow = startRow + dr[i];
            int newCol = startCol + dc[i];

            if(newRow < 8 && newCol < 8 && newRow >= 0 && newCol >= 0)
                answer += 1;
        }

        System.out.println(answer);
    }

    public static void main
            (String[] args) throws Exception {
        new Impl3().solution();
    }
}
