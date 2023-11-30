package algorithm;

public class Permutation {
    static int[] arr = new int[3];
    static boolean[] visited = new boolean[6];
    static int M = 2;
    static int[] answer = new int[M];

    public static void main(String[] args) {
        permutation(0);
    }

    static public void permutation(int depth) {
        if (depth == M) {
            printArray(answer);
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            if (visited[i]) continue;

            answer[depth] = i;
            visited[i] = true;
            permutation(depth + 1);
            visited[i] = false;
        }
    }

    private static void printArray(int[] a) {
        for (int num : a)
            System.out.print(num + " ");
        System.out.println();
    }


}
