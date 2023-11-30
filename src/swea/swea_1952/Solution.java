package swea.swea_1952;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static class CostTable {
        int daily, monthly, quarter, annual;

        CostTable(int daily, int monthly, int quarter, int annual) {
            this.daily = daily;
            this.monthly = monthly;
            this.quarter = quarter;
            this.annual = annual;
        }
    }

    static int T, answer;
    static int[] count;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1952/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            CostTable cost = new CostTable(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

            count = new int[13];
            answer = 0;

            for (int i = 1; i < 13; i++) {
                count[i] = sc.nextInt();
                // 일일권 vs 월권 비교
                int temp = Math.min(count[i - 1] + (count[i] * cost.daily), count[i - 1] + cost.monthly);
                // 3달치 요금 vs (일일권 vs 월권 승자) 요금 비교
                count[i] = i >= 3 ? Math.min(temp, count[i - 3] + cost.quarter) : temp;
            }

            // DFS 돌릴시
            // 1월, 총합 0원까지 시작
            //
            // answer = cost.annual;
            // DFS(1, 0);

            // 연간권 vs 일+월+3월로 계산한 금액
            answer = count[12] > cost.annual ? cost.annual : count[12];

            System.out.printf("#%d %d%n", test_case, answer);
        }
    }

    // DFS 코드
//    private static void DFS(int depth, int cost) {
//        if (cost >= answer) return;
//
//        if (depth > 12) {
//            answer = Math.min(answer, cost);
//            return;
//        }
//
//        if (count[depth] == 0) {
//            DFS(depth + 1, cost);
//        }
//        if (count[depth] != 0) {
//            DFS(depth + 1, cost + 일간);
//            DFS(depth + 1, cost + 월간);
//            if (depth >= 3) DFS(depth + 1, cost + 월간);
//        }
//    }
}
