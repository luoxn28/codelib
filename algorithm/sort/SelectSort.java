package sort;

import sort.util.SortUtil;

import static sort.util.SortUtil.arraySwap;

/**
 * 选择排序
 *
 * 选择排序是一种直观简单的排序算法，它每次从待排序的数据元素中选出最小(或者最大)元素存放到序列的起始位置，
 * 直到全部待排序的数据元素排完。注意，选择排序并不是稳定的排序。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = SortUtil.randomArray(100, 100);

        selectSort(array);
        System.out.println(SortUtil.isSorted(array));
    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                arraySwap(array, min, i);
            }
        }
    }
}
