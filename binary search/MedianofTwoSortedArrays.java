
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return 0.0;

        int len = nums1.length + nums2.length;

        int edge = 0;
        if (len % 2 == 1) {
            edge = len / 2;
        } else {
            edge = len / 2 - 1;
        }

        int left = 0;
        int right = 0;

        if (nums1.length == 0) {
            left = nums2[0];
        } else if (nums2.length == 0) {
            left = nums1[0];
        } else {
            left = Math.min(nums1[0], nums2[0]);
        }

        if (nums1.length == 0) {
            right = nums2[nums2.length - 1];
        } else if (nums2.length == 0) {
            right = nums1[nums1.length - 1];
        } else {
            right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        }



        while (right > left + 1) {
            int mid = (right + left) / 2;
            int count = 0;
            for (int val : nums1) {
                if (val < mid) {
                    count++;
                }
            }

            for (int val: nums2) {
                if (val < mid) {
                    count++;
                }
            }

            if (count <= edge) {
                left = mid;
            } else {
                right = mid;
            }

        }
        if (len % 2 == 1) {
            return left;
        } else {
            return (((double) left + (double) right)) / 2;
        }


    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {0, 0, 0};
        int[] nums2 = new int[] {-1, 0, 0, 0, 0, 1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
