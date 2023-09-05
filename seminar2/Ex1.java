package seminar2;

import java.util.Random;

public class Ex1 {
    private static final Random random = new Random();
    private static int[] arr;

    public static void main(String[] args) {
        arr = prepareArray(100000);
        // printArray();
        long startTime1 = System.nanoTime();
        BubbleSortArray();
        long endTime1 = System.nanoTime();
        System.out.println(endTime1 - startTime1);

        arr = prepareArray(100000);
        long startTime2 = System.nanoTime();
        QuickSortArray(arr, 0, arr.length - 1);
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - startTime2);
        // printArray();
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

    private static void BubbleSortArray() {
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++)
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
        } while (flag);
    }

    private static void QuickSortArray(int[] arr, int startPos, int endPos) {
        int pivot = arr[(startPos + endPos) / 2];
        int left = startPos;
        int right = endPos;
        do {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                right--;
                left++;
            }
        } while (left <= right);
        if (right > startPos)
            QuickSortArray(arr, startPos, right);
        if (left < endPos)
            QuickSortArray(arr, left, endPos);
    }
}