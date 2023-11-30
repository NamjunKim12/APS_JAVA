package swea.swea_10726;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_10726/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 런타임에러 (시간초과 발생)
//            String binary = Integer.toBinaryString(M);
//            int len = binary.length();
//            boolean flag = true;
//            for (int i = len - 1; i >= len - N; i--) {
//                if (binary.charAt(i) == '0') {
//                    flag = false;
//                    break;
//                }
//            }

            //비트 연산자를 활용한 풀이
            boolean flag = true;
            int mask = (1 << N) - 1;
            if ((M & mask) == mask) {
                flag = true;
            } else {
                flag = false;
            }


            if (flag) {
                System.out.println("#" + test_case + " ON");
            } else {
                System.out.println("#" + test_case + " OFF");
            }
        }
    }
}
