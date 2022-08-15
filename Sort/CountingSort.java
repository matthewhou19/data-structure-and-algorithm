import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int min = nums[0];
        int max = nums[1];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }

        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[countIndex(num, min)] += 1;
        }

        int start = 0;
        int[] starts = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            starts[i] = start;
            start = start + counts[i];
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int  num : copy) {
            nums[starts[countIndex(num, min)]]= num;
            starts[countIndex(num, min)] += 1;
        }

    }

    private static int countToValue(int countIndex, int min) {
        return countIndex + min;
    }

    private static int countIndex(int value, int min) {
        return value - min;
    }
}
