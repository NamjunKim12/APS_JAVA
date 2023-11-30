package algorithm;

public class SelectionSort {
    static int[] arr = {9, 4, 7, 2, 6, 3, 5, 8, 1};

    public static void main(String[] args) {
        printIntArray(arr);
        selectionSort(arr);
        printIntArray(arr);
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 첫번째 포인터 i를 기준으로 잡는다
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 두번째 포인터 j와 비교하며 min_idx를 갱신한다
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            // min_idx의 원소가 i번째에 있지 않으면 i번째 원소와 스왑
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    private static void printIntArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + "");
        System.out.println();
    }
}
