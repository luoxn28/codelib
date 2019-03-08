package sort;

import static sort.util.SortUtil.arraySwap;
import static sort.util.SortUtil.isSorted;
import static sort.util.SortUtil.randomArray;

/**
 * 冒泡排序
 *
 * 冒泡排序也是一种直观简单的排序算法，它重复地走访要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。冒泡排序是一种稳定的排序。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = randomArray(100, 100);

        bubbleSort(array);
        System.out.println(isSorted(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    arraySwap(array, j, j+1);
                }
            }
        }
    }
}
