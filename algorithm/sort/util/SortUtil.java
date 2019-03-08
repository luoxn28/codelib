package sort.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiangnan.
 */
public class SortUtil {

    public static int[] randomArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(bound);
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void arraySwap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }
}
