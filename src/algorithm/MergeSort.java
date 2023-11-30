package algorithm;

public class MergeSort {
    public static int[] src;

    public static void main(String[] args) {
        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};

        printArray(src);
        mergeSort(src);
        printArray(src);
    }

    private static void printArray(int[] a) {
        for (int num : a)
            System.out.print(num + "");
        System.out.println();
    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    private static void mergeSort(int arr[], int start, int end, int tmp[]) {
        // 기저 조건 (탈출문)
        if (start >= end) return;

        // 1. 분할 (divide)
        int mid = (start + end) / 2;

        // 2. 정복 (conquer)
        mergeSort(arr, start, mid, tmp);
        mergeSort(arr, mid + 1, end, tmp);

        // 3. 결합(combine)
        merge(arr, tmp, start, mid, end);
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            // part1이 더 작으면 1뎁스 위의 arr에 part1의 원소를 삽입
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        // part1에 데이터가 남아있는 경우 남은 데이터를 차례로 삽입
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}

