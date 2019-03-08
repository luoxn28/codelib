package sort;

import static sort.util.SortUtil.*;

/**
 * 快速排序
 *
 * 快速排序是一种分治的排序算法，它将一个数组分成两个子数组，将两部分独立地排序。
 * 快速排序和归并排序是互补的：归并排序将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序；
 * 而快速排序的方式是当两个子数组有序时整个数组也就自然有序了。归并排序中，递归发生在处理整个数组之前，
 * 一个数组被分为两半；快速排序中，递归调用发生在处理整个数组之后，切分的位置取决于数组的内容。
 */
public class FastSort {

    public static void main(String[] args) {
        int[] array = randomArray(100, 100);

        fastSort(array, 0, array.length - 1);
        System.out.println(isSorted(array));
    }

    private static void fastSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = part(array, left, right);
            fastSort(array, left, mid - 1);
            fastSort(array, mid + 1, right);
        }
    }

    private static int part(int[] array, int left, int right) {
        int num = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= num) {
                arraySwap(array, i++, j);
            }
        }
        arraySwap(array, i, right);

        return i;
    }
}
