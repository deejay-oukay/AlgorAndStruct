package dz2;

import java.util.Random;

public class HeapSort {
    private static final Random random = new Random();
    private static int[] arr;

    public static void main(String[] args) {
        arr = prepareArray(100);
        printArray();
        sort(arr);
        printArray();
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
            result[i] = random.nextInt(100);
        }
        return result;
    }

    private static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int root) {
        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < size && arr[left] > arr[max])
            max = left;
        if (right < size && arr[right] > arr[max])
            max = right;
        if (max != root) {
            int temp = arr[root];
            arr[root] = arr[max];
            arr[max] = temp;
            heapify(arr, size, max);
        }
    }
}
