package swea.swea_1217;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int N, M, T;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1217/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            System.out.println("#" + test_case + " " + recursion(N, M));
        }
    }

    public static int recursion(int n, int m) {
        if (m == 0) {
            return 1;
        }

        return n * recursion(n, m - 1);
    }
}
