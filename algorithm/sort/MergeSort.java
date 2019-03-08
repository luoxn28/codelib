package sort;

import static sort.util.SortUtil.isSorted;
import static sort.util.SortUtil.randomArray;

/**
 * 归并排序是将两个有序的数组归并成一个更大的有序数组。要将一个数组排序，
 * 可以先（递归的）将他分成两半分别排序，让后将结果归并起来。
 * 它能够保证将任意长度为N的数组排序所需时间和NlogN成正比；
 * 它的主要缺点就是所需的额外空间和N成正比。归并排序是稳定的排序算法。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = randomArray(100, 100);

        mergeSort(array, 0, array.length - 1);
        System.out.println(isSorted(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int k = 0;
        int[] tmpArray = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (array[j] < array[i]) {
                tmpArray[k++] = array[j++];
            } else {
                tmpArray[k++] = array[i++];
            }
        }
        while (i <= mid) {
            tmpArray[k++] = array[i++];
        }
        while (j <= right) {
            tmpArray[k++] = array[j++];
        }

        // 数据写回
        for (i = 0; i < tmpArray.length; i++) {
            array[left + i] = tmpArray[i];
        }
    }
}
