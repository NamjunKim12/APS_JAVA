package algorithm;

public class Combination {
    static int[] arr;
    static int n, r;
    static boolean visited[];

    public static void main(String[] args) {
        arr = new int[5];
        visited = new boolean[5];
        n = arr.length;
        r = 3;

        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
        }

        for (int r = 1; r <= arr.length; r++) {
            System.out.println("\n" + arr.length + "개 중 " + r + "개 고르는 조합");
            combination(arr, visited, 0, r);
        }
    }

    static public void combination(int[] arr, boolean[] visited, int depth, int r){
        // r은 뽑는 갯수
        if (depth == arr.length || r == 0) {
            if (r == 0) {
                print(arr, visited);
            }
            return;
        }

        // 자기 자신을 뽑는 경우 + 자기 자신을 뽑지 않는 경우를 나누어 재귀
        visited[depth] = true;
        combination(arr, visited, depth + 1, r - 1);
        visited[depth] = false;
        combination(arr, visited, depth + 1, r);
    }

    static void print(int[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
