class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0, medianIndex = 0;
        double median = 0;

        if (merged.length % 2 == 1) {
                medianIndex = (merged.length - 1) / 2;
        } else {
                medianIndex = merged.length / 2;
        }

        while (i < nums1.length && j < nums2.length && k <= medianIndex)
                merged[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];

        while (i < nums1.length && k <= medianIndex) {
                merged[k++] = nums1[i++];
        }

        while (j < nums2.length && k <= medianIndex) {
                merged[k++] = nums2[j++];
        }

        if (merged.length % 2 == 1) {
                median = merged[medianIndex];
        } else {
                median = (merged[medianIndex] + merged[medianIndex - 1]) * 1.0 / 2;
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        // System.out.println(findMedianSortedArrays([1, 2], [3, 4]));
    }
}
