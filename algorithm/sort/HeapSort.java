package sort;

import static sort.util.SortUtil.*;

/**
 * 堆排序
 * 堆排序是用堆来实现的一种排序算法，堆排序分为两个阶段，在堆的构造阶段中，我们将原始数据重新组织安排
 * 进一个堆中；然后在下沉排序阶段，我们从堆中按照递减顺序取出所有元素并得到排序算法
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] array = randomArray(100, 100);

        heapSort(array);
        System.out.println(isSorted(array));
    }

    private static void heapSort(int[] array) {
        // 堆构建
        int right = array.length - 1;
        for (int i = right / 2; i >= 0; i--) {
            sink(array, i, right);
        }

        // 堆排序
        while (right >= 0) {
            arraySwap(array, 0, right--);
            sink(array, 0, right);
        }
    }

    private static void sink(int[] array, int i, int right) {
        while (2 * i <= right) {
            int child = 2 * i;
            if (child < right && array[child] < array[child+1]) {
                child++;
            }

            if (array[i] >= array[child]) {
                break;
            }
            arraySwap(array, i, child);
            i = child;
        }
    }
}
