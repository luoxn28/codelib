package sort;

import static sort.util.SortUtil.arraySwap;
import static sort.util.SortUtil.isSorted;
import static sort.util.SortUtil.randomArray;

/**
 * 插入排序
 *
 * 每步将一个待排序的纪录，按其关键码值的大小插入前面已经排序的元素序列中适当位置上，
 * 直到全部插入完为止。插入排序是稳定的排序算法。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = randomArray(100, 100);

        insertSort(array);
        System.out.println(isSorted(array));
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j-1]; j--) {
                arraySwap(array, j, j-1);
            }
        }
    }
}
