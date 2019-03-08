package array;

/**
 * 数组最大值最小值问题
 *
 * 1. 数据最大值与最小值的差值
 * 2. 数组最大值与最小值的差值，不过最大值下标大于最小值下标
 * 3. 数组最大值与最小值的差值，不过最大值下标小于最小值下标
 */
public class ArrayMaxMinValue {

    public static void main(String[] args) {
        int[] array = new int[] {3, 2, 3, 1, 2};

        System.out.println(maxMinDifferenceValue(array));
        System.out.println(maxAfterMinDifferenceValue(array));
        System.out.println(maxBeforeMinDifferenceValue(array));
    }

    /**
     * 数据最大值与最小值的差值为多少
     */
    private static int maxMinDifferenceValue(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        return max - min;
    }

    /**
     * 数组最大值与最小值的差值，不过最大值下标大于最小值下标
     *
     * 相关问题：
     *   [leetcode 121] 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    private static int maxAfterMinDifferenceValue(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            result = Math.max(result, array[i] - min);
            min = Math.min(min, array[i]);
        }

        return result;
    }

    /**
     * 数组最大值与最小值的差值，不过最大值下标小于最小值下标
     */
    private static int maxBeforeMinDifferenceValue(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            result = Math.max(result, max - array[i]);
        }

        return result;
    }
}
