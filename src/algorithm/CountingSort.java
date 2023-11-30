package algorithm;

public class CountingSort {
    static int[] arr = {9, 4, 7, 2, 6, 3, 5, 8, 1};
    static int[] result, counting;


    public static void main(String[] args) {
        printIntArray(arr);
        arr = CountingSort(arr);
        printIntArray(arr);
    }

    private static int[] CountingSort(int[] arr) {
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        counting = new int[max + 1];
        result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        // 누적 합 해주기
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }
        /*
         * i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤 counting 배열의 값을 인덱스로 하여 result에 value
         * 값을 저장한다.
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--counting[arr[i]]] = arr[i];
        }
        return result;
    }

    private static void printIntArray(int[] a) {
        for (int num : a)
            System.out.print(num + "");
        System.out.println();
    }
}
