package algorithm;

public class BinarySearch {
    static int[] arr = new int[100];
    static int mid;

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i + 1;
        }
        System.out.println(binarySearch1(30, 1, 100));
    }

    public static int binarySearch1(int key, int low, int high) {
        if (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid + 1;
            }
            if (key < arr[mid]) {
                return binarySearch1(key, low, mid - 1);
            }

            if (key > arr[mid]) {
                return binarySearch1(key, mid + 1, high);
            }

        }
        return -1;
    }

    public static int binarySearch2(int key, int low, int high) {
        while (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
