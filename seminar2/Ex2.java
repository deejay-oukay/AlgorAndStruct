package seminar2;

import java.util.Arrays;
import java.util.Random;

public class Ex2 {
    private static final Random random = new Random();
    private static int[] arr;

    public static void main(String[] args) {
        arr = prepareArray(10);
        printArray();
        Arrays.sort(arr);
        printArray();
        System.out.println(binarySearch(7, arr, 0, arr.length));
    }

    private static void printArray() {

        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static int[] prepareArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    private static int binarySearch(int value, int[] arr, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = (max - min) / 2 + min;
        }
        if (arr[middle] < value) {
            return binarySearch(value, arr, middle + 1, max);
        } else if (arr[middle] > value) {
            return binarySearch(value, arr, min, middle - 1);
        } else
            return middle;
    }
}
