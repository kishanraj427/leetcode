// 33. Search in Rotated Sorted Array

/*  
0ms Beats -> 100%
Memory 41.86MB -> Beats 92.96%

*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (n == 2) {
            if (nums[0] == target) return 0;
            else if (nums[1] == target) return 1;
            else return -1;
        }

        // Check if array is not rotated
        if (nums[0] < nums[n - 1]) {
            return binarySearch(nums, target, 0, n - 1);
        }

        // Find the pivot index
        int pivot = findPivot(nums, 0, n - 1);

        // Check if target is at pivot index
        if (nums[pivot] == target) return pivot;

        // Search for target
        if (target > nums[n - 1]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot, n - 1);
        }
    }

    private int findPivot(int[] nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    return mid + 1;
                } else if (nums[mid] > nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                } else {
                    return 0;
                }
            } else {
                if (nums[mid] < nums[mid - 1]) {
                    return mid;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}