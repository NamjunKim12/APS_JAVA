package algorithm;

public class BubbleSort {
    static int[] arr = {9, 4, 7, 2, 6, 3, 5, 8, 1};

    public static void main(String[] args) {
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + "");
        System.out.println();
    }
}
