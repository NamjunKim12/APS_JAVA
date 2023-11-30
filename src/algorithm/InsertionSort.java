package algorithm;

public class InsertionSort {
    static int[] arr = {9, 4, 7, 2, 6, 3, 5, 8, 1};

    public static void main(String[] args) {
        printIntArray(arr);
        InsertionSort(arr);
        printIntArray(arr);
    }

    public static int[] InsertionSort(int[] arr) {
        int j = 0;
        int temp = 0;
        // 인덱스 j에 해당하는 원소에 대해
        // 인덱스 i 까지 판별하여 큰값이 있다면 원소를 앞으로 계속 보낸다.
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];// 한칸씩 뒤로 밀어내고
                j = j - 1;
            }

            arr[j + 1] = temp;// 마지막 빈칸에 선택한 숫자를 넣어준다.
        }

        return arr;
    }

    private static void printIntArray(int[] a) {
        for (int num : a)
            System.out.print(num + "");
        System.out.println();
    }
}
